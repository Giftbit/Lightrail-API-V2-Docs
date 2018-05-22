### Get Contacts [GET /contacts{?limit}{?offset}{?id}{?tags}{?firstName}{?lastName}{?email}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + id (number, optional) - {{filter.id}}  {{filter.list}}
    + tags (number, optional) - {{filter.tags}}  {{filter.list}}
    + firstName (string, optional) - {{filter.firstName}}
    + lastName (string, optional) - {{filter.lastName}}
    + email (string, optional) - {{filter.email}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1

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
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            ]

### Get Contact [GET /contacts/{id}]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Contact to get.

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
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
