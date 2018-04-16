### Credit [POST /transactions/credit]

Use cases:
- Crediting an account
-

Note:
- Throws error if posted against a valueStore with `valueType: percentOff` or `valueType: valueOff`


---
+ Request (application/json)
    + Headers

        {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (integer, required) - {{valueStore.value}}
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "amount": 2500,
                "valueStoreId": "vs_1"
            }
    
+ Response 200
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (integer, required) - {{valueStore.value}}
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "amount": 2500
                "valueStoreId": "vs_1"
            }