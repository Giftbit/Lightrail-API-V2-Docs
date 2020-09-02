import dotEnvSafe = require("dotenv-safe");
import fs = require("fs");
import requestsJson = require("./requests.json");
import superagent = require("superagent");
import yaml = require("js-yaml");
import uuid = require("uuid");

const openApiFileName = "./openapi3.yaml";

interface OpenApiSpec {
    components: {
        examples: {
            [key: string]: {
                value: any;
                summary?: string;
                description?: string;
            }
        }
    }
}

type ResponseMap = {[key: string]: superagent.Response};

/**
 * Recursively go through objects and replace template strings.
 * Supports:
 * - {UUID()} - a randomly generated UUID
 * - {REQUEST_REPLACEMENT:<callId>.body.<path>} - part of a previous request where <callId>
 *     is the callId of that request and <path> is dot-notation path to part of the body.
 *
 * There is no loop-detection.
 */
function runReplacements<T>(obj: T, context: {previousResponses: ResponseMap}): T {
    if (!obj) {
        // no-op
    } else if (Array.isArray(obj)) {
        for (let i = 0; i < obj.length; i++) {
            obj[i] = runReplacements(obj[i], context);
        }
    } else if (typeof obj === "object") {
        for (const key in obj) {
            if (obj.hasOwnProperty(key)) {
                obj[key] = runReplacements(obj[key], context);
            }
        }
    } else if (typeof obj === "string") {
        obj = obj.replace(/{(.*)}/g, (match, p1) => {
            if (p1 === "UUID()") {
                return uuid.v4();
            } else if (p1.startsWith("REQUEST_REPLACEMENT:")) {
                let replacement: any = context.previousResponses;
                for (const part of p1.substring("REQUEST_REPLACEMENT:".length).split(".")) {
                    if (replacement[part] === undefined) {
                        throw new Error(`Could not find part ${part} in ${p1} in previous calls`);
                    }
                    replacement = replacement[part];
                }
                return replacement;
            }
            throw new Error(`Unknown processing command ${match}`);
        }) as any;
    }
    return obj;
}

/**
 * Update the `components.examples` section of an OpenAPI spec with
 * the requests specified in the JSON.
 */
async function refreshExamples(openApi: OpenApiSpec): Promise<void> {
    console.log("Making API requests...");

    const previousResponses: ResponseMap = {};
    const unupdatedExamples = Object.keys(openApi.components.examples);

    for (const call of requestsJson.calls) {
        if (!call.callId) {
            throw new Error(`Call missing callId: ${JSON.stringify(call)}`);
        }
        if (previousResponses[call.callId]) {
            throw new Error(`Duplicate callId: ${call.callId}`);
        }

        console.log(call.callId, call.method, call.endpoint);
        runReplacements(call, {previousResponses});
        const request = superagent(call.method, `https://api.lightrailstaging.net/v2${call.endpoint}`)
            .accept("application/json")
            .auth(process.env["LIGHTRAIL_API_KEY"], {type: "bearer"});
        if (call.body) {
            request.send(call.body);
        }
        if (call.allowFailure) {
            request.ok(() => true);
        }
        if (call.statusCode) {
            request.ok(response => response.status === call.statusCode);
        }
        const response = previousResponses[call.callId] = await request;

        const requestId = `${call.callId}Request`;
        if (openApi.components.examples[requestId] && call.body) {
            if (call.summary) {
                openApi.components.examples[requestId].summary = call.summary;
            }
            if (call.description) {
                openApi.components.examples[requestId].description = call.description;
            }
            openApi.components.examples[requestId].value = call.body;
            unupdatedExamples.splice(unupdatedExamples.indexOf(requestId), 1);
        }

        const responseId = `${call.callId}Response`;
        if (openApi.components.examples[responseId]) {
            if (call.summary) {
                openApi.components.examples[responseId].summary = call.summary;
            }
            if (call.description) {
                openApi.components.examples[responseId].description = call.description;
            }
            openApi.components.examples[responseId].value = response.body;
            unupdatedExamples.splice(unupdatedExamples.indexOf(responseId), 1);
        }
    }

    if (unupdatedExamples.length) {
        throw new Error(`The following examples were not updated: ${unupdatedExamples.join()}.  Check that is has a matching call in requests.json and ends in 'Request' or 'Response'.`);
    }
}

async function main(): Promise<void> {
    console.log("Reading", openApiFileName, "...");

    const openApiString = fs.readFileSync(openApiFileName, "utf-8");
    const openApi = yaml.safeLoad(openApiString, {
        onWarning: e => console.warn(e)
    }) as OpenApiSpec;

    await refreshExamples(openApi);

    const updatedOpenApiString = yaml.safeDump(openApi, {
        lineWidth: 9999999
    });

    // The yaml library is going to reformat the whole file and not preserve comments.
    // We only want to update the "examples" section.
    console.log("Writing", openApiFileName, "...");
    const mergedOpenApiString = openApiString.substring(0, openApiString.indexOf("\n  examples:"))
        + updatedOpenApiString.substring(updatedOpenApiString.indexOf("\n  examples:"), updatedOpenApiString.indexOf("  headers:"))
        + openApiString.substring(openApiString.indexOf("  headers:"))
    fs.writeFileSync(openApiFileName, mergedOpenApiString, "utf-8");
}

dotEnvSafe.config();
main().then(() => {}, err => console.error(err));
