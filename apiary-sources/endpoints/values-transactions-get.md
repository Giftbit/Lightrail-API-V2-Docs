### List a Value's Transactions [GET /values/{id}/transactions{?limit}{?transactionType}{?createdDate}{?currency}]

+ Parameter
    + id (string) - the ID of the Value to get the Transactions of.
    + transactionType (string, optional) - {{filter.transactionType}}  {{filter.ops.in}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + currency (string, optional) - {{filter.currency}}  {{filter.ops.in}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Transaction])

    + Body

            {REQUEST_REPLACEMENT:listTransactions1.response.body}
