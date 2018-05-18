### Get a Giftcard's Contact [GET /values/giftcards/{id}/contact]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Giftcard to get the Contact of.

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {
                "id": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
