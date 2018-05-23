### Get Contact's Accounts [GET /contacts/{id}/values/accounts]

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Contact whose accounts should be retrieved.

+ Response 200 (application/json)
    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "acc-1",
                    "program": null,
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