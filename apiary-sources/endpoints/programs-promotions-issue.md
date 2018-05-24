### Issue Promotions from a Program [POST /programs/promotions/{id}/issue]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - Program issuance request ID.  This ID is used to generate Promotion IDs and prevent duplicate requests from being processed.
        + count (number, required) - The number of Promotions to issue.
        + contacts (array[string], optional) - List of Contact IDs to apply the Promotion to directly.  {{program.issuance.lengthMatchCount}}  {{program.issuance.oneOfAccess}}
        + codes (array[string], optional) - List of codes to use for each Promotion created.  {{program.issuance.lengthMatchCount}}  {{program.issuance.oneOfAccess}}
        + codeGeneration (CodeGeneration, optional) - {{program.issuance.codeGeneration}} {{program.issuance.oneOfAccess}}
        + secureCodes (boolean, optional) - {{program.issuance.secureCodes}}
        + startDate (string, optional) - {{program.issuance.startDate}}
        + endDate (string, optional) - {{program.issuance.endDate}}
        
    + Body
    
            {
                "id": "summer-promo-2077",
                "count": 100,
                "codeGeneration": {
                    "length": 8,
                    "characters": "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                    "prefix": "SUMMMER-"
                    "suffix": "-2077"
                },
                "secureCodes": true
            }
    
+ Response 201 (application/json)
    + Attributes
        + count (number, required) - The number of Promotions generated.
        + values (Value, optional) - A list of Promotions generated.  This list is only available if `count` < 1000.
        + csv (string, required) - A link to a CSV with details of the generated Promotions.  This CSV will always contain the full codes (if the Promotions were not attached directly to Contacts).

    + Body
    
            {
                "count" 100,
                "values": [
                    {
                        "id": "summer-promo-2077-1",
                        "type": "promotion"
                        "program": "summerpromo",
                        "currency": "USD",
                        "code": "…2077",
                        "balance": 500,
                        "active": true,
                        "frozen": false,
                        "canceled": false,
                        "preTax": false,
                        "redemptionRule": null,
                        "valueRule": null,
                        "uses": 1,
                        "startDate": "2077-07-01T00:00:00.000Z",
                        "endDate": "2077-10-01T00:00:00.000Z",
                        "tags": [],
                        "metadata": null,
                        "createdDate": "2018-04-17T23:20:08.404Z",
                        "updatedDate": "2018-04-17T23:20:08.404Z"
                    },
                    // ...
                ],
                "csv": "https://www.lightrail.com/csv/summer-promo-2077-b03b610c61aa4146.csv"
            }
