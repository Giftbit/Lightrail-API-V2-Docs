### Get a Value [GET /values/{id}{?showCode}]

+ Parameter
    + id (string) - the ID of the Value to get.
    + showCode (boolean, optional) - {{value.showCode}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {REQUEST_REPLACEMENT:createValue1.response.body}

### Get a Value by Code [GET /values?code={code}{?showCode}]

+ Parameter
    + code (string) - the code (secret or generic) of the Value to get.
    + showCode (boolean, optional) - {{value.showCode}}

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Value)

    + Body

            {REQUEST_REPLACEMENT:createValue1.response.body}

### List Values [GET /values{?limit}{?showCode}{?programId}{?currency}{?contactId}{?balance}{?uses}{?discount}{?active}{?frozen}{?canceled}{?pretax}{?startDate}{?endDate}{?createdDate}{?updatedDate}{?tags}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + showCode (boolean, optional) - {{value.showCode}}
    + programId (string, optional) - {{filter.programId}}  {{filter.ops.in}}
    + currency (string, optional) - {{filter.currency}}  {{filter.ops.in}}
    + contactId (string, optional) - {{filter.contactId}}  {{filter.ops.in}}
    + balance (number, optional) - {{filter.balance}}  {{filter.ops.number}}
    + usesRemaining (number, optional) - {{filter.usesRemaining}}  {{filter.ops.number}}
    + discount (boolean, optional) - {{filter.discount}}
    + active (boolean, optional) - {{filter.active}}
    + frozen (boolean, optional) - {{filter.frozen}}
    + canceled (boolean, optional) - {{filter.canceled}}
    + pretax (boolean, optional) - {{filter.pretax}}
    + startDate (string, optional) - {{filter.startDate}}  {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}}  {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}}  {{filter.ops.date}}
    + tags (string, optional) - {{filter.tags}}  {{filter.ops.in}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Value])

    + Body

            {REQUEST_REPLACEMENT:listValues1.response.body}

+ Response 200 (text/csv)

    You can request a CSV file of the output by setting `Accept: text/csv` in the request header.

    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Body

            id,currency,balance,usesRemaining,programId,contactId,code,isGenericCode,pretax,active,canceled,frozen,discount,discountSellerLiability,redemptionRule,balanceRule,startDate,endDate,metadata,createdDate,updatedDate
            vs-1,USD,2500,,giftCards,,…GYOA,false,false,true,false,false,false,,,,,,,2018-04-17T23:20:08.000Z,2018-04-17T23:20:08.000Z
