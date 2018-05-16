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
        + access (enum[string], required) - {{value.access.description}}
            + `secureCode` - {{value.access.types.secureCode}}
        + active (boolean, optional) - {{value.active}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "programId": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                "minInitialBalance": 500,
                "maxInitialBalance": 100000,
                "tags": ["giftcard"]
            }
    
+ Response 200 (application/json)
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
                "minInitialBalance": 500,
                "maxInitialBalance": 100000,
                "fixedInitialValues": null,
                "uses": null,
                "tags": ["giftcard"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
