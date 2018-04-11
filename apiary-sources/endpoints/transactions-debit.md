### [POST /transactions/debit]
---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}\
        + currency (string, required) - {{currency}}
        + lineItems ()
        
    + Body 
    
            {"userSuppliedId":"activate-giftcard-a45etsraw"}
    
+ Response 200
    + Attributes
        + transaction (Transaction[LineItem])

    + Body
    
            { // todo }