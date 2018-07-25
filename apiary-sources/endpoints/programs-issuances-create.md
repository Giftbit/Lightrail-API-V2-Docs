### Issue Values (Coming soon) [POST /programs/{id}/issuances]

+ Parameter
    + id (string) - the ID of the Program to issue Value from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{issuance.id}}  {{idPurpose}}
        + count (number, required) - {{issuance.count}}
        + codeGeneration (CodeGeneration, optional) - {{issuance.generateCode}}
        + code (string, optional) - {{issuance.code}}
        + isGenericCode (boolean, optional) - {{issuance.isGenericCode}}
        + balance (number, optional) - {{issuance.balance}}
        + uses (number, optional) - {{issuance.uses}}  
        + startDate (string, optional) - {{issuance.startDate}}
        + endDate (string, optional) - {{issuance.endDate}}
        + redemptionRule (Rule, optional) - {{issuance.redemptionRule}}
        + valueRule (Rule, optional) - {{issuance.valueRule}}
        + tags (array[string], optional) - {{tags}} These are applied to each Value.
        + metadata (object, optional) - {{issuance.metadata}}
        
    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.body}
    
+ Response 201 (application/json)
    + Attributes (Issuance)

    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.response.body}
