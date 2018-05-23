### Create an Account [POST /values/accounts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{value.id}}
        + contact (string, required) - Associate the Value with the given Contact.
        + currency (string, required) - {{currency.code}}
        + balance (number, optional) - {{value.balance}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "id": "account-1",
                "contact": "contact-jeff-2",
                "currency": "USD"
            }
    
+ Response 201 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "account-1",
                "type": "account",
                "program": null,
                "currency": "USD",
                "contact": "contact-jeff-2",
                "balance": 0, 
                "active": true,
                "frozen": false,
                "canceled": false,
                "preTax": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
