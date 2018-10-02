### Create Program [POST /programs]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{program.id}}  {{program.idPurpose}}
        + name (string, required) - {{program.name}}
        + currency (string, required) - {{currency.code}}
        + discount (boolean, optional) - {{program.discount}} Default is `true`. 
        + pretax (boolean, optional) - {{program.pretax}} Default is `true`.
        + active (boolean, optional) - {{program.active}}
        + redemptionRule (Rule, optional) - {{program.redemptionRule}}
        + valueRule (Rule, optional) - (Deprecated. Use `balanceRule` instead.)
        + balanceRule (Rule, optional) - {{program.balanceRule}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}}
        + fixedInitialUses (array[number], optional) -  {{program.fixedInitialUses}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}}
        + endDate (string, optional) - {{program.endDate}}
        + metadata (object, optional) - {{program.metadata}}
        
    + Body

            {REQUEST_REPLACEMENT:createProgram1.body}
    
+ Response 201 (application/json)
    + Attributes (Program)

    + Body
            
            {REQUEST_REPLACEMENT:createProgram1.response.body}
