### Transfer [POST /transactions/transfer]

Transfer value from a Lightrail or Stripe payment source to a Lightrail payment destination.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + source (LightrailTransactionParty, StripeTransactionParty, required) - The payment rail to debit.  Must be a `stripe` or `lightrail` rail that refers to a specific Value.
        + destination (LightrailTransactionParty, required) - The payment rail to credit. Must refer to a single `lightrail` Value.
        + amount (number, required) - The amount to transfer, > 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
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
