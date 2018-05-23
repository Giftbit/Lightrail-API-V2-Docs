### Update a Gift Card Program [PATCH /programs/giftCards/{id}]

+ Parameter
    + id (string) - the ID of the Gift Card Program to modify.

+ Request (application/json)

    {{patch.merge}}
    Note that updating a Program does not automatically update the attributes of Values that have already been generated through it. Only new Values generated afterwards will reflect the changes. If you want existing Values to reflect your changes, you will need to update them in a separate step. 

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + name (string, optional) - {{program.name}}
        + active (boolean, optional) - {{value.active}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}} {{patch.alsoChangeValues}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}} {{patch.alsoChangeValues}}
        + fixedInitialBalances (array[number], optional) - {{program.fixedInitialBalances}}
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "tags": ["top-customers"]
            }
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "id": "gift-cards-usd",
                "name": "Gift Cards USD",
                "type": "giftCard",
                "currency": "USD",
                "access": "secureCode",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialBalance": 500,
                "maxInitialBalance": 100000,
                "fixedInitialBalances": null,
                "uses": null,
                "tags": ["giftCard", "top-customers"],
                "metadata": null,
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }