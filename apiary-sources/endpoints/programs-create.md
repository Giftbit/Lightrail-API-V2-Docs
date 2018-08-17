### Create Program [POST /programs]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{program.id}}  {{idPurpose}}
        + name (string, required) - {{program.name}}
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

            {REQUEST_REPLACEMENT:createProgram1.body}
    
+ Response 201 (application/json)
    + Attributes (Program)

    + Body
            
            {REQUEST_REPLACEMENT:createProgram1.response.body}
