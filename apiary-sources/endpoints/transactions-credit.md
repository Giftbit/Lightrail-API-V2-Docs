### Credit [POST /transactions/credit]

Credit (add value to) a payment rail.

Currently only the `lightrail` payment rail is supported.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + destination (TransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to debit, > 0.
        + currency (string, required) - {{currency}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "destination": {
                    "rail": "lightrail",
                    "valueId": "vs_1"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
    
+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {
                "transactionId": "unique-id-123",
                "transactionType": "credit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueId": "vs_1",
                        "currency": "XXX",
                        "balanceBefore": 1500,
                        "balanceAfter": 4000,
                        "balanceChange": 2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
