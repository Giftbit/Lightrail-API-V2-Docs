### Set Value Store Customer [PUT /valueStores/{valueStoreId}/customer]

Set a Value Store's Customer.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + customerId (string, required) - The customerId to set as the Customer owning the Value Store.
        
    + Body
    
            {
                "customerId": "unique-id-123"
            }

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to set the Customer of.

+ Response 200
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
