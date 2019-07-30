### Create Issuance [POST /programs/{id}/issuances]
An Issuance creates many [Values](#reference/0/values) in bulk and is tracked for downloading secure codes after creation.  This is primarily used by the web app.  When creating only a few Values use [Create Value](#reference/0/values/create-a-value) instead.

+ Parameter
    + id (string) - the ID of the Program to issue Value from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{issuance.id}}  {{issuance.idPurpose}}
        + name (string, required) - {{issuance.name}}
        + count (number, required) - {{issuance.count}}
        + generateCode (CodeGeneration, optional) - {{issuance.generateCode}}
        + code (string, optional) - {{issuance.code}}
        + isGenericCode (boolean, optional) - {{issuance.isGenericCode}}
        + balance (number, optional) - {{issuance.balance}}
        + usesRemaining (number, optional) - {{issuance.usesRemaining}}  
        + startDate (string, optional) - {{issuance.startDate}}
        + endDate (string, optional) - {{issuance.endDate}}
        + redemptionRule (Rule, optional) - {{issuance.redemptionRule}}
        + balanceRule (Rule, optional) - {{issuance.balanceRule}}
        + metadata (object, optional) - {{issuance.metadata}} `metadata` from the Program is inherited but any keys specified will override those of the Program.
        
    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.body}
    
+ Response 201 (application/json)
    + Attributes (Issuance)

    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.response.body}
