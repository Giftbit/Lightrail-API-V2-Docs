### Debit [POST /transactions/debit]

Debit (remove an amount from) a Lightrail payment source.  Debiting is simpler and less powerful than checkout.  It does not apply the promotion logic of `balanceRules`, calculate discount or taxes.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + source (LightrailTransactionParty, required) - The rail to debit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to debit.  Must be > 0 if specified.  One of `amount` or `uses` must be specified.
        + uses (number, optional) - The number of `usesRemaining` to add.  Defaults to 0.  Must be > 0 if specified.  One of `amount` or `uses` must be specified.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pendingRequest}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:debitTransaction1.body}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:debitTransaction1.response.body}

+ Response 409 (application/json)

    You cannot debit a Value by more balance than is available (if `allowRemainder` is not `true`).

    + Attributes (RestError)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
