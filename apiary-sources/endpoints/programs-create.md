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

### Create a ValueStore From a Program [POST /programs/{programId}/valueStores]

Create a new program to create value stores from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}
        + value (number, optional) - {{valueStore.value}}
        + active (boolean, optional) - {{valueStore.active}}
        + frozen (boolean, optional) - {{valueStore.frozen}}
        + startDate (number, optional) - {{valueStore.startDate}}
        + endDate (number, optional) - {{valueStore.endDate}}
        + metadata (number, optional) - {{valueStore.metadata}}
        
    + Body
    
            {
                "valueStoreId": "v1",
                "value": 2500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "v1",
                "currency": "USD",
                "value": 2500,
                "tags": ["giftcard"],
                "uses": "infinite",
                "discount": false, 
            }