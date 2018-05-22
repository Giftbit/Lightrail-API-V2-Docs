### Get Promotion Programs [GET /programs{?limit}{?offset}{?id}{?name}{?tags}{?currency}{?access}{?discount}{?preTax}{?active}{?minUses}{?maxUses}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + id (string, optional) - Filter by ID.
    + name (string, optional) - Filter by human-readable name.
    + type (string, optional) - Filter by type.
    + currency (string, optional) - Filter by currency.
    + access (string, optional) - Filter by access.
    + discount (boolean, optional) - Filter by whether the Program's values represent a discount.
    + preTax (boolean, optional) - Filter by whether the Program's values are applied before tax.
    + active (boolean, optional) - Filter active/inactive.
    + minUses (number, optional) - Filter by minimum uses, inclusive.
    + maxUses (number, optional) - Filter by maximum uses, inclusive.
    + tags (number, optional) - Filter by tags.
    
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

### Get a Promotion Program [GET /programs/{id}]

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
