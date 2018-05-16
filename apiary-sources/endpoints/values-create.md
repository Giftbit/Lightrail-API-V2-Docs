### Create a Value [POST /values]

Create a new Value.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueId (string, required) - {{value.valueId}}
        + programId (string, optional) - Associate with and copy default values from the given Program.
        + customerId (string, optional) - Associate the Value with the given Customer.  Cannot be set with `code`.
        + code (string, optional) - Associate the Value with the given code.  Cannot be set with `customerId`.
        + currency (string, optional) - {{currency}} Required if `programId` is not set.
        + value (number, optional) - {{value.value}}
        + preTax (boolean, optional) - {{value.preTax}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (number, optional) - {{value.valueRule}}
        + uses (number, optional) - {{value.uses}}
        + startDate (number, optional) - {{value.startDate}}
        + endDate (number, optional) - {{value.endDate}}
        + metadata (number, optional) - {{value.metadata}}
        
    + Body
    
            {
                "valueId": "vs-1",
                "programId": "giftcards",
                "currency": "USD",
                "value": 2500
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "valueId": "vs-1",
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
