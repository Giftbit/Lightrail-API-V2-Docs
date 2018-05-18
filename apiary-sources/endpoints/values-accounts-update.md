### Update an Account [PATCH /values/accounts/{id}]

+ Parameter
    + id (string) - the id of the Account to modify.

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, optional) - {{value.id}}  If present must match the id in the path.
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "frozen": true
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
                "frozen": true,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
