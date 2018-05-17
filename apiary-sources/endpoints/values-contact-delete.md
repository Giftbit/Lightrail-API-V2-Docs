### Delete Value Contact [DELETE /values/{id}/contact]

+ Request (application/json)

    Remove the Contact as the owner of a Value.  The Contact's info is not deleted.

    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Value to remove the Contact from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }