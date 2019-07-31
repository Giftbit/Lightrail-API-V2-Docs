### Create a Contact [POST /contacts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{contact.id}}  {{contact.idPurpose}}
        + firstName (string, optional) - {{contact.firstName}}
        + lastName (string, optional) - {{contact.lastName}}
        + email (string, optional) - {{contact.email}}
        + metadata (object, optional) - {{contact.metadata}}

    + Body

            {REQUEST_REPLACEMENT:createContact1.body}
    
+ Response 201 (application/json)
    + Attributes (Contact)

    + Body
            
            {REQUEST_REPLACEMENT:createContact1.response.body}
