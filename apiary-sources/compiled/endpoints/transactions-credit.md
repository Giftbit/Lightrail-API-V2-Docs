### Credit [POST /transactions/credit]

Credit (add to) a payment destination.  Currently only the `lightrail` rail is supported.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + destination (TransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to credit, > 0.
        + uses (number, optional) - The number of uses to add.  Defaults to 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {"id":"credit1-_rn1","destination":{"rail":"lightrail","valueId":"value2-_rn1"},"amount":2500,"currency":"USD","metadata":{"note":"Frequent buyer bonus"}}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {"id":"credit1-_rn1","transactionType":"credit","currency":"USD","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"value2-_rn1","contactId":null,"code":null,"balanceBefore":500,"balanceAfter":3000,"balanceChange":2500}],"paymentSources":null,"metadata":{"note":"Frequent buyer bonus"},"createdDate":"2018-07-16T23:16:13.000Z"}

