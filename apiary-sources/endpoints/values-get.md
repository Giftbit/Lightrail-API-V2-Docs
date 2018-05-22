### List Values [GET /values{?limit}{?offset}{?id}{?tags}{?type}{?contact}{?program}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + id (number, optional) - {{filter.id}}  {{filter.list}}
    + tags (number, optional) - {{filter.tags}}  {{filter.list}}
    + type (string, optional) - {{filter.type}}
    + contact (string, optional) - {{filter.contact}}
    + program (string, optional) - {{filter.program}}
    
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
                    "type": "giftcard",
                    "program": "giftcards",
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
