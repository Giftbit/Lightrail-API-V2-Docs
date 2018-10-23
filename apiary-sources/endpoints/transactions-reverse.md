### Reverse [POST /transactions/{id}/reverse]
Reversing a Transaction returns value back to where it came from. Reverse is used for refunding or undoing a Transaction.      

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
     
    + Body

            {REQUEST_REPLACEMENT:reverseCheckout.body}

+ Response 201 (application/json)

    + Attributes
        + id (string, required) - {{transaction.id}}
        + transactionType (string, required) - `reverse`
        + currency (string, required) - {{currency.code}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - {{transaction.remainderResponse}}
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:reverseCheckout.response.body}

+ Response 422 (application/json)

    Transactions, such as Reverse, create a Transaction chain. Transactions can only be reversed if they are the last Transaction in the chain. 

    + Attributes (StripeRestError)

    + Body

            {
                "statusCode": 422,
                "message": "Cannot reverse transaction that is not last in the transaction chain. Use endpoint .../v2/transactions/${id}/chain to find last transaction in chain",
                "messageCode": "TransactionNotReversible"
            }
