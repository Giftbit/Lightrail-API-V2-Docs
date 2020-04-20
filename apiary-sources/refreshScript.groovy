import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import sun.net.www.protocol.https.HttpsURLConnectionImpl

File requests = new File("requests.json")
List<File> filesToProcess = new File("endpoints").listFiles()

def json = fetchTestDataFromFile(requests)

String userJwt = "eyJ2ZXIiOjMsInZhdiI6MSwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJnIjp7Imd1aSI6InVzZXItYzBlNGJjODllYzcxNGU2MTk5MTk5ZTgzMjI0NTllMmUtVEVTVCIsImdtaSI6InVzZXItYzBlNGJjODllYzcxNGU2MTk5MTk5ZTgzMjI0NTllMmUtVEVTVCIsInRtaSI6InVzZXItYzBlNGJjODllYzcxNGU2MTk5MTk5ZTgzMjI0NTllMmUtVEVTVCJ9LCJhdWQiOiJBUElfS0VZIiwiaXNzIjoiU0VSVklDRVNfVjEiLCJpYXQiOjE1MzI0NTc3NDQuMjg5LCJqdGkiOiJiYWRnZS0zOThiNmM5ZmE1Yjg0ODM1OWQ2MWRmMmYzYmQ1YmZmYSIsInBhcmVudEp0aSI6ImJhZGdlLTVkYzU4NzI0MDVjNjQ4NjA4OWQ1ZDcyMmYxZDU2MzQwIiwic2NvcGVzIjpbXSwicm9sZXMiOlsiYWNjb3VudE1hbmFnZXIiLCJjb250YWN0TWFuYWdlciIsImN1c3RvbWVyU2VydmljZU1hbmFnZXIiLCJjdXN0b21lclNlcnZpY2VSZXByZXNlbnRhdGl2ZSIsInBvaW50T2ZTYWxlIiwicHJvZ3JhbU1hbmFnZXIiLCJwcm9tb3RlciIsInJlcG9ydGVyIiwic2VjdXJpdHlNYW5hZ2VyIiwidGVhbUFkbWluIiwid2ViUG9ydGFsIl19.tmP6yn05U1f5Wv5626MCNbz5aLyhw9Br5gLg00_6wzk"

Map calls = [:]
for (Map call in json.calls) {
    if (!call.callId) {
        throw new Exception("No callId. Invalid input ${call}.")
    }
    if (call.get(call.callId)) {
        throw new Exception("Invalid input. Duplicate callId ${call.callId}")
    }
    if (!call.endpoint) {
        throw new Exception("Invalid input. Call ${call}.")
    }
    call = checkForFunctionReplacements(call)
    calls.put(call.callId, call)
}

def callsToDo = calls.entrySet()

while (callsToDo) {
    println "CallsTodo.size() == ${callsToDo.size()}."
    for (entry in callsToDo) {
        String key = entry.key
        Map call = entry.value as Map

        call.attempts = call.attempts ? call.attempts + 1 : 1
        if (call.attempts > 10) {
            println "Error: ${call.toString()} exceeded 10 retry attempts."
            throw new Exception("${call.toString()} exceeded number of attempts.")
        }
        if (!call.finishedReplacement) {
            try {
                call = checkForReplacements(call, calls) as Map
                call.finishedReplacement = true
            } catch (TestDataCallDependencyException e) {
                call.finishedReplacement = false
            }
        }

        if (call.finishedReplacement) {
            call.response = makeRequestAgainstLightrail(call, userJwt)
        } else {
            call.response = [status: 424]
        }
        calls.put(key, call)
    }
    callsToDo = callsToDo.findAll { it.value.response.status != 200 && it.value.response.status != 201 && it.value.response.status != 204}
}

File outputDirectory = new File("generated/endpoints");
if (!outputDirectory.exists()) {
    println "creating output directory"
    outputDirectory.mkdirs();
}

println "finished creating directory"

def outputRequestJSON = new File("generated/requestsOutput.json")
outputRequestJSON.write(JsonOutput.prettyPrint(JsonOutput.toJson(calls)));

