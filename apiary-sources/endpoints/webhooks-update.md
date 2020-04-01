### Update Webhook [PATCH /webhooks/{id}]
+ Parameter
    + id (string) - {{webhook.id}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + url (string, required) - {{webhook.url}}
        + events (array[string], required) - {{webhook.events}}
        + active (boolean, optional) - {{webhook.active}}
        
    + Body

            {REQUEST_REPLACEMENT:updateWebhook.body}
    
+ Response 200 (application/json)
    + Attributes (Webhook)

    + Body
            
            {REQUEST_REPLACEMENT:updateWebhook.response.body}
