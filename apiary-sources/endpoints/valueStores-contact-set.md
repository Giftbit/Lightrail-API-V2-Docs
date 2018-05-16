### Set Value Store Contact [PUT /valueStores/{valueStoreId}/contact]

Set a Value Store's Contact.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + contact (string, required) - The ID of the Contact who should be associated with the Value Store.
        
    + Body
    
            {
                "contact": "unique-id-123"
            }

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to set the Contact of.

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {
                "contact": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
