### Get a Transaction [GET /transactions/{id}]

+ Parameter
    + id (string) - the ID of the Transaction to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {"id":"2c44612d-e90d-4e0e-8","transactionType":"debit","currency":"USD","createdDate":"2018-07-24T18:49:50.000Z","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"4b6cb6f1-21d4-41f3-a","contactId":null,"code":null,"balanceBefore":3000,"balanceAfter":2000,"balanceChange":-1000}],"paymentSources":null,"metadata":{"note":"Reduce loyalty points after 3mo contact inactivity"}}

### List Transactions [GET /transactions{?limit}{?transactionType}{?createdDate}{?maxCreatedDate}]

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + transactionType (string, optional) - {{filter.transactionType}}
    + createdDate (string, optional) - {{filter.createdDate}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"
        
    + Attributes (array[Transaction])

    + Body

            [{"id":"5cb3e2d0-b702-4ea6-a","transactionType":"credit","currency":"USD","totals":null,"lineItems":null,"paymentSources":null,"steps":[{"rail":"lightrail","valueId":"5cb3e2d0-b702-4ea6-a","contactId":null,"code":null,"balanceBefore":0,"balanceAfter":500,"balanceChange":500}],"metadata":null,"createdDate":"2018-07-24T18:45:15.000Z"}]
