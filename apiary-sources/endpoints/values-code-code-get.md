### Get Value code by code [GET /values/code/{code}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Value to get the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{value.code}}

    + Body

            {
                "code": "BLACKFRIDAY2077"
            }
