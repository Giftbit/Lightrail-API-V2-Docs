### Set a Giftcard's Contact [PUT /values/giftcard/{id}/contact]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + contact (string, required) - The id of the Contact to set as owner of the Giftcard.
        
    + Body
    
            {
                "contact": "unique-id-123"
            }

+ Parameter
    + id (string) - the id of the Giftcard to set the Contact of.

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
