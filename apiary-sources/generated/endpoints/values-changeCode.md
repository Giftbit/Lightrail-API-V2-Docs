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

            {"id":"93d78efc-ba0f-443b-8","currency":"USD","balance":500,"uses":null,"programId":"e46823bb-6fd5-40bf-9","contactId":null,"code":"\u2026EV3B","isGenericCode":false,"pretax":true,"active":true,"canceled":false,"frozen":false,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-24T18:49:51.000Z","updatedDate":"2018-07-24T18:49:51.000Z"}
