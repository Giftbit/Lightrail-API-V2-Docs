### Claim a Value for a Contact by code [POST /values/byCode/{code}/claim]

+ Request (application/json)
     + Headers
     
             {{header.authorization}}
 
     + Attributes
         + contact (string, required) - The ID of the Contact to claim the Value.
         
     + Body
     
             {
                 "contact": "unique-id-123"
             }

+ Parameter
    + code (string) - the code of the Value to claim.

+ Response 200 (application/json)
    
    The Value was claimed for the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1",
                "type": "giftcard",
                "program": "giftcards",
                "currency": "USD",
                "contact": "unique-id-123",
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
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }

+ Response 201 (application/json)
    
    A portion of the original Value was claimed and a new Value was created private to the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1-claim-1",
                "type": "giftcard",
                "program": "giftcards",
                "currency": "USD",
                "contact": "unique-id-123",
                "balance": 2500,
                "active": true,
                "frozen": false,
                "canceled": false,
                "preTax": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": 1,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
