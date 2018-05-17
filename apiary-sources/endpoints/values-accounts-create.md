### Create Account [POST /values/accounts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}
        + customerId (string, required) - Associate the Value with the given Customer.  Cannot be set with `code`.
        + currency (string, required) - {{currency.code}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + metadata (number, optional) - {{value.metadata}}
        
    + Body
    
            {
                "id": "account-1",
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
