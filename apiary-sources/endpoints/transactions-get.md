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
            
### List Transaction Chain [GET /transactions/{id}/chain
Returns all Transactions in a Transaction Chain. 

A Transaction Chain is an ordered list of Transactions and results from creating Transactions that depend on another; such Transactions are reverse and pending capture/void (coming soon). The Transaction Chain can be retrieved using any Transaction ID in the chain and can be used to display the current state of a Transaction.  

+ Parameter
    + id (string, required) - The ID of any Transaction in the chain to look up. 

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

            {REQUEST_REPLACEMENT:transactionChain.response.body}

### List Transactions [GET /transactions{?limit}{?transactionType}{?createdDate}{?currency}{?valueId}]

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + transactionType (string, optional) - {{filter.transactionType}}  {{filter.ops.in}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + currency (string, optional) - {{filter.currency}}  {{filter.ops.in}}
    + valueId (string, optional) - Filter by Value ID used in the Transaction.  {{filter.ops.in}}

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
