### Debit [POST /valueStores/{valueStoreId}/debit]

Use cases:
- Debiting an account
- Does it make sense to not have `/accounts` or `/giftCards` in the path? It's pretty strange to a debit or credit a promotion.
- What if we add more types? `Loyalty Points, Voucher`? These are things biz may want.

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
                "amount": -2500
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
                "amount": -2500
                "valueStoreId": "vs_1"
            }