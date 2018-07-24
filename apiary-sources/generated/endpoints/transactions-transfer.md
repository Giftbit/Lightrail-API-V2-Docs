### Transfer [POST /transactions/transfer]

Transfer value between a payment source and a payment destination.  Currently only the `lightrail` rail is supported.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + source (TransactionParty, required) - {{transaction.source}}
        + destination (TransactionParty, required) - {{transaction.destination}}
        + amount (number, required) - The amount to transfer, > 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {"id":"ace3d88f-ded7-4d60-8","source":{"rail":"lightrail","valueId":"af6b521b-7601-4ecc-a"},"destination":{"rail":"lightrail","valueId":"f10ed612-faa5-4b92-8"},"amount":100,"currency":"USD","metadata":{"reference":"customer request to move funds. ref: #4948173593"}}

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

            {"id":"ace3d88f-ded7-4d60-8","transactionType":"transfer","currency":"USD","createdDate":"2018-07-24T18:49:51.000Z","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"af6b521b-7601-4ecc-a","contactId":null,"code":null,"balanceBefore":500,"balanceAfter":400,"balanceChange":-100},{"rail":"lightrail","valueId":"f10ed612-faa5-4b92-8","contactId":null,"code":null,"balanceBefore":500,"balanceAfter":600,"balanceChange":100}],"paymentSources":null,"metadata":{"reference":"customer request to move funds. ref: #4948173593"}}

+ Response 409 (application/json)

    You cannot transfer from a Value more balance than is available (if `allowRemainder` is not `true`).

    + Attributes (Transaction)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
