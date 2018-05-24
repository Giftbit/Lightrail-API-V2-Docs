### Get Contact's Promotions [GET /contacts/{id}/values/promotions]

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Contact whose promotions should be retrieved.

+ Response 200 (application/json)
    + Attributes (array[Value])

    + Body

            [
                {
                    "id": "promo-1",
                    "programId": "signup-bonus",
                    "currency": "USD",
                    "balance": 2500,
                    "preTax": true,
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
