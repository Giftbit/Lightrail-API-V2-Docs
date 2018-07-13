### Create a Value [POST /values]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}  {{idPurpose}}
        + programId (string, optional) - {{value.create.programId}}
        + contactId (string, optional) - {{value.create.contactId}}
        + code (string, optional) - {{value.create.code}}
        + isGenericCode (boolean) - {{value.isGenericCode}}
        + generateCode (CodeGeneration, optional) - {{value.generateCode}}
        + currency (string, optional) - {{currency.code}} Required if `programId` is not set.
        + balance (number, optional) - {{value.balance}}
        + preTax (boolean, optional) - {{value.preTax}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + discount (boolean, optional) - {{value.discount}}
        + discountSellerLiability (number, optional) - {{value.discountSellerLiability}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + uses (number, optional) - {{value.uses}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {"id":"value1-_rn1","programId":"spring-promotion-usd_rn1","balance":500}
    
+ Response 201 (application/json)
    + Attributes (Value)

    + Body
    
            {"id":"value1-_rn1","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_rn1","code":null,"isGenericCode":null,"contactId":null,"pretax":true,"active":true,"frozen":false,"redemptionRule":null,"valueRule":null,"discount":true,"discountSellerLiability":null,"startDate":null,"endDate":null,"metadata":null,"canceled":false,"createdDate":"2018-07-13T18:59:48.000Z","updatedDate":"2018-07-13T18:59:48.000Z"}
