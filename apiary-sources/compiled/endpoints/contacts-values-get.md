### List a Contact's Values [GET /contacts/{id}/values{?limit}{?programId}{?currency}{?balance}{?uses}{?discount}{?active}{?frozen}{?canceled}{?preTax}{?startDate}{?endDate}{?createdDate}{?updatedDate}{?tags}]

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + programId (string, optional) - {{filter.programId}}  {{filter.ops.in}}
    + currency (string, optional) - {{filter.currency}}  {{filter.ops.in}}
    + balance (number, optional) - {{filter.balance}}  {{filter.ops.number}}
    + uses (number, optional) - {{filter.uses}}  {{filter.ops.number}}
    + discount (boolean, optional) - {{filter.discount}}
    + active (boolean, optional) - {{filter.active}}
    + frozen (boolean, optional) - {{filter.frozen}}
    + canceled (boolean, optional) - {{filter.canceled}}
    + preTax (boolean, optional) - {{filter.preTax}}
    + startDate (string, optional) - {{filter.startDate}}  {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}}  {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}}  {{filter.ops.date}}
    + tags (string, optional) - {{filter.tags}}  {{filter.ops.in}}

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Response 200 (application/json)
    + Headers

            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"

    + Attributes (array[Value])

    + Body

            [{"id":"value1-_rn1","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_rn1","contactId":"id_JeffreyLebowski_rn1","code":null,"isGenericCode":null,"pretax":true,"active":true,"canceled":false,"frozen":false,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-16T23:16:12.000Z","updatedDate":"2018-07-16T23:16:12.000Z"}]
