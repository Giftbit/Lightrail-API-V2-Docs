### Update Contact [PUT /contacts/{contactId}]

Update fields that are sent and leave unspecified values unchanged.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + contactId (string, required) - {{contact.contactId}}
        + firstName (string, optional) - {{contact.firstName}}
        + lastName (string, optional) - {{contact.lastName}}
        + email (string, optional) - {{contact.email}}
        + tags (array[string], optional) - {{tags}}
        + metadata (string, optional) - {{contact.metadata}}

    + Body

            {
                "metadata": {
                    "alias": "El Duderino"
                }
            }
            
+ Parameter
    + contactId (string) - the contactId of the Contact to update.
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "contactId": "unique-id-123",
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
