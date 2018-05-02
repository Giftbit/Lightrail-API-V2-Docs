### Get Customers [GET /customers{?limit}{?offset}{?firstName}{?lastName}{?email}{?tags}{?minCreatedDate}{?maxCreatedDate}{?minUpdatedDate}{?maxUpdatedDate}]

Get multiple Customers.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + firstName (string, optional) - Filter by the firstName.
    + lastName (string, optional) - Filter by the lastName.
    + email (string, optional) - Filter by the email.
    + tags (number, optional) - Filter by tags.
    + minCreatedDate (string, optional) - Filter by the minimum createdDate, inclusive.
    + maxCreatedDate (string, optional) - Filter by the maximum createdDate, inclusive.
    + minUpdatedDate (string, optional) - Filter by the minimum updatedDate, inclusive.
    + maxUpdatedDate (string, optional) - Filter by the maximum updatedDate, inclusive.
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1

    + Attributes (array[Customer])

    + Body

            [
                {
                    "customerId": "unique-id-123",
                    "firstName": "Jeffrey",
                    "lastName": "Lebowski",
                    "email": "thedude@example.com",
                    "tags": [],
                    "metadata": {
                        "alias": "El Duderino"
                    },
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            ]

### Get Customer [GET /customers/{customerId}]

Get Customer by customerId.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + customerId (string) - the customerId of the Customer to get.

+ Response 200 (application/json)
    + Attributes (Customer)

    + Body

            {
                "customerId": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "tags": [],
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
