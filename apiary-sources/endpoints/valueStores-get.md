### Get Value Stores [GET /valueStores{?limit}{?offset}{?programId}{?currency}{?minValue}{?maxValue}{?active}{?frozen}{?minUses}{?maxUses}{?minStartDate}{?maxStartDate}{?minEndDate}{?maxEndDate}{?minCreatedDate}{?maxCreatedDate}{?minUpdatedDate}{?maxUpdatedDate}]

Get multiple Value Stores.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + programId (string, optional) - Filter by programId.
    + currency (string, optional) - Filter by currency.
    + minValue (number, optional) - Filter by minimumm value, inclusive.
    + maxValue (number, optional) - Filter by maximum value, inclusive.
    + active (boolean, optional) - Filter active/inactive.
    + frozen (boolean, optional) - Filter frozen/unfrozen.
    + minUses (number, optional) - Filter by minimum uses, inclusive.
    + maxUses (number, optional) - Filter by maximum uses, inclusive.
    + minStartDate (string, optional) - Filter by he minimum startDate, inclusive.
    + maxStartDate (string, optional) - Filter by he maximum startDate, inclusive.
    + minEndDate (string, optional) - Filter by he minimum endDate, inclusive.
    + maxEndDate (string, optional) - Filter by he maximum endDate, inclusive.
    + minCreatedDate (string, optional) - Filter by he minimum createdDate, inclusive.
    + maxCreatedDate (string, optional) - Filter by the maximum createdDate, inclusive.
    + minUpdatedDate (string, optional) - Filter by the minimum updatedDate, inclusive.
    + maxUpdatedDate (string, optional) - Filter by the maximum updatedDate, inclusive.
    
+ Response 200 (application/json)
    + Headers
        
        Limit: 100
        MaxLimit: 1000
        Offset: 0
        Count: 1
        
    + Attributes (array[ValueStore])

    + Body

            [
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
            ]

### Get Value Store [GET /valueStores/{valueStoreId}]

Get Value Store by valueStoreId.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to get.

+ Response 200 (application/json)
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
