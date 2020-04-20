### Get Webhook [GET /webhooks/{id}]
+ Parameter
    + id (string) - {{webhook.id}}

+ Request
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Attributes (Webhook)
    
    + Body
            
            {REQUEST_REPLACEMENT:getWebhook.response.body}
            

### List Webhooks [GET /webhooks]

+ Request
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Attributes (array[Webhook])
   
    + Body
            
            {REQUEST_REPLACEMENT:listWebhooks.response.body}
