### Create a ValueStore From a Program [POST /programs/{programId}/valueStores]

Create a ValueStore from a program.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + value (number, optional) - {{valueStore.value}}
        + active (boolean, optional) - {{valueStore.active}}
        + frozen (boolean, optional) - {{valueStore.frozen}}
        + startDate (number, optional) - {{valueStore.startDate}}
        + endDate (number, optional) - {{valueStore.endDate}}
        + metadata (number, optional) - {{valueStore.metadata}}
        
    + Body
    
            {
                "valueStoreId": "v1",
                "value": 2500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "v1",
                "currency": "USD",
                "value": 2500,
                "tags": ["giftcard"],
                "uses": "infinite",
                "discount": false, 
            }