### Reverse [POST /transactions/{transactionToReverseId}/reverse]
Returns value back to where it came from. Reverse adds a Transaction to the [Transaction Chain](#reference/0/transactions/get-transaction-chain).      

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionToReverseId (string, required) - The ID of the Transaction to reverse.
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
     
    + Body

            {REQUEST_REPLACEMENT:reverseCheckout.body}

+ Response 201 (application/json)

    + Attributes (Transaction)

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
