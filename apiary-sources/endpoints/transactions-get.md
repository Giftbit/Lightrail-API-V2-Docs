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

+ Response 200
    + Attributes
        + count (number, required) - {{pagination.count}}
        + limit (number, required) - {{pagination.limit}}
        + offset (number, required) - {{pagination.offset}}
        + maxLimit (number, required) - {{pagination.maxLimit}}
        + transactions (array[Transaction], required) - the list of transactions.

    + Body

            {
                "count": 1,
                "limit": 100,
                "offset": 0,
                "maxLimit": 1000,
                "transactions": [
                    {
                        "transactionId": "unique-id-123",
                        "transactionType": "debit",
                        "currency": "XXX",
                        "steps": [
                            {
                                "rail": "lightrail",
                                "valueStoreId": "vs_1",
                                "currency": "XXX",
                                "valueBefore": 5500,
                                "valueAfter": 3000,
                                "valueChange": -2500
                            }
                        ],
                        "remainder": 0,
                        "simulated": false,
                        "createdDate": "2018-04-17T23:20:08.404Z",
                        "updatedDate": "2018-04-17T23:20:08.404Z",
                        "metadata": {
                            "note": "Reduce loyalty points after 3mo customer inactivity"
                        }
                    }
                ]
            }

### Get Transaction [GET /transactions/{transactionId}]

Get Transaction by transactionId.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + transactionId (string) - the transactionId of the Transaction to get.

+ Response 200
    + Attributes (Transaction)

    + Body

            {
                "transactionId": "unique-id-123",
                "transactionType": "debit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueStoreId": "vs_1",
                        "currency": "XXX",
                        "valueBefore": 5500,
                        "valueAfter": 3000,
                        "valueChange": -2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
