### Claim a Value for a Contact by code [POST /values/code/{code}/claim]

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
    + Attributes
        + contact (Contact, required) The Contact that claimed the Giftcard.
        + value (Value, required) The Value that was claimed.  If the original Value could be claimed by multiple Contacts this could be a new Value object unique to the Contact. 

    + Body

            {
                "contact": {
                    "id": "unique-id-123",
                    "firstName": "Jeffrey",
                    "lastName": "Lebowski",
                    "email": "thedude@example.com",
                    "tags": [],
                    "metadata": {
                        "alias": "El Duderino"
                    },
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                },
                "value": {
                    "id": "vs-1-claim-1",
                    "type": "giftcard",
                    "program": "giftcards",
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
                    "tags": [],
                    "metadata": null,
                    "createdDate": "2018-04-17T23:20:08.404Z",
                    "updatedDate": "2018-04-17T23:20:08.404Z"
                }
            }
