### Get a Contact [GET /contacts/{id}]

+ Parameter
    + id (string) - the ID of the Contact to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {"id":"id_JeffreyLebowski_rn1","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-13T18:59:47.000Z","updatedDate":"2018-07-13T18:59:47.000Z"}

### List Contacts [GET /contacts{?limit}{?id}{?tags}{?firstName}{?lastName}{?email}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}}  {{filter.ops.in}}
    + tags (string, optional) - {{filter.tags}}  {{filter.ops.in}}
    + firstName (string, optional) - {{filter.firstName}}  {{filter.ops.string}}
    + lastName (string, optional) - {{filter.lastName}}  {{filter.ops.string}}
    + email (string, optional) - {{filter.email}}  {{filter.ops.string}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"

    + Attributes (array[Contact])

    + Body

            [{"id":"id_JeffreyLebowski_rn1","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-13T18:59:47.000Z","updatedDate":"2018-07-13T18:59:47.000Z"}]