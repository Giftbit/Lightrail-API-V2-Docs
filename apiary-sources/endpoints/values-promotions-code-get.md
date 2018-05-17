### Get a Promotion Value's code [GET /values/promotions/{id}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Promotion to get the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{value.code}}

    + Body

            {
                "code": "BLACKFRIDAY2077"
            }
