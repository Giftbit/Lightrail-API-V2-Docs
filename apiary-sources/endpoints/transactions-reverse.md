### Reverse [POST /transactions/{id}/reverse]

Reverses any balance changes, usesRemaining changes and Stripe charges of a Transaction. Reverse adds a Transaction to the [Transaction Chain](#reference/0/transactions/get-transaction-chain).

+ Parameter
    + id (string, required) - The ID of any Transaction to reverse. 

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + metadata (object, optional) - {{transaction.metadata}}
     
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
