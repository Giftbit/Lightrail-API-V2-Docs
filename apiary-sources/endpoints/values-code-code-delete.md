### Delete a Value's code by code [DELETE /values/byCode/{code}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Value to delete the code of.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
