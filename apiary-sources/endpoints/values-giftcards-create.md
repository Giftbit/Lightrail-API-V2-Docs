### Create a Gift Card [POST /values/giftCards]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}
        + program (string, optional) - {{value.create.program}}
        + contact (string, optional) - {{value.create.contact}}
        + code (string, optional) - {{value.create.code}}
        + currency (string, optional) - {{currency.code}} Required if `program` is not set.
        + balance (number, optional) - {{value.balance}}
        + preTax (boolean, optional) - {{value.preTax}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + uses (number, optional) - {{value.uses}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "id": "vs-1",
                "program": "giftCards",
                "currency": "USD",
                "balance": 2500
            }
    
+ Response 201 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "vs-1",
                "type": "giftCards",
                "program": "giftCards",
                "currency": "USD",
                "balance": 2500,
                "active": true,
                "frozen": false,
                "canceled": false,
                "preTax": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
