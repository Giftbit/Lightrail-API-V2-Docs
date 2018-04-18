### Transfer [POST /transactions/transfer]

Transfer value from one value store to another.

Note:
- Throws error if either valueStore specified has `valueType: percentOff` or `valueType: valueOff`

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + source (TransactionParty, required) - The rail to take value from.  Only `lightrail` rails that refer to a specific ValueStore are supported.
        + destination (TransactionParty, required) - The rail to send value to.  Only `lightrail` rails that refer to a specific ValueStore are supported.
        + amount (number, required) - The amount to transfer, > 0.
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
                "destination": {
                    "rail": "lightrail",
                    "valueStoreId": "alice-account-USD"
                },
                "amount": 2500,
                "currency": "USD",
                "metadata": {
                    "reference": "frequent-shopper-bonus-072301"
                }
            }

+ Response 200
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + transactionType (string, required) - `transfer`
        + currency (string, required) - {{currency}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - {{transaction.remainder}}
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "transactionType": "transfer",
                "currency": "USD",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueStoreId": "vs_1",
                        "valueStoreType": "GIFT_CARD",
                        "currency": "USD",
                        "valueBefore": 2500,
                        "valueAfter": 0,
                        "valueChange": -2500
                    },
                    {
                        "rail": "lightrail",
                        "valueStoreId": "alice-account-USD",
                        "valueStoreType": "ACCOUNT",
                        "currency": "USD",
                        "valueBefore": 5000,
                        "valueAfter": 7500,
                        "valueChange": 2500
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "metadata": {
                    "reference": "loyalty-bonus-072301"
                }
            }
