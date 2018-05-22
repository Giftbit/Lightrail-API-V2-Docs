### Delete a Promotion Value's code [DELETE /values/promotions/{id}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Promotion to delete the code of.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
