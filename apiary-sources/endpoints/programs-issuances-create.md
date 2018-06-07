### Issue Values [POST /programs/{id}/issuances]

+ Parameter
    + id (string) - the ID of the Program to issue Value from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{issuance.id}}  {{idPurpose}}
        + count (number, required) - The numbers of Values to issue.
        + code (string, optional) - The code to set on the Value.  The code will not be secured.  This is only available when `count` is 1.
        + codeGeneration (CodeGeneration, optional) - Defines how codes are generated.  Each code generated will be stored securely.  Required if `code` is not set.
        + balance (number, optional) - The balance to set on each Value.  This can be constrained by the Program's `minInitialBalance` and `maxInitialBalance` or must be in the `fixedInitialBalances` array.
        + uses (number, optional) - The uses to set on each Value.  
        + startDate (string, optional) - Override the Program's startDate for the Value.
        + endDate (string, optional) - Override the Program's endDate for the Value.
        + tags (array[string], optional) - {{tags}}  These are applied to each Value.
        
    + Body
    
            {
                "id": "printer-block-21",
                "count": 200,
                "codeGeneration": {
                    "length": 12
                },
                "balance": 5000
            }
    
+ Response 201 (application/json)
    + Attributes (Issuance)

    + Body
    
            {
                "id": "printer-block-21",
                "count": 200,
                "csv": "<URL to download CSV from>",
                "createdDate": "2018-04-17T23:20:08.000Z"
            }
