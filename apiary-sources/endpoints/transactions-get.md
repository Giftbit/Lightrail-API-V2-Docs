### Get a Transaction [GET /transactions/{id}]

+ Parameter
    + id (string) - the ID of the Transaction to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

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
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo contact inactivity"
                }
            }

### List Transactions [GET /transactions{?limit}{?transactionType}{?createdDate}{?maxCreatedDate}]

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + transactionType (string, optional) - {{filter.transactionType}}
    + createdDate (string, optional) - {{filter.createdDate}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
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
                            "valueId": "vs_1",
                            "code": null,
                            "contactId": null,
                            "balanceBefore": 5500,
                            "balanceAfter": 3000,
                            "balanceChange": -2500
                        }
                    ],
                    "totals": {
                        "remainder": 0
                    },
                    "simulated": false,
                    "createdDate": "2018-04-17T23:20:08.000Z",
                    "updatedDate": "2018-04-17T23:20:08.000Z",
                    "metadata": {
                        "note": "Reduce loyalty points after 3mo contact inactivity"
                    }
                }
            ]
