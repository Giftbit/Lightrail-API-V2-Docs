### Delete a Value's Contact by code [DELETE /values/code/{code}/contact]

+ Request (application/json)

    Remove the Contact as the owner of a Value.  The Contact's info is not deleted.

    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Value to remove the Contact from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
