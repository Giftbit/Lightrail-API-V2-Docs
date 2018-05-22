### Get Contact's Gift Cards [GET /contacts/{id}/values/giftcards]

+ Request (application/json)
  + Headers

            {{header.authorization}}

+ Parameter
  + id (string) - the ID of the Contact whose gift cards should be retrieved.

+ Response 200 (application/json)
  + Attributes (array[Value])

  + Body

            [
              {
                  "id": "gift-1",
                  "program": "giftcards",
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