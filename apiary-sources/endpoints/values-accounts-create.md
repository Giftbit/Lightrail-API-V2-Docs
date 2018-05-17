### Create an Account [POST /values/accounts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}
        + contact (string, required) - Associate the Value with the given Contact.
        + currency (string, required) - {{currency.code}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + metadata (number, optional) - {{value.metadata}}
        
    + Body
    
            {
                "id": "account-1",
                "contact": "contact-jeff-2",
                "currency": "USD"
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "account-1",
                "type": "account",
                "programId": null,
                "currency": "USD",
                "balance": 0, 
                "preTax": false,
                "active": true,
                "frozen": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
