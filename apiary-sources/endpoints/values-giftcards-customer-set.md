### Set Value Customer [PUT /values/{id}/customer]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + customerId (string, required) - The customerId to set as the Customer owning the Value.
        
    + Body
    
            {
                "customerId": "unique-id-123"
            }

+ Parameter
    + id (string) - the id of the Value to set the Customer of.

+ Response 200 (application/json)
    + Attributes (Customer)

    + Body

            {
                "customerId": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
