### Update a Program [PATCH /programs/{id}]

+ Parameter
    + id (string) - the ID of the Program to modify.

+ Request (application/json)

    {{patch.merge}} 
    Note that updating a Program does not automatically update the attributes of Values that have already been generated through it. Only new Values generated afterwards will reflect the changes. If you want existing Values to reflect your changes, you will need to update them in a separate step. 

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + name (string, optional) - {{program.name}}
        + active (boolean, optional) - {{value.active}}
        + discount (boolean, optional) - {{value.discount}} Default is `true`. {{patch.alsoChangeValues}}
        + preTax (boolean, optional) - {{value.preTax}} Default is `true`. {{patch.alsoChangeValues}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}} {{patch.alsoChangeValues}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}} {{patch.alsoChangeValues}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}} {{patch.alsoChangeValues}}
        + fixedInitialUses (array[number], optional) -  {{program.fixedInitialUses}} {{patch.alsoChangeValues}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}} {{patch.alsoChangeValues}}
        + endDate (string, optional) - {{program.endDate}} {{patch.alsoChangeValues}}
        + metadata (object, optional) - {{program.metadata}}

    + Body

            {
                "name": "Spring Promo US Dollars"
            }
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {REQUEST_REPLACEMENT:updateProgram1.response.body}
