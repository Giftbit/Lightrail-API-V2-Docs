### Create Account for Contact [POST /contacts/{id}/values/accounts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + id (string) - the ID of the Contact that the account is for.

+ Attributes
    + id (string, required) - {{value.id}}
    + program (string, optional) - Associate with and copy default values from the given Program. If not provided, the default Accounts Program will be used.
    + currency (string, optional) - {{currency.code}} Required if `program` is not set.
    + balance (number, optional) - {{value.balance}}
    + active (boolean, optional) - {{value.active}}
    + frozen (boolean, optional) - {{value.frozen}}
    + metadata (object, optional) - {{value.metadata}}
    
    + Body
    
            {
                "id": "cust-123-acc-1",
                "currency": "USD",
                "balance": 2500
            }


+ Response 200 (application/json)
    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "cust-123-acc-1",
                    "programId": "accounts",
                    "currency": "USD",
                    "balance": 2500, 
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
            ]
