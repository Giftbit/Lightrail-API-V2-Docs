### Debit [POST /transactions/debit]

Debit (remove value from) a payment rail.

Currently only the `lightrail` payment rail is supported.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}
        + source (TransactionParty, required) - The rail to debit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to credit, > 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "id": "unique-id-123",
                "source": {
                    "rail": "lightrail",
                    "id": "vs_1"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
    
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
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