for (file in filesToProcess) {
    String fileText = file.text
    fileText = checkForReplacements(fileText, calls, true) as String
    if (fileText.contains("REQUEST_REPLACEMENT")) {
        throw new Exception("File withname ${file.name} contains unreplaced text!!!")
    }
    def outputFile = new File("generated/endpoints/${file.name}")
    outputFile.write(fileText)
}

static def checkForFunctionReplacements(def input) throws TestDataCallDependencyException {
    if (input instanceof Map) {
        for (entry in input.entrySet()) {
            entry.value = checkForFunctionReplacements(entry.value)
        }
        return input
    } else if (input instanceof List) {
        for (entry in input) {
            entry = checkForFunctionReplacements(entry)
        }
        return input
    } else if (input instanceof String) {
        String uuidReplacement = input.find(/\{UUID\(\)\}/)
        if (uuidReplacement) {
            println "found uuid replacement"
            input = input.replace(uuidReplacement, UUID.randomUUID().toString().substring(0,20))
        }
        return input
    } else {
        return input
    }
}

static def checkForReplacements(def input, Map responses, boolean replaceAsJson = false) throws TestDataCallDependencyException {
    if (input instanceof Map) {
        for (entry in input.entrySet()) {
            entry.value = checkForReplacements(entry.value, responses)
        }
        return input
    } else if (input instanceof List) {
        for (entry in input) {
            entry = checkForReplacements(entry, responses)
        }
        return input
    } else if (input instanceof String) {
        String uuidReplacement = input.find(/\{UUID()\}/)
        if (uuidReplacement) {
            println "found uuid replacement"
            input = input.replace(uuidReplacement, UUID.randomUUID().toString())
        }
        List<String> responseReplacements = input.findAll(/\{REQUEST_REPLACEMENT\:(.*?)\}/)
        for (replacement in responseReplacements) {
            println "found something to replace: " + replacement
            String responseKeyString = replacement
            responseKeyString = responseKeyString.replace("{REQUEST_REPLACEMENT:", "").replace("}", "")
            List<String> responseKeys = responseKeyString.split("\\.")
            def value = responses
            for (key in responseKeys) {
                value = value.get(key)
                if (value == null) {
                    throw new TestDataCallDependencyException("Dependency does not exist yet. replacement: ${replacement}. key ${key}")
                }
            }
            if (replaceAsJson) {
//                value = JsonOutput.prettyPrint(JsonOutput.toJson(value))
                value = JsonOutput.toJson(value)
            }
            println "replacement value: " + value
            input = input.replace(replacement, value as String)
        }
        return input
    } else {
        return input
    }
}

static def fetchTestDataFromFile(File file) {
    def slurper = new JsonSlurper()
    return slurper.parse(file)
}

def makeRequestAgainstLightrail(Map request, String userJwt) {
    println "Making request: ${request}"
    URLConnection connection = new URL("https://api.lightrailstaging.net/v2" + request.endpoint).openConnection();
    connection.setDoOutput(true)
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("Authorization", "Bearer ${userJwt}")
    if (request.method == "PATCH") {
        connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        connection.setRequestMethod("POST");
    } else {
        connection.setRequestMethod(request.method)
    }

    if (request.method == "POST" || request.method == "PATCH") {
        String message = JsonOutput.toJson(request.body)
        println "requestBody" + message
        connection.getOutputStream().write(message.getBytes("UTF-8"));
    }
    return getResponse(connection)
}

Map getResponse(HttpsURLConnectionImpl result) {
    def response = [status: result.getResponseCode()]
    println result
    println response.status
    if (response.status == 200 || response.status == 201) {
        println "in here"
        response.body = new JsonSlurper().parse(result.getInputStream().getText().toCharArray())
        println response.body
    } else if (response.status == 400 || response.status == 409) {
        println "nope, in here"
        throw new Exception("Requested failed against api.")
    }
    return response
}

class TestDataCallDependencyException extends Exception {

    TestDataCallDependencyException() {
        super()
    }

    TestDataCallDependencyException(String message) {
        super(message)
    }
}

println "FINISHED REFRESH SCRIPT"