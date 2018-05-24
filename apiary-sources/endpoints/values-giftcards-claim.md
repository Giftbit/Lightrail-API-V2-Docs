### Assign a Gift Card to a Contact [POST /values/giftCards/{id}/claim]

+ Request (application/json)
    Associates a Gift Card with a contact so that the value is automatically available to them in checkout.

     + Headers
     
             {{header.authorization}}
 
     + Attributes
         + contact (string, required) - The ID of the Contact to claim the Gift Card.
         
     + Body
     
             {
                 "contact": "unique-id-123"
             }

+ Parameter
    + id (string) - the ID of the Gift Card to claim.

+ Response 200 (application/json)

    The Gift Card was claimed for the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1-claim-1",
                "type": "giftCard",
                "program": "giftCards",
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
