### Create a Value [POST /values{?showCode}]

+ Parameter
    + id (string) - the ID of the Value to get.
    + showCode (boolean, optional) - {{value.showCode}}  This is useful when using the `generateCode` param and you want to see the generated code.

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
    
            {REQUEST_REPLACEMENT:createValue1.body}
    
+ Response 201 (application/json)
    + Attributes (Value)

    + Body
    
            {REQUEST_REPLACEMENT:createValue1.response.body}
