### Create Webhook [POST /webhooks]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{webhook.id}}
        + url (string, required) - {{webhook.url}}
        + events (array[string], required) - {{webhook.events}}
        + active (boolean, optional) - {{webhook.active}}
        
    + Body

            {REQUEST_REPLACEMENT:createWebhook.body}
    
+ Response 201 (application/json)
    + Attributes (Webhook)

    + Body
            
            {REQUEST_REPLACEMENT:createWebhook.response.body}
