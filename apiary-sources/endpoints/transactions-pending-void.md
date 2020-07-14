### Void Pending [POST /transactions/{id}/void]

Releases a pending Transaction and adds the void to the [Transaction Chain](#reference/0/transactions/get-transaction-chain).  A pending Transaction is created when it is created with `pending=true`.  A pending Transaction will be automatically voided but voiding it manually releases the funds sooner.

+ Parameter
    + id (string) - the ID of the pending Transaction to void.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}} {{whitespace.id}}
        + metadata (object, optional) - {{transaction.metadata}}
        
    + Body
    
                {REQUEST_REPLACEMENT:pendingVoid.body}

+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:pendingVoid.response.body}
