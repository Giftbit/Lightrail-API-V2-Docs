### Update Value by code [PATCH /values/code/{code}]

+ Parameter
    + code (string) - the code of the Value to modify.

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
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
                "frozen": true
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "vs-1",
                "type": "giftcard",
                "programId": "giftcards",
                "currency": "USD",
                "balance": 2500, 
                "preTax": false,
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