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
        + active (boolean, optional) - {{program.active}}
        + discount (boolean, optional) - {{program.discount}} Default is `true`. {{patch.alsoChangeValues}}
        + pretax (boolean, optional) - {{program.pretax}} Default is `true`. {{patch.alsoChangeValues}}
        + redemptionRule (Rule, optional) - {{program.redemptionRule}}
        + balanceRule (Rule, optional) - {{program.balanceRule}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}} {{patch.alsoChangeValues}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}} {{patch.alsoChangeValues}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}} {{patch.alsoChangeValues}}
        + fixedInitialUsesRemaining (array[number], optional) -  {{program.fixedInitialUsesRemaining}} {{patch.alsoChangeValues}}
        + discountSellerLiability (number, optional) - {{program.discountSellerLiability}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}} {{patch.alsoChangeValues}}
        + endDate (string, optional) - {{program.endDate}} {{patch.alsoChangeValues}}
        + metadata (object, optional) - {{program.metadata}}

    + Body

            {REQUEST_REPLACEMENT:updateProgram1.body}
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {REQUEST_REPLACEMENT:updateProgram1.response.body}
