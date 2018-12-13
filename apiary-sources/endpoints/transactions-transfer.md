### Transfer [POST /transactions/transfer]

Transfer value from a Lightrail or Stripe payment source to a Lightrail payment destination.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + source (StripeOrLightrailTransactionParty, required) - {{transaction.source}}
        + destination (LightrailTransactionParty, required) - {{transaction.destination}}
        + amount (number, required) - The amount to transfer, > 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pendingRequest}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:transfer.body}

+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:transfer.response.body}

+ Response 409 (application/json)

    You cannot transfer from a Value more balance than is available (if `allowRemainder` is not `true`).

    + Attributes (StripeRestError)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
