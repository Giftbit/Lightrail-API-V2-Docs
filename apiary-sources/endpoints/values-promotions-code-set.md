### Set a Promotion Value's code [PUT /values/promotions/{id}/code]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, required) - The code to set.
        + secure (boolean, optional) - If true the code is stored securely and only shown in abbreviated form.
        
    + Body
    
            {
                "code": "c3d177ff950b4e2796e341f65976e1b1",
                "secure" true
            }

+ Parameter
    + id (string) - the id of the Promotion to update the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{value.code}}

    + Body

            {
                "code": "…e1b1"
            }
