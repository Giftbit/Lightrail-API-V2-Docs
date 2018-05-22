### Get Promotions [GET /values/promotions{?limit}{?offset}{?id}{?tags}{?contact}{?program}{?currency}{?active}{?frozen}{?canceled}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + id (number, optional) - {{filter.id}}  {{filter.list}}
    + tags (string, optional) - {{filter.tags}}  {{filter.list}}
    + contact (string, optional) - {{filter.contact}}
    + program (string, optional) - {{filter.program}}
    + currency (string, optional) - {{filter.currency}}
    + active (boolean, optional) - {{filter.active}}
    + frozen (boolean, optional) - {{filter.frozen}}
    + canceled (boolean, optional) - {{filter.canceled}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1
        
    + Attributes (array[Value])

    + Body

            [
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
            ]

### Get a Promotion Value [GET /values/promotions/{id}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Promotion to get.

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
