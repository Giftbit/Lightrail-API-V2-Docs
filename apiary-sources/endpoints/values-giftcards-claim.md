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
    + id (string) - the ID of the Giftcard to claim.

+ Response 200 (application/json)

    The Giftcard was claimed for the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1-claim-1",
                "type": "giftcard",
                "program": "giftcards",
                "contact": "unique-id-123",
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
