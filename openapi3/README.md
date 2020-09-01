# OpenAPI 3 Documentation

This directory holds the [OpenAPI 3 (formerly Swagger)](https://swagger.io/docs/specification/about/) specification for Lightrail.

You can open the spec in [Insomnia](https://support.insomnia.rest/article/52-importing-and-exporting-data) or [Postman](https://learning.postman.com/docs/integrations/available-integrations/working-with-openAPI/) to start playing with the rest calls.

## Editing

Working on this file requires tools and scripts executed with [Node](https://nodejs.org/en/) and dependencies installed with `npm i`.

Most of the file is edited by hand.  The [online Swagger editor](https://editor.swagger.io/) can help a bit.  You can preview the HTML-rendered documentation with `npm run start`.  The preview will update automatically on file changes, but you will need to reload your browser manually.

The `components.examples` section is updated automatically with calls defined in `requests.json`.  To run the script and replace the examples: `npm run refreshExamples`.

Finally, you can render the HTML version of the doc with `npm run build`.
