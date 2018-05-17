### Delete a Giftcard's Contact [DELETE /values/giftcards/{id}/contact]

+ Request (application/json)

    Remove the Contact as the owner of a Giftcard.  The Contact's info is not deleted.

    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Giftcard to remove the Contact from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
