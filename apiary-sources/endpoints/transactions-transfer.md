### Transfer [POST /transactions/transfer]

Note:
- Throws error if either valueStore specified has `valueType: percentOff` or `valueType: valueOff`


---
+ Request (application/json)
    + Headers

        {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (number, required) - {{valueStore.value}}
        + source (string, required) - {{valueStore.valueStoreId}}
        + destination (string, required) - {{valueStore.valueStoreId}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "amount": 2500,
                "source": "vs_1",
                "destination": "alice-account-USD",
                "metadata": {
                    "reference": "frequent-shopper-bonus-072301"
                }
            }

+ Response 200
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (number, required) - {{valueStore.value}}
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "transactionSteps": [
                    {
                        "valueStoreId": "vs_1",
                        "valueStoreType": "GIFT_CARD",
                        "valueBefore": 2500,
                        "valueAfter": 0,
                        "valueChange": -2500
                    },
                    {
                        "valueStoreId": "alice-account-USD",
                        "valueStoreType": "ACCOUNT",
                        "valueBefore": 5000,
                        "valueAfter": 7500,
                        "valueChange": 2500
                    }
                ]
                "metadata": {
                    "reference": "loyalty-bonus-072301"
                }
            }
