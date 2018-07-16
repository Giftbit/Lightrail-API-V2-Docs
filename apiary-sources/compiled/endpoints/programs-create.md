### Create Program [POST /programs]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{program.id}}  {{idPurpose}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency.code}}
        + discount (boolean, optional) - {{value.discount}} Default is `true`. 
        + preTax (boolean, optional) - {{value.preTax}} Default is `true`.
        + active (boolean, optional) - {{value.active}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}}
        + fixedInitialUses (array[number], optional) -  {{program.fixedInitialUses}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}}
        + endDate (string, optional) - {{program.endDate}}
        + metadata (object, optional) - {{program.metadata}}
        
    + Body

            {"id":"spring-promotion-usd_rn1","name":"Spring Promotion USD","currency":"USD","pretax":true,"discount":true,"fixedInitialBalances":[500]}
    
+ Response 201 (application/json)
    + Attributes (Contact)

    + Body
            
            {"id":"spring-promotion-usd_rn1","name":"Spring Promotion USD","currency":"USD","discount":true,"discountSellerLiability":null,"pretax":true,"active":true,"redemptionRule":null,"valueRule":null,"minInitialBalance":null,"maxInitialBalance":null,"fixedInitialBalances":[500],"fixedInitialUses":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-16T23:16:12.000Z","updatedDate":"2018-07-16T23:16:12.000Z"}
