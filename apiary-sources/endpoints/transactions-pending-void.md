### Void Pending Transaction [POST /transactions/{transactionId}/void]

Void a pending Transaction by transactionId.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + transactionId (string) - the transactionId of the pending Transaction to void.

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
                "pending": "void",
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
