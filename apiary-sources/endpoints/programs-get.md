### Get a Program [GET /programs/promotions/{id}]

+ Parameter
    + id (string) - the ID of the Program to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Program)

    + Body

                {"id":"spring-promotion-usd_run14","name":"Spring Promotion USD","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"redemptionRule":null,"valueRule":null,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T22:00:46.000Z","updatedDate":"2018-07-10T22:00:46.000Z"}

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

            [{"id":"4e442899-5529-4102-9","name":"program with no balance constraints or valueRule","currency":"CAD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":null,"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T21:51:28.000Z","updatedDate":"2018-07-10T21:51:28.000Z"},{"id":"spring-promotion-usd_run1","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-05T23:35:06.000Z","updatedDate":"2018-07-05T23:35:06.000Z"},{"id":"spring-promotion-usd_run10","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T21:12:12.000Z","updatedDate":"2018-07-10T21:12:12.000Z"},{"id":"spring-promotion-usd_run13","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T21:58:33.000Z","updatedDate":"2018-07-10T21:58:33.000Z"},{"id":"spring-promotion-usd_run14","name":"Spring Promotion USD","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T22:00:46.000Z","updatedDate":"2018-07-10T22:00:46.000Z"},{"id":"spring-promotion-usd_run2","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:28:53.000Z","updatedDate":"2018-07-10T18:28:53.000Z"},{"id":"spring-promotion-usd_run3","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:30:17.000Z","updatedDate":"2018-07-10T18:30:17.000Z"},{"id":"spring-promotion-usd_run4","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:31:36.000Z","updatedDate":"2018-07-10T18:31:36.000Z"},{"id":"spring-promotion-usd_run5","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:33:14.000Z","updatedDate":"2018-07-10T18:33:14.000Z"},{"id":"spring-promotion-usd_run6","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:33:51.000Z","updatedDate":"2018-07-10T18:33:52.000Z"},{"id":"spring-promotion-usd_run7","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:47:25.000Z","updatedDate":"2018-07-10T18:47:25.000Z"},{"id":"spring-promotion-usd_run8","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T18:48:26.000Z","updatedDate":"2018-07-10T18:48:27.000Z"},{"id":"spring-promotion-usd_run9","name":"Spring Promo US Dollars","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T20:47:18.000Z","updatedDate":"2018-07-10T20:47:18.000Z"}]
