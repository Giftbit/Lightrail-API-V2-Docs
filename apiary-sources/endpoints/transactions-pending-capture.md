### Capture Pending [POST /transactions/{id}/capture]

Secures a pending Transaction and adds the capture to the [Transaction Chain](#reference/0/transactions/get-transaction-chain).  A pending Transaction is created when it is created with `pending=true`.  A pending Transaction will be automatically voided unless it is captured before the `pendingVoidDate`.

+ Parameter
    + id (string) - the ID of the pending Transaction to capture.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
            
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + metadata (object, optional) - {{transaction.metadata}}
        
    + Body
        
                    {REQUEST_REPLACEMENT:pendingCapture.body}
        
+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:pendingCapture.response.body}
