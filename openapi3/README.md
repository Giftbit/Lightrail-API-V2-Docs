# OpenAPI 3 Documentation

This directory holds the [OpenAPI 3 (formerly Swagger)](https://swagger.io/) specification for Lightrail.

You can open this file in [Insomnia](https://insomnia.rest/) or [Postman](https://learning.postman.com/docs/integrations/available-integrations/working-with-openAPI/) to start playing with the rest calls.

## Editing

Most of the file is edited by hand.  The [online Swagger editor](https://editor.swagger.io/) can help a bit.

The `components.examples` section is updated automatically with calls defined in `requests.json`.  To run the script you need [Node](https://nodejs.org/en/) installed and dependencies with `npm i`.  Then run the script with `npm run refreshExamples`.

If you could also run `npm run lint` and fix any linting errors that would be appreciated.
