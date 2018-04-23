### Set Value Store Code [PUT /valueStores/{valueStoreId}/code]

Set a Value Store's code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, required) - The code to set.
        + secure (boolean, optional) - If true the code is stored securely and only shown as `codeLastFour`.
        
    + Body
    
            {
                "code": "c3d177ff950b4e2796e341f65976e1b1",
                "secure" true
            }

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to update the code of.

+ Response 200
    + Attributes
        + code (string, optional) - {{valueStore.code.code}}
        + codeLastFour (string, optional) - {{valueStore.code.codeLastFour}}

    + Body

            {
                "codeLastFour": "e1b1"
            }
