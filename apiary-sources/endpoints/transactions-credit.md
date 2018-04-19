### Credit [POST /transactions/credit]

Credit (add value to) a payment rail.

Currently only the `lightrail` payment rail is supported.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + destination (TransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific ValueStore are supported.
        + amount (number, required) - The amount to debit, > 0.
        + currency (string, required) - {{currency}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "destination": {
                    "rail": "lightrail",
                    "valueStoreId": "vs_1"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
    
+ Response 200
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + transactionType (string, required) - `credit`
        + currency (string, required) - {{currency}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - `0`
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "transactionType": "credit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueStoreId": "vs_1",
                        "valueStoreType": "ACCOUNT",
                        "currency": "XXX",
                        "valueBefore": 1500,
                        "valueAfter": 4000,
                        "valueChange": 2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
