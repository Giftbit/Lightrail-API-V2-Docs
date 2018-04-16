### Credit [POST /valueStores/{valueStoreId}/credit]

Use cases:
- Crediting an account
- 

Note:
- Throws error if posted against a valueStore with `valueType: percentOff` or `valueType: valueOff`

---
+ Request (application/json)
    + Headers

        {{header.authorization}}
        
    + Parameters
        + valueStoreId (string, required) - The ValueStore ID. 

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + amount (number, required) - {{valueStore.value}}
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
        + amount (number, required) - {{valueStore.value}}
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}

    + Body

            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "amount": 2500
                "valueStoreId": "vs_1"
            }