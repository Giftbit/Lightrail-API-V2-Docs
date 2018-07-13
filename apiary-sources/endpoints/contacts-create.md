### Create a Contact [POST /contacts]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{contact.id}}  {{idPurpose}}
        + firstName (string, optional) - {{contact.firstName}}
        + lastName (string, optional) - {{contact.lastName}}
        + email (string, optional) - {{contact.email}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{contact.metadata}}

    + Body

            {"id":"id_JeffreyLebowski_rn1","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"}}
    
+ Response 201 (application/json)
    + Attributes (Contact)

    + Body
            
            {"id":"id_JeffreyLebowski_rn1","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-13T18:49:25.000Z","updatedDate":"2018-07-13T18:49:25.000Z"}
