### Create a Value [POST /values{?showCode}]

+ Parameter
    + showCode (boolean, optional) - {{value.showCode}}  This is useful when using the `generateCode` param and you want to see the generated code.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}  {{value.idPurpose}}
        + programId (string, optional) - {{value.create.programId}}
        + contactId (string, optional) - {{value.create.contactId}}
        + code (string, optional) - {{value.create.code}}
        + isGenericCode (boolean) - {{value.isGenericCode}}
        + genericCodeOptions (GenericCodeOptions, optional)
        + generateCode (CodeGeneration, optional) - {{value.generateCode}}
        + currency (string, optional) - {{currency.code}} Required if `programId` is not set.
        + balance (number, optional) - {{value.balance}} When this is set an `initialBalance` Transaction is created tracking the amount created.
        + pretax (boolean, optional) - {{value.pretax}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + discount (boolean, optional) - {{value.discount}}
        + discountSellerLiability (number, optional) - {{value.discountSellerLiability}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + balanceRule (Rule, optional) - {{value.balanceRule}}
        + usesRemaining (number, optional) - {{value.usesRemaining}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}} If `programId` is set `metadata` from the Program is inherited but any keys specified will override those of the Program.
        
    + Body
    
            {REQUEST_REPLACEMENT:createValue1.body}
    
+ Response 201 (application/json)
    + Attributes (Value)

    + Body
    
            {REQUEST_REPLACEMENT:createValue1.response.body}
