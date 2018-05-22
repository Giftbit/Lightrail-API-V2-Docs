### Update a Giftcard Program [PATCH /programs/giftcards/{id}]

+ Parameter
    + id (string) - the ID of the Giftcard Program to modify.

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + name (string, optional) - {{program.name}}
        + active (boolean, optional) - {{value.active}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
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
                "tags": ["giftcard", "top-customers"],
                "metadata": null,
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }

+ Response 409 (application/json)

    Attempting to set fixedInitialValues on a Giftcard Program that uses a balance range, i.e. minInitialBalance and maxInitialBalance, or attempting to set minInitialBalance and maxInitialBalance on a Giftcard Program that uses fixedInitialValues. 

    + Body
    
            {
                "statusCode": 409,
                "message": "Wrong type of balance restriction for Program 'abc123'.",
                "messageCode": "WrongBalanceTypeForProgram"
            }
