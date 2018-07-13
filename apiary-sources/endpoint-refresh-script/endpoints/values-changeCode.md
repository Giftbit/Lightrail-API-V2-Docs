### Change a Value's code [POST /values/{id}/changeCode]

+ Parameter
    + id (string) - the ID of the Value to change the code of.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, optional) - {{value.code}}
        + generateCode (CodeGeneration, optional) - {{value.generateCode}}
        + isGenericCode: (boolean, optional) - {{value.isGenericCode}}
        
        
    + Body
    
            {REQUEST_REPLACEMENT:changeGenerateCodeValue1.body}

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {REQUEST_REPLACEMENT:changeGenerateCodeValue1.response.body}
