### Create Promotion Program [POST /programs]

Create a new Promotion Program. A Promotion can be in the form of a generic code like "SAVE10" which your contact's would enter during checkout. A Promotion may also be a unique code which is distributed to a contact or it may even be directly attached to a contact's account.  

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + programId (string, required) - {{program.programId}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency.code}}
        + access (enum[string], required) - {{value.access.description}}
            + `contactId` - {{value.access.types.contactId}}
            + `secureCode` - {{value.access.types.secureCode}}
            + `publicCode` - {{value.access.types.publicCode}}          
        + active (boolean, optional) - {{value.active}}
        + minInitialBalance (number, optional) - {{program.minInitialBalance}}
        + maxInitialBalance (number, optional) - {{program.maxInitialBalance}}
        + fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "programId": "spring-promotion-usd",
                "name": "Spring Promotion USD",
                "currency": "USD",
                "access": "secureCode",
                "preTax": true,
                "discount": true,
                "fixedInitialValues": [
                    500
                ],
                "tags": ["promotion", "spring-promotion-usd"]
            }
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "programId": "spring-promotion-usd",
                "name": "Spring Promotion USD",
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
                "tags": ["gift-card"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
