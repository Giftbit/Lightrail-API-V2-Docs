### Get a Value [GET /values/{id}{?showCode}]

+ Parameter
    + id (string) - the ID of the Value to get.
    + showCode (boolean, optional) - {{value.showCode}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {"id":"value1-_rn1","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_rn1","code":null,"isGenericCode":null,"contactId":null,"pretax":true,"active":true,"frozen":false,"redemptionRule":null,"valueRule":null,"discount":true,"discountSellerLiability":null,"startDate":null,"endDate":null,"metadata":null,"canceled":false,"createdDate":"2018-07-16T23:16:12.000Z","updatedDate":"2018-07-16T23:16:12.000Z"}

### List Values [GET /values{?limit}{?showCode}{?programId}{?currency}{?contactId}{?balance}{?uses}{?discount}{?active}{?frozen}{?canceled}{?preTax}{?startDate}{?endDate}{?createdDate}{?updatedDate}{?tags}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + showCode (boolean, optional) - {{value.showCode}}
    + programId (string, optional) - {{filter.programId}}  {{filter.ops.in}}
    + currency (string, optional) - {{filter.currency}}  {{filter.ops.in}}
    + contactId (string, optional) - {{filter.contactId}}  {{filter.ops.in}}
    + balance (number, optional) - {{filter.balance}}  {{filter.ops.number}}
    + uses (number, optional) - {{filter.uses}}  {{filter.ops.number}}
    + discount (boolean, optional) - {{filter.discount}}
    + active (boolean, optional) - {{filter.active}}
    + frozen (boolean, optional) - {{filter.frozen}}
    + canceled (boolean, optional) - {{filter.canceled}}
    + preTax (boolean, optional) - {{filter.preTax}}
    + startDate (string, optional) - {{filter.startDate}}  {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}}  {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}}  {{filter.ops.date}}
    + tags (string, optional) - {{filter.tags}}  {{filter.ops.in}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "vs-1",
                    "type": "giftCard",
                    "programId": "giftCards",
                    "contactId": null,
                    "code": "…GYOA",
                    "isGenericCode": false,
                    "currency": "USD",
                    "balance": 2500,
                    "active": true,
                    "frozen": false,
                    "canceled": false,
                    "preTax": false,
                    "discount": false,
                    "discountSellerLiability": null,
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
            ]

+ Response 200 (text/csv)

    You can request a CSV file of the output by setting `Accept: text/csv` in the request header.

    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Body

            id,currency,balance,uses,programId,contactId,code,isGenericCode,pretax,active,canceled,frozen,discount,discountSellerLiability,redemptionRule,valueRule,startDate,endDate,metadata,createdDate,updatedDate
            vs-1,USD,2500,,giftCards,,…GYOA,false,false,true,false,false,false,,,,,,,2018-04-17T23:20:08.000Z,2018-04-17T23:20:08.000Z
