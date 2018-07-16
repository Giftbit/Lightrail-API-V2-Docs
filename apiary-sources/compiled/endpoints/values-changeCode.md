### Change a Value's code [POST /values/{id}/changeCode]

+ Parameter
    + id (string) - the ID of the Value to change the code of.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, optional) - {{value.code}}
        + generateCode (CodeGeneration, optional) - {{value.generateCode}}
        + isGenericCode (boolean, optional) - {{value.isGenericCode}}
        
        
    + Body
    
            {"generateCode":{}}

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {"id":"value3-_rn1","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_rn1","contactId":null,"code":"\u20262TKA","isGenericCode":false,"pretax":true,"active":true,"canceled":false,"frozen":false,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-16T23:16:14.000Z","updatedDate":"2018-07-16T23:16:14.000Z"}
