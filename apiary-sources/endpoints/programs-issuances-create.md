### Create Issuance[POST /programs/{id}/issuances]
[Value](#reference/0/values) is usually created by issuing it from a [Program](#reference/0/programs) in the web app. Each block of Values issued at once is tracked as an Issuance. Issuances are tracked for downloading secured codes after creation.

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
        + tags (array[string], optional) - {{tags}} These are applied to each Value.
        + metadata (object, optional) - {{issuance.metadata}} `metadata` from the Program is inherited but any keys specified will override those of the Program.
        
    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.body}
    
+ Response 201 (application/json)
    + Attributes (Issuance)

    + Body
    
            {REQUEST_REPLACEMENT:createIssuance.response.body}
