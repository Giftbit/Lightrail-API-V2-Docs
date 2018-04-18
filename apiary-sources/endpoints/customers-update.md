### Update Customer [PUT /customers/{customerId}]

Update a Customer by customerId.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + customerId (string, required) - {{customer.customerId}}
        + firstName (string, optional) - {{customer.firstName}}
        + lastName (string, optional) - {{customer.lastName}}
        + email (string, optional) - {{customer.email}}
        + metadata (string, optional) - {{customer.metadata}}

    + Body

            {
                "customerId": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "metadata": {
                    "alias": "El Duderino"
                }
            }
            
+ Parameter
    + customerId (string) - the customerId of the Customer to update.
    
+ Response 200
    + Attributes
        + customerId (string, required) - {{customer.customerId}}
        + firstName (string, optional) - {{customer.firstName}}
        + lastName (string, optional) - {{customer.lastName}}
        + email (string, optional) - {{customer.email}}
        + metadata (string, optional) - {{customer.metadata}}
        + createdDate (string, required) - {{customer.createdDate}}
        + updatedDate (string, required) - {{customer.updatedDate}}

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
                "updatedDate": "2018-04-17T23:58:19.036Z"
            }
