### Update a Program [PATCH /programs/{id}]

+ Parameter
    + id (string) - the ID of the Program to modify.

+ Request (application/json)

    {{patch.merge}} 
    Note that updating a Program does not automatically update the attributes of Values that have already been generated through it. Only new Values generated afterwards will reflect the changes. If you want existing Values to reflect your changes, you will need to update them in a separate step. 

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + name (string, optional) - {{program.name}}
        + active (boolean, optional) - {{value.active}}
        + discount (boolean, optional) - {{value.discount}} Default is `true`. {{patch.alsoChangeValues}}
        + preTax (boolean, optional) - {{value.preTax}} Default is `true`. {{patch.alsoChangeValues}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}} {{patch.alsoChangeValues}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}} {{patch.alsoChangeValues}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}} {{patch.alsoChangeValues}}
        + fixedInitialUses (array[number], optional) -  {{program.fixedInitialUses}} {{patch.alsoChangeValues}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}} {{patch.alsoChangeValues}}
        + endDate (string, optional) - {{program.endDate}} {{patch.alsoChangeValues}}
        + metadata (object, optional) - {{program.metadata}}

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
                "fixedInitialBalances": [
                    500
                ],
                "fixedInitialUses": null,
                "tags": ["spring-marketing-push"]
                "metadata": null,
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z"
            }
