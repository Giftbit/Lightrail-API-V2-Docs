### Debit [POST /transactions/debit]

Use cases:
- Debiting a valueStore that has prepaid value (account or gift card)
- Does it make sense to not have `/accounts` or `/giftCards` in the path? It's pretty strange to debit or credit a promotion.
- What if we add more types? `Loyalty Points, Voucher`? These are things biz may want.

Note:
- Throws error if posted against a valueStore with `valueType: percentOff` or `valueType: valueOff`

---
+ Request (application/json)
    + Headers

        {{header.authorization}}
        
    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + valueStoreId (string, required) - The ValueStore ID.
        + currency (string, required) - {{currency}}
        + amount (number, required) - {{valueStore.value}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "transactionId": "unique-id-123",
                "valueStoreId": "vs_1",
                "currency": "loyalty-bucks",
                "amount": -2500,
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
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
                "currency": "loyalty-bucks",
                "transactionSteps": [
                    {
                        "valueStoreId": "vs_1",
                        "valueStoreType": "ACCOUNT",
                        "valueBefore": 5500,
                        "valueAfter": 3000,
                        "valueChange": -2500
                    }
                ]
                "metadata": {
                    "note": "Reduce loyalty points after 3mo customer inactivity"
                }
            }