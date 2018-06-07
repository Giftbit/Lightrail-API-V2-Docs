### Get an Issuance [GET /programs/{programId}/issuances/{id}]

+ Parameter
    + id (string) - the ID of the Issuance to get.
    + programId (string) - the ID of the Program of the Issuance.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Issuance)

    + Body

            {
                "id": "printer-block-21",
                "count": 200,
                "csv": "<URL to download CSV from>",
                "createdDate": "2018-04-17T23:20:08.000Z"
            }

### List Issuances [GET /programs/{id}/issuances]

+ Parameter
    + id (string) - the ID of the Program to get Issuances from.
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
            
    + Attributes (array[Issuance])

    + Body
    
            [
                {
                    "id": "printer-block-21",
                    "count": 200,
                    "csv": "<URL to download CSV from>",
                    "createdDate": "2018-04-17T23:20:08.000Z"
                }
            ]