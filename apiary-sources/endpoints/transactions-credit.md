### Credit [POST /transactions/credit]

Use cases:
- Crediting a valueStore that has prepaid value (account or gift card)

Note:
- Throws error if posted against a valueStore with `valueType: percentOff` or `valueType: valueOff`

---
+ Request (application/json)
    + Headers

        {{header.authorization}}
        
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (number, required) - {{valueStore.value}}
        + valueStoreId (string, optional) - The ValueStore ID.
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "valueStoreId": "vs_1",
                "currency": "XXX",
                "amount": 2500,
                "metadata": {
                    "note": "Frequent buyer bonus"
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
                "currency": "XXX",
                "transactionSteps": [
                    {
                        "valueStoreId": "vs_1",
                        "valueStoreType": "ACCOUNT",
                        "valueBefore": 1500,
                        "valueAfter": 4000,
                        "valueChange": 2500
                    }
                ]
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }