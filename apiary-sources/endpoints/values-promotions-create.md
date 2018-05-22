### Create a Promotion Value [POST /values/promotions]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}
        + program (string, optional) - Associate with and copy default values from the given Promotion Program.
        + contact (string, optional) - Associate the Value with the given Contact.  Cannot be set with `code`.
        + code (string, optional) - Associate the Value with the given code.  Cannot be set with `contact`.
        + currency (string, optional) - {{currency.code}} Required if `program` is not set.
        + balance (number, optional) - {{value.balance}}
        + preTax (boolean, optional) - {{value.preTax}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (number, optional) - {{value.valueRule}}
        + uses (number, optional) - {{value.uses}}
        + startDate (number, optional) - {{value.startDate}}
        + endDate (number, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "id": "vs-1",
                "program": "springpromo",
                "currency": "USD",
                "balance": 2500
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "vs-1",
                "type": "promotion"
                "program": "springpromo",
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