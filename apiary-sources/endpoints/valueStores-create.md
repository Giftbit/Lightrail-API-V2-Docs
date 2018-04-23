### Create a Value Store [POST /valueStores]

Create a new Value Store.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + programId (string, optional) - Associate with and copy default values from the given Program.
        + customerId (string, optional) - Associate the Value Store with the given Customer.  Cannot be set with `code`.
        + code (string, optional) - Associate the Value Store with the given code.  Cannot be set with `customerId`.
        + currency (string, optional) - {{currency}} Required if `programId` is not set.
        + value (number, optional) - {{valueStore.value}}
        + preTax (boolean, optional) - {{valueStore.preTax}}
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
                "programId": "giftcards",
                "currency": "USD",
                "value": 2500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "vs-1",
                "programId": "giftcards",
                "currency": "USD",
                "value": 2500, 
                "preTax": false,
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
