### Credit [POST /transactions/credit]

Credit (add an amount to) a Lightrail payment destination.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + destination (LightrailTransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific Value are supported.
        + currency (string, required) - {{currency.code}}
        + amount (number, optional) - The amount to credit.  Must be > 0 if specified.  One of `amount` or `uses` must be specified.
        + uses (number, optional) - The number of `usesRemaining` to add.  Defaults to 0.  Must be > 0 if specified.  One of `amount` or `uses` must be specified.
        + simulate (boolean, optional) - {{transaction.simulate}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:creditTransaction1.body}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {REQUEST_REPLACEMENT:creditTransaction1.response.body}
