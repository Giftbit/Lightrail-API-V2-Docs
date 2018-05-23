### List Contact's Values [GET /contacts/{id}/values{?limit}{?offset}{?program}{?currency}{?preTax}{?active}{?frozen}{?uses}{?startDate}{?endDate}{?createdDate}{?updatedDate}{?tags}]

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + program (string, optional) - Filter by the Value's Program ID.
    + currency (string, optional) - Filter by the Value's currency.
    + preTax (boolean, optional) - Filter by whether or not the Value is applied preTax.
    + active (boolean, optional) - Filter by whether or not the Value is active.
    + frozen (boolean, optional) - Filter by whether or not the Value is frozen.
    + uses (number, optional) - Filter by whether or not the Value is uses.
    + startDate (string, optional) - Filter by the Value's startDate.
    + endDate (string, optional) - Filter by the Value's endDate.
    + createdDate (string, optional) - Filter by the Value's createdDate.
    + updatedDate (string, optional) - Filter by the Value's updatedDate.

+ Response 200 (application/json)
    + Headers

            Limit: 100
            MaxLimit: 1000
            Offset: 0
            Count: 1

    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "vs-1",
                    "program": "giftCards",
                    "currency": "USD",
                    "balance": 2500,
                    "preTax": false,
                    "active": true,
                    "frozen": false,
                    "redemptionRule": null,
                    "valueRule": null,
                    "uses": null,
                    "startDate": null,
                    "endDate": null,
                    "metadata": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            ]
