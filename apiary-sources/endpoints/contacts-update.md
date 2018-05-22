### Update a Contact [PUT /contacts/{id}]

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{contact.id}}
        + firstName (string, optional) - {{contact.firstName}}
        + lastName (string, optional) - {{contact.lastName}}
        + email (string, optional) - {{contact.email}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{contact.metadata}}

    + Body

            {
                "metadata": {
                    "alias": "El Duderino"
                }
            }
            
+ Parameter
    + id (string) - the ID of the Contact to update.
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "id": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "tags": [],
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
            }
