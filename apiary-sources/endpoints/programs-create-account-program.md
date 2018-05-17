### Create Account/Points Program [POST /programs]

Create a new Account/Points Program.

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
        + active (boolean, optional) - {{value.active}}
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}

    + Body

            {
                "programId": "contact-accounts-usd",
                "name": "Accounts USD",
                "currency": "USD",
                "access": "contactId",
                "tags": ["account"]
            }
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {
                "programId": "contact-accounts-usd",
                "name": "Accounts USD",
                "currency": "USD",
                "access": "contactId",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialBalance": null,
                "maxInitialBalance": null,
                "fixedInitialValues": null
                "uses": null,
                "tags": ["account"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
