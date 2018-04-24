### Create a Value Store from a Promotion Program [POST /valueStores]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + programId (string, required) - Associate with and copy default values from the given Program.
        + value (number, required) - {{valueStore.value}}
        + startDate (number, optional) - {{valueStore.startDate}}
        + endDate (number, optional) - {{valueStore.endDate}}
        + metadata (number, optional) - {{valueStore.metadata}}
        
    + Body
    
            {
                "valueStoreId": "vs-1",
                "programId": "spring-promotion-usd",
                "value": 500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "vs-1",
                "programId": "gift-cards-usd",
                "currency": "USD",
                "value": 2500, 
                "discount": true,
                "preTax": true,
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
