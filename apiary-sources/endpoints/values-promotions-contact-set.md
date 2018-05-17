### Set a Promotion Value's Contact [PUT /values/promotion/{id}/contact]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - The id of the Contact to set as owner of the Value.
        
    + Body
    
            {
                "contact": "unique-id-123"
            }

+ Parameter
    + id (string) - the id of the Value to set the Contact of.

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
