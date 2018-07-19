### Get a Program [GET /programs/promotions/{id}]

+ Parameter
    + id (string) - the ID of the Program to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Program)

    + Body

                {"id":"spring-promotion-usd_rn1","name":"Spring Promotion USD","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"redemptionRule":null,"valueRule":null,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-18T21:45:37.000Z","updatedDate":"2018-07-18T21:45:37.000Z"}

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

            [{"id":"spring-promotion-usd_rn1","name":"Spring Promotion USD","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-18T21:45:37.000Z","updatedDate":"2018-07-18T21:45:37.000Z"}]