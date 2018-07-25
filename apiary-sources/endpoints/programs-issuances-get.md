### Get an Issuance (Coming soon) [GET /programs/{programId}/issuances/{id}]

+ Parameter
    + id (string) - the ID of the Issuance to get.
    + programId (string) - the ID of the Program of the Issuance.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Issuance)

    + Body

            {REQUEST_REPLACEMENT:createIssuance.response.body}

### List Issuances (Coming soon) [GET /programs/{id}/issuances]

+ Parameter
    + id (string) - the ID of the Program to get Issuances from.
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
            
    + Attributes (array[Issuance])

    + Body
    
            {REQUEST_REPLACEMENT:listIssuances.response.body}
