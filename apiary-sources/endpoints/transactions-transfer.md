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
        + from (string, required) - {{valueStore.valueStoreId}}
        + to (string, required) - {{valueStore.valueStoreId}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "amount": 2500,
                "from": "vs_1",
                "to": "alice-account-USD"
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
                "amount": 2500,
                "from": "vs_1",
                "to": "alice-account-USD"
            }
