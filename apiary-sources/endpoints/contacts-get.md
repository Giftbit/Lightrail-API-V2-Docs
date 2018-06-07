### Get a Contact [GET /contacts/{id}]

+ Parameter
    + id (string) - the ID of the Contact to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {
                "id": "unique-id-123",
                "firstName": "Jeffrey",
                "lastName": "Lebowski",
                "email": "thedude@example.com",
                "tags": [],
                "metadata": {
                    "alias": "El Duderino"
                },
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z"
            }

### List Contacts [GET /contacts{?limit}{?id}{?tags}{?firstName}{?lastName}{?email}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}}  {{filter.list}}
    + tags (string, optional) - {{filter.tags}}  {{filter.list}}
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

            [
                {
                    "id": "unique-id-123",
                    "firstName": "Jeffrey",
                    "lastName": "Lebowski",
                    "email": "thedude@example.com",
                    "tags": [],
                    "metadata": {
                        "alias": "El Duderino"
                    },
                    "createdDate": "2018-04-17T23:20:08.000Z",
                    "updatedDate": "2018-04-17T23:20:08.000Z"
                }
            ]
