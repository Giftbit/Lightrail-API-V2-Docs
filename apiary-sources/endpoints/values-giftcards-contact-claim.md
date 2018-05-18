### Claim a Giftcard for a Contact [POST /values/giftcards/{id}/claim]

+ Request (application/json)
     + Headers
     
             {{header.authorization}}
 
     + Attributes
         + contact (string, required) - The ID of the Contact to claim the Giftcard.
         
     + Body
     
             {
                 "contact": "unique-id-123"
             }

+ Parameter
    + id (string) - the id of the Giftcard to claim.

+ Response 200 (application/json)
    + Attributes
        + contact (Contact, required) The Contact that claimed the Giftcard.
        + value (Value, required) The Giftcard that was claimed.

    + Body

            {
                "contact": {
                   "id": "unique-id-123",
                   "firstName": "Jeffrey",
                   "lastName": "Lebowski",
                   "email": "thedude@example.com",
                   "metadata": {
                       "alias": "El Duderino"
                   },
                   "createdDate": "2018-04-17T23:20:08.404Z",
                   "updatedDate": "2018-04-17T23:20:08.404Z"
               },
               "value": {
                    "id": "vs-1-claim-1",
                    "type": "giftcard",
                    "programId": "giftcards",
                    "currency": "USD",
                    "balance": 2500,
                    "active": true,
                    "frozen": false,
                    "canceled": false,
                    "preTax": false,
                    "redemptionRule": null,
                    "valueRule": null,
                    "uses": null,
                    "startDate": null,
                    "endDate": null,
                    "metadata": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            }
