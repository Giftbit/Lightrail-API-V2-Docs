### Create Customer [POST /customers]

Create a new Customer.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + customerId (string, required) - {{customer.customerId}}
        + firstName (string, optional) - {{customer.firstName}}
        + lastName (string, optional) - {{customer.lastName}}
        + email (string, optional) - {{customer.email}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{customer.metadata}}

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
    
+ Response 200 (application/json)
    + Attributes (Customer)

    + Body
            
            {
                "customerId": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",'
                "tags": [],
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
