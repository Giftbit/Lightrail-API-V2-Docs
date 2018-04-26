### Create Gift Card Program [POST /programs]

Create a new Gift Card Program.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + programId (string, required) - {{program.programId}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency}}
        + access (enum[string], required) - {{valueStore.access.description}}
            + `secureCode` - {{valueStore.access.types.secureCode}}
        + active (boolean, optional) - {{valueStore.active}}
        + minInitialValue (number, optional) - {{program.minInitialValue}}
        + maxInitialValue (number, optional) - {{program.maxInitialValue}}
        + fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "programId": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                "minInitialValue": 500,
                "maxInitialValue": 100000,
                "tags": ["giftcard"]
            }
    
+ Response 200
    + Attributes (Customer)

    + Body
            
            {
                "programId": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": 500,
                "maxInitialValue": 100000,
                "fixedInitialValues": null,
                "uses": null,
                "tags": ["giftcard"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
