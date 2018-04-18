### Debit [POST /transactions/debit]

Debit (remove value from) a payment rail.

Use cases:
- Manual fixing of an account balance
- Clearing all value from an account (choose a large value and set `allowRemainder` to `true`)

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + source (TransactionParty, required) - The rail to debit.  Only `lightrail` rails that refer to a specific ValueStore are supported.
        + amount (number, required) - The amount to credit, > 0.
        + currency (string, required) - {{currency}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "source": {
                    "rail": "lightrail",
                    "valueStoreId": "vs_1"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
    
+ Response 200
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + transactionType (string, required) - `debit`
        + currency (string, required) - {{currency}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - {{transaction.remainder}}
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "transactionType": "debit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueStoreId": "vs_1",
                        "valueStoreType": "ACCOUNT",
                        "currency": "XXX",
                        "valueBefore": 5500,
                        "valueAfter": 3000,
                        "valueChange": -2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }
