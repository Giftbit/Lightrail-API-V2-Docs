### Void Pending Transaction [POST /transactions/{transactionToVoidId}/void]

A pending Transaction is created when it is created with `pending = true`.  A pending Transaction will be automatically voided but voiding it manually will release the funds sooner.

+ Parameter
    + transactionToVoidId (string) - the ID of the pending Transaction to void.
    + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}

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
                        "usesRemaining": null
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "pending": "void",
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
                "metadata": {
                    "note": "Reduce loyalty points after 3mo contact inactivity"
                }
            }
