### Debit [POST /transactions/debit]

+ Request (application/json)

    Debit (remove from) an account on a rail.  Currently only the `lightrail` rail is supported.

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}
        + source (TransactionParty, required) - The rail to debit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to debit, > 0.
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
                    "account": "points-account-14314"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo contact inactivity"
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
                        "id": "points-account-14314",
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
