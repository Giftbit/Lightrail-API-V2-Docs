### Set a Promotion Value's Customer [PUT /values/promotion/{id}/customer]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - The id of the Customer to set as owner of the Value.
        
    + Body
    
            {
                "customer": "unique-id-123"
            }

+ Parameter
    + id (string) - the id of the Value to set the Customer of.

+ Response 200 (application/json)
    + Attributes (Customer)

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
