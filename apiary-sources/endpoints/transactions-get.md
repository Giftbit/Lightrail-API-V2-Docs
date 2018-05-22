### Get a Transaction [GET /transactions/{id}]

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
                        "amount": -2500,
                        "balance": {
                            "before": 5500,
                            "after": 3000,
                            "change": -2500
                        },
                        "uses": null
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

### List Transactions [GET /transactions{?limit}{?offset}{?transactionType}{?minCreatedDate}{?maxCreatedDate}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + transactionType (string, optional) - {{filter.transactionType}}
    + minCreatedDate (string, optional) - {{filter.minCreatedDate}}
    + maxCreatedDate (string, optional) - {{filter.maxCreatedDate}}

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
