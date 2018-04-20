### Create a Program [POST /programs]

Create a new program to create value stores from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + programId (string, required) 
        + currency (string, required) - {{currency}}
        + defaultInitialValue (number, optional) - Initial Value of the value store.
        + maxInitialValue (number, optional)
        + maxInitialValue (number, optional) 
        + accessType (string, optional) - `ENCRYPTED_CODE, GENERIC_CODE, CUSTOMER_ID`
        + createInactive (boolean, optional) - The ValueStore will be created as inactive if this is true. 
        + pretax (boolean, optional) - {{valueStore.pretax}}
        + discount (boolean, optional) 
        + redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
        + valueRule (number, optional) - {{valueStore.valueRule}}
        + uses (number, optional) - {{valueStore.uses}}
        + tags (array[string]) - Tags that represent this type of value.
        
    + Body
    
            {
                "programId": "p1",
                "currency": "USD",
                "minInitialValue": 500,
                "maxInitialValue": 100000,
                "accessType": "ENCRYPTED_CODE",
                "tags": ["gift cards"],
                "discount": false, 
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "programId": "p1",
                "currency": "USD",
                "minInitialValue": 500,
                "maxInitialValue": 100000,
                "accessType": "ENCRYPTED_CODE",
                "tags": ["giftcard"],
                "uses": "infinite",
                "discount": false, 
            }
