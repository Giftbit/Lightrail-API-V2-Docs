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

            {"id":"39127a88-975b-4e11-b","destination":{"rail":"lightrail","valueId":"4b6cb6f1-21d4-41f3-a"},"amount":2500,"currency":"USD","metadata":{"note":"Frequent buyer bonus"}}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {"id":"39127a88-975b-4e11-b","transactionType":"credit","currency":"USD","createdDate":"2018-07-24T18:49:50.000Z","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"4b6cb6f1-21d4-41f3-a","contactId":null,"code":null,"balanceBefore":500,"balanceAfter":3000,"balanceChange":2500}],"paymentSources":null,"metadata":{"note":"Frequent buyer bonus"}}

