### Get Promotion Programs [GET /programs{?limit}{?offset}{?id}{?tags}{?currency}]

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
                    "name": "5% off promo program",
                    "currency": "CAD",
                    "access": "secureCode",
                    "discount": "true",
                    "preTax": "true",
                    "active": "true",
                    "redemptionRule": null,
                    "valueRule": "order*0.05",
                    "uses": null,
                    "tags": [],
                    "metadata": null,
                    "startDate": null,
                    "endDate": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            ]

### Get a Promotion Program [GET /programs/promotions/{id}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Promotion Program to get.

+ Response 200 (application/json)
    + Attributes (Program)

    + Body

                {
                    "id": "unique-id-123",
                    "name": "5% off promo program",
                    "currency": "CAD",
                    "access": "secureCode",
                    "discount": "true",
                    "preTax": "true",
                    "active": "true",
                    "redemptionRule": null,
                    "valueRule": "order*0.05",
                    "uses": null,
                    "tags": [],
                    "metadata": null,
                    "startDate": null,
                    "endDate": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
