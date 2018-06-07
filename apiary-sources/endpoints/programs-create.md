### Create Program [POST /programs]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{program.id}}  {{idPurpose}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency.code}}
        + discount (boolean, optional) - {{value.discount}} Default is `true`. 
        + preTax (boolean, optional) - {{value.preTax}} Default is `true`.
        + active (boolean, optional) - {{value.active}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialBalances (array[number], optional) -  {{program.fixedInitialBalances}}
        + fixedInitialUses (array[number], optional) -  {{program.fixedInitialUses}}
        + tags (array[string], optional) - {{tags}}
        + startDate (string, optional) - {{program.startDate}}
        + endDate (string, optional) - {{program.endDate}}
        + metadata (object, optional) - {{program.metadata}}
        
    + Body

            {
                "id": "spring-promotion-usd",
                "name": "Spring Promotion USD",
                "currency": "USD",
                "preTax": true,
                "discount": true,
                "fixedInitialBalances": [
                    500
                ],
                "tags": ["promotion", "spring-promotion-usd"]
            }
    
+ Response 201 (application/json)
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
                "tags": ["gift-card"],
                "metadata": null,
                "startDate": null,
                "endDate": null,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z"
            }
