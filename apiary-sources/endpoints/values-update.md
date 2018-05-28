### Update Values [PATCH /values{?limit}{?id}{?tags}{?type}{?contact}{?program}]

Update all Values that match the given query parameters.
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}  This limits the number of items returned but not the number of items modified.
    + id (number, optional) - {{filter.id}}  {{filter.list}}
    + tags (number, optional) - {{filter.tags}}  {{filter.list}}
    + type (string, optional) - {{filter.type}}
    + contact (string, optional) - {{filter.contact}}
    + program (string, optional) - {{filter.program}}

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + canceled (boolean, optional) - {{value.canceled}}
        + preTax (boolean, optional) - {{value.preTax}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "frozen": true
            }
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 2
        
    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "vs-1",
                    "type": "giftCard",
                    "program": "giftCards",
                    "currency": "USD",
                    "balance": 2500,
                    "active": true,
                    "frozen": true,
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
                    "updatedDate": "2018-04-17T23:58:19.036Z"
                },
                {
                    "id": "account-1",
                    "type": "account",
                    "program": null,
                    "currency": "USD",
                    "balance": 2500,
                    "active": true,
                    "frozen": true,
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
                    "updatedDate": "2018-04-17T23:58:19.036Z"
                }
            ]
