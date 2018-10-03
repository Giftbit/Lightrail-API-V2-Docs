### Credit [POST /transactions/credit]

Credit (add an amount to) a Lightrail payment destination.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + destination (LightrailTransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to credit, > 0.
        + usesRemaining (number, optional) - The number of usesRemaining to add.  Defaults to 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {REQUEST_REPLACEMENT:creditTransaction1.body}
    
+ Response 201 (application/json)

    + Attributes (RestError)

    + Body

            {REQUEST_REPLACEMENT:creditTransaction1.response.body}

