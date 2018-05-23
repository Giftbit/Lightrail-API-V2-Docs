### List Programs [GET /programs{?limit}{?offset}{?id}{?tags}{?currency}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + id (string, optional) - {{filter.id}} {{filter.list}}
    + tags (number, optional) - {{filter.tags}} {{filter.list}}
    + currency (string, optional) - {{filter.currency}} {{filter.list}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1
        
    + Attributes (array[Program])

    + Body

            [
                {
                    "id": "unique-id-123",
                    "name": "Gift Card program",
                    "currency": "CAD",
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
                    "startDate": null,
                    "endDate": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            ]
