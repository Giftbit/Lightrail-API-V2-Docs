### Get a Contact [GET /contacts/{id}]

+ Parameter
    + id (string) - the ID of the Contact to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {REQUEST_REPLACEMENT:createContact1.response.body}

### List Contacts [GET /contacts{?limit}{?id}{?firstName}{?lastName}{?email}{?valueId}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}}  {{filter.ops.in}}
    + firstName (string, optional) - {{filter.firstName}}  {{filter.ops.string}}
    + lastName (string, optional) - {{filter.lastName}}  {{filter.ops.string}}
    + email (string, optional) - {{filter.email}}  {{filter.ops.string}}
    + valueId (string, optional) - {{filter.valueId}} {{filter.ops.string}}

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

            {REQUEST_REPLACEMENT:listContacts1.response.body}
