### Change a Gift Card's code [PUT /values/giftCards/{id}/changeCode]

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, required) - {{code.set}}
        + secure (boolean, optional) - {{code.secure}}
        
    + Body
    
            {
                "code": "c3d177ff950b4e2796e341f65976e1b1",
                "secure": true
            }

+ Parameter
    + id (string) - the ID of the Gift Card to change the code of.

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {
                "id": "vs-1",
                "type": "giftCard",
                "program": "giftCards",
                "currency": "USD",
                "code": "…e1b1",
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
