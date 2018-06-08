### Change a Value's code [POST /values/{id}/changeCode]

+ Parameter
    + id (string) - the ID of the Value to change the code of.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, optional) - A generic code to set.  Required if `codeGeneration` is not set.
        + codeGeneration (CodeGeneration, optional) - Parameters to generate a code.  The code generated will be stored securely.  Required if `code` is not set.
        
    + Body
    
            {
                "code": "SPRINGPROMO2077"
            }

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {
                "id": "vs-1",
                "type": "promotion"
                "programId": "springpromo",
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
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z"
            }
