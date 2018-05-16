### Create Account/Points Program [POST /programs]

Create a new Account/Points Program.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + programId (string, required) - {{program.programId}}
        + name (string, optional) - {{program.name}}
        + currency (string, required) - {{currency}}
        + access (enum[string], required) - {{value.access.description}}
            + `customerId` - {{value.access.types.customerId}}
        + active (boolean, optional) - {{value.active}}
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "programId": "customer-accounts-usd",
                "name": "Accounts USD",
                "currency": "USD",
                "access": "customerId",
                "tags": ["account"]
            }
    
+ Response 200 (application/json)
    + Attributes (Customer)

    + Body
            
            {
                "programId": "customer-accounts-usd",
                "name": "Accounts USD",
                "currency": "USD",
                "access": "customerId",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": null,
                "maxInitialValue": null,
                "fixedInitialValues": null
                "uses": null,
                "tags": ["account"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
