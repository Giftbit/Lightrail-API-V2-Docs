### Set a Value's Contact by code [PUT /values/code/{code}/contact]

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
    + code (string) - the code of the Value to set the Contact of.

+ Response 200 (application/json)
    + Attributes (Contact)

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
