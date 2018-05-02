### Create Promotion Program [POST /programs]

Create a new Promotion Program. A Promotion can be in the form of a generic code like "SAVE10" which your customer's would enter during checkout. A Promotion may also be a unique code which is distributed to a customer or it may even be directly attached to a customer's account.  

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
        + active (boolean, optional) - {{valueStore.active}}
        + minInitialValue (number, optional) - {{program.minInitialValue}}
        + maxInitialValue (number, optional) - {{program.maxInitialValue}}
        + fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
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
    + Attributes (Customer)

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
                "minInitialValue": null,
                "maxInitialValue": null,
                "fixedInitialValues": [
                    500
                ],
                "uses": null,
                "tags": ["gift-card"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
