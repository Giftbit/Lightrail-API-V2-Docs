### Get Value by code [GET /values/code/{code}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Value to get.

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
