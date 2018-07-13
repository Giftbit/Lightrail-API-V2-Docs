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

            {"firstName":"The Dude","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"}}
    
+ Response 200 (application/json)
    + Attributes (Contact)

    + Body
            
            {"id":"id_JeffreyLebowski_rn1","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-13T18:49:25.000Z","updatedDate":"2018-07-13T18:49:26.000Z"}
