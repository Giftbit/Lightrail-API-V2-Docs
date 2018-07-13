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

            {"id":"value3-_run14","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_run14","contactId":null,"code":"\u2026D29J","isGenericCode":false,"pretax":true,"active":true,"canceled":false,"frozen":false,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-10T22:00:48.000Z","updatedDate":"2018-07-10T22:00:48.000Z"}
