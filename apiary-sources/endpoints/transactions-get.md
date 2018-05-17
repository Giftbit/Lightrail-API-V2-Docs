### Get Transactions [GET /transactions{?limit}{?offset}{?transactionType}{?minCreatedDate}{?maxCreatedDate}]

Get multiple Transactions.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + transactionType (string, optional) - Filter by the transactionType.
    + minCreatedDate (string, optional) - Filter by the minimum createdDate, inclusive.
    + maxCreatedDate (string, optional) - Filter by the maximum createdDate, inclusive.

+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1
        
    + Attributes (array[Transaction])

    + Body

            [
                {
                    "id": "unique-id-123",
                    "transactionType": "debit",
                    "currency": "XXX",
                    "steps": [
                        {
                            "rail": "lightrail",
                            "id": "vs_1",
                            "currency": "XXX",
                            "balanceBefore": 5500,
                            "balanceAfter": 3000,
                            "balanceChange": -2500
                        }
                    ],
                    "remainder": 0,
                    "simulated": false,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z",
                    "metadata": {
                        "note": "Reduce loyalty points after 3mo contact inactivity"
                    }
                }
            ]

### Get Transaction [GET /transactions/{id}]

Get Transaction by id.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Transaction to get.

+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {
                "id": "unique-id-123",
                "transactionType": "debit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "id": "vs_1",
                        "currency": "XXX",
                        "balanceBefore": 5500,
                        "balanceAfter": 3000,
                        "balanceChange": -2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo contact inactivity"
                }
            }
