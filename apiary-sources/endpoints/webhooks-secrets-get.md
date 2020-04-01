### Get Secret [GET /webhooks/{id}/secrets/{secretId}]
+ Parameter
    + id (string) - {{webhook.id}}
    + secretId (string) - {{webhook.secret.id}}

+ Request
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Attributes (WebhookSecret)
   
    + Body
            
            {
              "id": "ae5ebfa3-69a9-4946-a17d-886f87ee69c9",
              "secret": "F5MUORROLVRSPGDP",
              "createdDate": "2020-03-26T20:48:01.251Z"
            }
