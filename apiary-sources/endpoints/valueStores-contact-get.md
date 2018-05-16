### Get Value Store's Contact [GET /valueStores/{valueStoreId}/contact]

Get a Value Store's contact.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to get the Contact of.

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
