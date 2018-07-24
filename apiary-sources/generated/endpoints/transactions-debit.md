### Debit [POST /transactions/debit]

Debit (remove from) a payment source.  Currently only the `lightrail` rail is supported.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + source (TransactionParty, required) - The rail to debit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to debit, > 0.
        + uses (number, optional) - The number of uses to remove.  Defaults to 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {"id":"2c44612d-e90d-4e0e-8","source":{"rail":"lightrail","valueId":"4b6cb6f1-21d4-41f3-a"},"amount":1000,"currency":"USD","metadata":{"note":"Reduce loyalty points after 3mo contact inactivity"}}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {"id":"2c44612d-e90d-4e0e-8","transactionType":"debit","currency":"USD","createdDate":"2018-07-24T18:49:50.000Z","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"4b6cb6f1-21d4-41f3-a","contactId":null,"code":null,"balanceBefore":3000,"balanceAfter":2000,"balanceChange":-1000}],"paymentSources":null,"metadata":{"note":"Reduce loyalty points after 3mo contact inactivity"}}

+ Response 409 (application/json)

    You cannot debit a Value by more balance than is available (if `allowRemainder` is not `true`).

    + Attributes (Transaction)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
