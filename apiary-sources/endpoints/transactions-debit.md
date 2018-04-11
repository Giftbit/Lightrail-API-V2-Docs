### Debit [POST /transactions/debit]
---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}\
        + currency (string, required) - {{currency}}
        + lineItems (array[LineItem])
        
    + Body 
    
            {"userSuppliedId":"activate-giftcard-a45etsraw"}
    
+ Response 200
    + Attributes

    + Body
    
            { }