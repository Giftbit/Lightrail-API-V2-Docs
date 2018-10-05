### Get a Program [GET /programs/{id}]

+ Parameter
    + id (string) - the ID of the Program to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Program)

    + Body

                {REQUEST_REPLACEMENT:createProgram1.response.body}

### List Programs [GET /programs{?limit}{?id}{?currency}{?tags}{?startDate}{?endDate}{?createdDate}{?updatedDate}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}} {{filter.ops.in}}
    + currency (string, optional) - {{filter.currency}} {{filter.ops.in}}
    + tags (string, optional) - {{filter.tags}} {{filter.ops.in}}
    + startDate (string, optional) - {{filter.startDate}} {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}} {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}} {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}} {{filter.ops.date}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Program])

    + Body

            {REQUEST_REPLACEMENT:listPrograms1.response.body}
