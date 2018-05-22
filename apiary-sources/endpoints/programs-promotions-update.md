### Update a Promotion Program [PATCH /programs/promotions/{id]

+ Parameter
    + id (string) - the ID of the Promotion Program to modify.

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + name (string, optional) - {{program.name}}
        + active (boolean, optional) - {{value.active}}
        + discount (boolean, optional) - {{value.discount}} Default is `true`. 
        + preTax (boolean, optional) - {{value.preTax}} Default is `true`.
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}}
        + endDate (string, optional) - {{program.endDate}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "tags": ["spring-marketing-push"]
            }
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "id": "spring-promotion-usd",
                "name": "Spring Promotion USD",
                "type": "promotion",
                "currency": "USD",
                "access": "secureCode",
                "discount": "true",
                "preTax": "true",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialBalance": null,
                "maxInitialBalance": null,
                "fixedInitialValues": [
                    500
                ],
                "uses": null,
                "tags": ["spring-marketing-push"]
                "metadata": null,
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }

+ Response 409 (application/json)

    Attempting to set fixedInitialValues on a Promotion Program that uses a balance range, i.e. minInitialBalance and maxInitialBalance, or attempting to set minInitialBalance and maxInitialBalance on a Giftcard Program that uses fixedInitialValues. 

    + Body
    
            {
                "statusCode": 409,
                "message": "Wrong type of balance restriction for Program 'abc123'.",
                "messageCode": "WrongBalanceTypeForProgram"
            }
            
+ Response 409 (application/json)

    Attempting to change the 'discount' or 'preTax' flag on a Promotion Program that is referenced by existing Values. These are fundamental attributes of Value behaviour. To update these flags on an existing Program, any attached Values would need to be deleted.  

    + Body
    
            {
                "statusCode": 409,
                "message": "Cannot update 'discount' for Program 'abc123'.",
                "messageCode": "ProgramDiscountFlagInUse"
            }
