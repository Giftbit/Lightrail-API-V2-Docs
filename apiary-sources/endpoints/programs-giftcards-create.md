### Create Gift Card Program [POST /programs/giftcards]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{program.id}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency.code}}
        + access (enum[string], required) - {{value.access.description}}
            + `contact` - {{value.access.types.contact}}
            + `secureCode` - {{value.access.types.secureCode}}
        + active (boolean, optional) - {{value.active}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "id": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                "minInitialBalance": 500,
                "maxInitialBalance": 100000,
                "tags": ["giftcard"]
            }
    
+ Response 201 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "id": "gift-cards-usd",
                "name": "Gift Cards USD",
                "type": "giftcard",
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
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
