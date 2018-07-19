### Get a Transaction [GET /transactions/{id}]

+ Parameter
    + id (string) - the ID of the Transaction to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:debitTransaction1.response.body}

### List Transactions [GET /transactions{?limit}{?transactionType}{?createdDate}{?maxCreatedDate}]

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + transactionType (string, optional) - {{filter.transactionType}}
    + createdDate (string, optional) - {{filter.createdDate}}

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
