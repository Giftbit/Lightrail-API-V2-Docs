### Reverse [POST /transactions/{id}/reverse]
Returns value back to where it came from. Reverse adds a Transaction to the [Transaction Chain](#reference/0/transactions/get-transaction-chain).      

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

    A Transaction cannot be reversed if it is not the last Transaction in the Transaction Chain. 

    + Attributes (StripeRestError)

    + Body

            {
                "statusCode": 422,
                "message": "Cannot reverse Transaction that is not last in the Transaction Chain. See documentation for more information on the Transaction Chain.",
                "messageCode": "TransactionNotReversible"
            }
