### Assign a Promotion to a Contact [POST /values/promotions/{id}/claim]

+ Request (application/json)

    Associates a Promotion with a contact so that the value is automatically available to them in checkout. 

     + Headers
     
             {{header.authorization}}
 
     + Attributes
         + contact (string, required) - The ID of the Contact to claim the Promotion.
         
     + Body
     
             {
                 "contact": "unique-id-123"
             }

+ Parameter
    + id (string) - the ID of the Promotion to claim.

+ Response 200 (application/json)
    
    The Promotion was claimed for the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1",
                "type": "promotion",
                "program": "springpromo",
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
    
    A portion of the original Promotion was claimed and a new Promotion was created private to the Contact.

    + Attributes (Value)

    + Body

            {
                "id": "vs-1-claim-1",
                "type": "promotion",
                "program": "springpromo",
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
