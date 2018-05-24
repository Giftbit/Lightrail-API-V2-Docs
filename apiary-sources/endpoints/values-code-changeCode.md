### Change a Value's code by code [PUT /values/byCode/{code}/changeCode]

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
    + code (string) - the code of the Value to change the code of.

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {
                "id": "unique-id-123",
                "name": "Gift Card program",
                "currency": "CAD",
                "code": "…e1b1"
                "access": "secureCode",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialBalance": null,
                "maxInitialBalance": null,
                "fixedInitialBalances": [
                    500,
                    1500,
                    2500
                ],
                "uses": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
