### Delete a Giftcard's code [DELETE /values/giftcards/{id}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Giftcard to delete the code of.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
