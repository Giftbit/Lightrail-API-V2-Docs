### Update a Value [PATCH /values/{valueId}]

Update fields that are sent and leave unspecified values unchanged.

In particular this is how you activate/deactivate freeze/unfreeze a Value.

+ Parameter
    + valueId (string) - the valueId of the Value to modify.

+ Request (application/merge-patch+json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueId (string, optional) - {{value.valueId}}  If present must match the valueId in the path.
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
                "valueId": "vs-1",
                "programId": "giftcards",
                "currency": "USD",
                "value": 2500, 
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
