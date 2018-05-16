### Transfer [POST /transactions/transfer]

Transfer balance from one Value to another.

Currently only the `lightrail` payment rail is supported.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}
        + source (TransactionParty, required) - The rail to take value from.  Only `lightrail` rails that refer to a specific Value are supported.
        + destination (TransactionParty, required) - The rail to send value to.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to transfer, > 0.
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
                "destination": {
                    "rail": "lightrail",
                    "id": "alice-account-USD"
                },
                "amount": 2500,
                "currency": "USD",
                "metadata": {
                    "reference": "frequent-shopper-bonus-072301"
                }
            }

+ Response 200 (application/json)
    + Attributes
        + id (string, required) - {{transaction.id}}
        + transactionType (string, required) - `transfer`
        + currency (string, required) - {{currency.code}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - {{transaction.remainder}}
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "id": "unique-id-123",
                "transactionType": "transfer",
                "currency": "USD",
                "steps": [
                    {
                        "rail": "lightrail",
                        "id": "vs_1",
                        "currency": "USD",
                        "balanceBefore": 2500,
                        "balanceAfter": 0,
                        "balanceChange": -2500
                    },
                    {
                        "rail": "lightrail",
                        "id": "alice-account-USD",
                        "currency": "USD",
                        "balanceBefore": 5000,
                        "balanceAfter": 7500,
                        "balanceChange": 2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "reference": "loyalty-bonus-072301"
                }
            }
