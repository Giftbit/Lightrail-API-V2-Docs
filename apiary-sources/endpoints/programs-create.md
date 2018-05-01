### Create Program [POST /programs]

Create a new Program.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + programId (string, required) - {{program.programId}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency}}
        + access (enum[string], required) - {{valueStore.access.description}}
            + `customerId` - {{valueStore.access.types.customerId}}
            + `secureCode` - {{valueStore.access.types.secureCode}}
            + `publicCode` - {{valueStore.access.types.publicCode}}
        + discount (boolean, optional) - {{valueStore.discount}}
        + preTax (boolean, optional) - {{valueStore.preTax}}
        + active (boolean, optional) - {{valueStore.active}}
        + redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
        + valueRule (number, optional) - {{valueStore.valueRule}}
        + minInitialValue (number, optional) - {{program.minInitialValue}}
        + maxInitialValue (number, optional) - {{program.maxInitialValue}}
        + fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
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
    
+ Response 200 (application/json)
    + Attributes (Customer)

    + Body
            
            {
                "programId": "unique-id-123",
                "name": "Giftcard programm",
                "currency": "CAD",
                "access": "generatedCode",
                "discount": "false",
                "preTax": "false",
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
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
