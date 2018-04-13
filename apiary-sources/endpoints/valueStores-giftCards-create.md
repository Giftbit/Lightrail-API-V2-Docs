### Create Gift Card [POST /valueStores/giftCards]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}\
        + currency (string, required) - {{currency}}
        + value (number, required) - {{valueStore.value}}
        + expires (string, optional) - {{valueStore.expires}}
        + active (boolean, optional) - {{valueStore.active}}
        
    + Body 
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500,
                "accessedBy": [
                    {
                        "code": "MY-OWN-CODE"
                    },
                    {
                        "customerId": "cus_123"
                    }
                ]
            }
    
+ Response 200

    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500, 
                "type": "GIFT_CARD",
                "accessedBy": [
                    {
                        "code": "MY-OWN-CODE"        
                    },
                    {
                        "customerId": "cus_123"
                    }
                ]
            }