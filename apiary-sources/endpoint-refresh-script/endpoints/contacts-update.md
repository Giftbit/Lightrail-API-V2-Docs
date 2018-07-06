### Update a Contact [PATCH /contacts/{id}]
            
+ Parameter
    + id (string) - the ID of the Contact to update.

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, optional) - {{contact.id}}  If present must match the ID in the path.
        + firstName (string, optional) - {{contact.firstName}}
        + lastName (string, optional) - {{contact.lastName}}
        + email (string, optional) - {{contact.email}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{contact.metadata}}

    + Body

            {REQUEST_REPLACEMENT:updateContact1.body}
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {REQUEST_REPLACEMENT:updateContact1.response.body}
