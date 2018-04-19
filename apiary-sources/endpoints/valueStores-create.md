### Create a Value Store [POST /valueStores]

Create a new Value Store.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + currency (string, required) - {{currency}}
        + value (number, optional) - {{valueStore.value}}
        + pretax (boolean, optional) - {{valueStore.pretax}}
        + active (boolean, optional) - {{valueStore.active}}
        + frozen (boolean, optional) - {{valueStore.frozen}}
        + redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
        + valueRule (number, optional) - {{valueStore.valueRule}}
        + uses (number, optional) - {{valueStore.uses}}
        + startDate (number, optional) - {{valueStore.startDate}}
        + endDate (number, optional) - {{valueStore.endDate}}
        + metadata (number, optional) - {{valueStore.metadata}}
        
    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500, 
                "pretax": false,
                "active": true,
                "frozen": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
