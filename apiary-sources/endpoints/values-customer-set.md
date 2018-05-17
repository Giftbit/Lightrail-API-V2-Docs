### Set Value Contact [PUT /values/{id}/contact]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + contactId (string, required) - The contactId to set as the Contact owning the Value.
        
    + Body
    
            {
                "contactId": "unique-id-123"
            }

+ Parameter
    + id (string) - the id of the Value to set the Contact of.

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {
                "contactId": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
