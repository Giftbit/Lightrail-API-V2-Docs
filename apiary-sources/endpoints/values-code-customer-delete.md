### Delete a Value's customer by code [DELETE /values/code/{code}/customer]

+ Request (application/json)

    Remove the Customer as the owner of a Value.  The Customer's info is not deleted.

    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Value to remove the Customer from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
