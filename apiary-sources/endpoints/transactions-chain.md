### List Transaction Chain [GET /transactions/{id}/chain{?limit}{?transactionType}{?createdDate}{?currency}{?valueId}]
Transactions that depend on another Transaction, such as Reverse and Pending (coming soon), create a Transaction chain. The Transaction chain guarantees no two Transactions can depend on the same Transaction. For example, this means you cannot reverse the same Transaction twice.    

+ Parameter
    + id (string, required) - The ID of the Transaction for which you wish to look up the Transaction chain for. 
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

            {REQUEST_REPLACEMENT:transactionChain.response.body}
