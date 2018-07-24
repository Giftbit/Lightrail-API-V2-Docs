### Get a Contact [GET /contacts/{id}]

+ Parameter
    + id (string) - the ID of the Contact to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {"id":"e7db2103-806e-4887-b","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-24T18:49:49.000Z","updatedDate":"2018-07-24T18:49:49.000Z"}

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

            [{"id":"416ad93e-af6d-4a2a-8","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-24T18:46:06.000Z","updatedDate":"2018-07-24T18:46:06.000Z"}]