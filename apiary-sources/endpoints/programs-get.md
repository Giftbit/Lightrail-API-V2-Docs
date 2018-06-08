### Get a Program [GET /programs/promotions/{id}]

+ Parameter
    + id (string) - the ID of the Program to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Program)

    + Body

                {
                    "id": "unique-id-123",
                    "name": "5% off promo program",
                    "currency": "CAD",
                    "discount": "true",
                    "preTax": "true",
                    "active": "true",
                    "redemptionRule": null,
                    "valueRule": "order*0.05",
                    "minInitialBalance": null,
                    "maxInitialBalance": null,
                    "fixedInitialBalances": null,
                    "fixedInitialUses": null,
                    "tags": [],
                    "metadata": null,
                    "startDate": null,
                    "endDate": null,
                    "createdDate": "2018-04-17T23:20:08.000Z",
                    "updatedDate": "2018-04-17T23:20:08.000Z"
                }

### List Programs [GET /programs{?limit}{?id}{?name}{?preTax}{?currency}{?tags}{?startDate}{?endDate}{?createdDate}{?updatedDate}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}} {{filter.ops.in}}
    + currency (string, optional) - {{filter.currency}} {{filter.ops.in}}
    + tags (string, optional) - {{filter.tags}} {{filter.ops.in}}
    + startDate (string, optional) - {{filter.startDate}} {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}} {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}} {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}} {{filter.ops.date}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Program])

    + Body

            [
                {
                    "id": "unique-id-123",
                    "name": "Gift Card program",
                    "currency": "CAD",
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
                    "fixedInitialUses": null,
                    "tags": [],
                    "metadata": null,
                    "startDate": null,
                    "endDate": null,
                    "createdDate": "2018-04-17T23:20:08.000Z",
                    "updatedDate": "2018-04-17T23:20:08.000Z"
                }
            ]
