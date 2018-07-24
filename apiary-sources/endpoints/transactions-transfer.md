### Transfer [POST /transactions/transfer]

Transfer value between a payment source and a payment destination.  Currently the `lightrail` and `stripe` rails are supported as `source`s and the `lightrail` rail is supported as a destination.

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
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:transfer.body}

+ Response 201 (application/json)

    + Attributes
        + id (string, required) - {{transaction.id}}
        + transactionType (string, required) - `transfer`
        + currency (string, required) - {{currency.code}}
        + steps (array[TransactionStep], required) - {{transaction.steps}}
        + remainder (number, required) - {{transaction.remainder}}
        + simulated (boolean, optional) - {{transaction.simulated}}
        + createdDate (string, required) - {{transaction.createdDate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

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
