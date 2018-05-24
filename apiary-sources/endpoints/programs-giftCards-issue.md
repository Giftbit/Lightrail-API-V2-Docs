### Issue Gift Cards from a Program [POST /programs/giftCards/{id}/issue]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - "Program issuance request ID.  This ID is used to generate Gift Card IDs and prevent duplicate requests from being processed."
        + count (number, required) - The number of Gift Cards to issue.
        + contacts (array[string], optional) - List of Contact IDs to apply the Gift Card to directly.  {{program.issuance.lengthMatchCount}}  {{program.issuance.oneOfAccess}}
        + codes (array[string], optional) - List of codes to use for each Gift Card created.  {{program.issuance.lengthMatchCount}}  {{program.issuance.oneOfAccess}}
        + codeGeneration (CodeGeneration, optional) - {{program.issuance.codeGeneration}} {{program.issuance.oneOfAccess}}
        + secureCodes (boolean, optional) - {{program.issuance.secureCodes}}
        + startDate (string, optional) - {{program.issuance.startDate}}
        + endDate (string, optional) - {{program.issuance.endDate}}
        
    + Body
    
            {
                "id": "partner-release-11",
                "count": 10,
                "codeGeneration": {
                    "length": 12,
                    "characters": "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                },
                "secureCodes": true
            }
    
+ Response 201 (application/json)
    + Attributes
        + count (number, required) - The number of Gift Cards generated.
        + values (Value, optional) - A list of Gift Cards generated.  This list is only available if `count` < 1000.
        + csv (string, required) - A link to a CSV with details of the generated Gift Cards.  This CSV will always contain the full code.

    + Body
    
            {
                "count" 10,
                "values": [
                    {
                        "id": "partner-release-11-1",
                        "type": "giftCard",
                        "program": "partner-release",
                        "currency": "USD",
                        "code": "…LQWT",
                        "balance": 2400,
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
                    },
                    // ...
                ],
                "csv": "https://www.lightrail.com/csv/partner-release-11-7116484d77ca.csv"
            }
