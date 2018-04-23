### Create Program [POST /programs]

Create a new Program.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + programId (string, required) - {{program.programId}}
        + name (string, optional) - {{transaction.name}}
        + currency (string, required) - {{currency}}
        + access (enum[string], required) - How the valueStores can be accessed
            + `customerId` - must be associated with a customerId.
            + `generatedCode` - automatic code generated.
            + `setCode` - a code must be manually set.
        + isSavings (boolean, optional) - {{valueStore.isSavings}}
        + pretax (boolean, optional) - {{valueStore.pretax}}
        + active (boolean, optional) - {{valueStore.active}}
        + redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
        + valueRule (number, optional) - {{valueStore.valueRule}}
        + minInitialValue (number, optional) - {{program.minInitialValue}}
        + maxInitialValue (number, optional) - {{program.maxInitialValue}}
        + fixedInitialValues (array[number], option) - A list of values the Value Store can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}


    + Body

            {
                "programId": "unique-id-123",
                "name": "Giftcard programm",
                "currency": "CAD",
                "access": "generatedCode",
                "fixedInitialValues": [
                    500,
                    1500,
                    2500
                ]
            }
    
+ Response 200
    + Attributes (Customer)

    + Body
            
            {
                "programId": "unique-id-123",
                "name": "Giftcard programm",
                "currency": "CAD",
                "access": "generatedCode",
                "isSavings": "false",
                "pretax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": null,
                "maxInitialValue": null,
                "fixedInitialValues": [
                    500,
                    1500,
                    2500
                ],
                "uses": null,
                "tags": [],
                "metadata": null
            }
