### Change a Promotion's code [PUT /values/promotions/{id}/changeCode]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, required) - {{code.set}}
        + secure (boolean, optional) - {{code.secure}}
        
    + Body
    
            {
                "code": "SPRINGPROMO2077"
            }

+ Parameter
    + id (string) - the ID of the Promotion to change the code of.

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {
                "id": "vs-1",
                "type": "promotion"
                "program": "springpromo",
                "currency": "USD",
                "code": "SPRINGPROMO2077",
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
