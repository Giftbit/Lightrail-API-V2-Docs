### Get Value Code [GET /values/{id}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Value to get the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{value.code}}

    + Body

            {
                "code": "BLACKFRIDAY20%"
            }
