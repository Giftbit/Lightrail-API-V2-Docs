### List a Value's Attached Contacts [GET /values/{id}/contacts{?limit}{?tags}{?firstName}{?lastName}{?email}{?valueId}]

+ Parameter
    + id (string) - The ID of the Value to get the Contacts of.
    + limit (number, optional) - {{pagination.limit}}
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
        
    + Attributes (array[Contacts])

    + Body

            {REQUEST_REPLACEMENT:listValue1Contacts.response.body}
