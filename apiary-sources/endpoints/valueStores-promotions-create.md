### Create a Promotion [POST /valueStores/promotions]

Notes:
Sort of a strange relationship between `appliesTo: "item"` and the redemption rule. How do we know the rule actually relates to an item. 
What if the rule is if the transaction is over $50? Parsing rules to understand them seems somewhat infeasible.   


+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}\
        + currency (string, required) - {{currency}}
        + value (number, required) - {{valueStore.value}}
        + expires (string, optional) - {{valueStore.expires}}
        + active (boolean, optional) - {{valueStore.active}}
        + appliesTo (string, required) - "cart" or "item". or maybe: "item": { SOME_IDENTIFIER: SOME_VALUE } 
        + preTax (string, optional) - Determines whether the promotion should apply before or after tax.
        
    + Body 
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500,
                "accessedBy": [
                    {
                        "customerId": "cus_123"        
                    }
                ],
                "appliesTo": "item",
                "rule": "transaction.lineItems.item.id == pid_123",
                "preTax": true,
                "uses": 1,
                "limitation": "ONE_PER_ITEM"
            }
    
+ Response 200

    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500, 
                "type": "PROMOTION",
                "preTax": true,
                "appliesTo": "item",
                "expires": "never",
                "active": true,
                "accessedBy": [
                    {
                        "customerId": "cus_123"        
                    }
                ]
            }