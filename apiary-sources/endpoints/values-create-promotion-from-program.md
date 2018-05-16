### Create a Value from a Promotion Program [POST /values]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueId (string, required) - {{value.valueId}}
        + programId (string, required) - Associate with and copy default values from the given Program.
        + value (number, required) - {{value.value}}
        + startDate (number, optional) - {{value.startDate}}
        + endDate (number, optional) - {{value.endDate}}
        + metadata (number, optional) - {{value.metadata}}
        
    + Body
    
            {
                "valueId": "vs-1",
                "programId": "spring-promotion-usd",
                "value": 500
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "valueId": "vs-1",
                "programId": "gift-cards-usd",
                "currency": "USD",
                "value": 2500, 
                "discount": true,
                "preTax": true,
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
