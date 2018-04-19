### Update a Value Store [PATCH /valueStores/{valueStoreId}]

Update fields that are sent and leave unspecified values at their default.

In particular this is how you activate/deactivate freeze/unfreeze a Value Store.

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to modify.

+ Request (application/merge-patch+json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, optional) - {{valueStore.valueStoreId}}  If present must match the valueStoreId in the path.
        + currency (string, optional) - {{currency}}
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
                "frozen": true
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
                "frozen": true,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
