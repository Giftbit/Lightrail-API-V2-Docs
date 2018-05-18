### Void Pending Transaction [POST /transactions/{id}/void]

A pending Transaction is created when it is created with `pending = true`.  A pending Transaction will be automatically voided but voiding it manually will release the funds sooner.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the pending Transaction to void.

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
                "pending": "void",
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
                "metadata": {
                    "note": "Reduce loyalty points after 3mo contact inactivity"
                }
            }
