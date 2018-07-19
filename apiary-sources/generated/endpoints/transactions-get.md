### Get a Transaction [GET /transactions/{id}]

+ Parameter
    + id (string) - the ID of the Transaction to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Transaction)

    + Body

            {"id":"debit1-_rn1","transactionType":"debit","currency":"USD","totals":{"remainder":0},"lineItems":null,"steps":[{"rail":"lightrail","valueId":"value2-_rn1","contactId":null,"code":null,"balanceBefore":3000,"balanceAfter":2000,"balanceChange":-1000}],"paymentSources":null,"metadata":{"note":"Reduce loyalty points after 3mo contact inactivity"},"createdDate":"2018-07-18T21:45:38.000Z"}

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

            [{"id":"value1-_rn1","transactionType":"credit","currency":"USD","totals":null,"lineItems":null,"paymentSources":null,"steps":[{"rail":"lightrail","valueId":"value1-_rn1","contactId":null,"code":null,"balanceBefore":0,"balanceAfter":500,"balanceChange":500}],"metadata":null,"createdDate":"2018-07-18T21:45:37.000Z"},{"id":"credit1-_rn1","transactionType":"credit","currency":"USD","totals":{"remainder":0},"lineItems":null,"paymentSources":null,"steps":[{"rail":"lightrail","valueId":"value2-_rn1","contactId":null,"code":null,"balanceBefore":500,"balanceAfter":3000,"balanceChange":2500}],"metadata":{"note":"Frequent buyer bonus"},"createdDate":"2018-07-18T21:45:38.000Z"},{"id":"debit1-_rn1","transactionType":"debit","currency":"USD","totals":{"remainder":0},"lineItems":null,"paymentSources":null,"steps":[{"rail":"lightrail","valueId":"value2-_rn1","contactId":null,"code":null,"balanceBefore":3000,"balanceAfter":2000,"balanceChange":-1000}],"metadata":{"note":"Reduce loyalty points after 3mo contact inactivity"},"createdDate":"2018-07-18T21:45:38.000Z"},{"id":"value2-_rn1","transactionType":"credit","currency":"USD","totals":null,"lineItems":null,"paymentSources":null,"steps":[{"rail":"lightrail","valueId":"value2-_rn1","contactId":null,"code":null,"balanceBefore":0,"balanceAfter":500,"balanceChange":500}],"metadata":null,"createdDate":"2018-07-18T21:45:38.000Z"}]
