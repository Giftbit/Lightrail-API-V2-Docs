### Get Value Code [GET /values/{valueId}/code]

Get a Value's code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueId (string) - the valueId of the Value to get the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{value.code}}

    + Body

            {
                "code": "BLACKFRIDAY20%"
            }
