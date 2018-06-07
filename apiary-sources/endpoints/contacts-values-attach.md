### Attach a Contact to a Value [POST /contacts/{id}/values/attach]

+ Parameter
    + id (string) - the ID of the Contact to attach Value to.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + valueId (string, optional) - The `id` of the Value to attach to the Contact.  One of `valueId` or `code` must be specified.
        + code (string, optional) - The `code` of the Value to attach to the Contact.  One of `valueId` or `code` must be specified.

    + Body

            {
                "code": "920cb077a0f1a7db"
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
            
            {
                "id": "giftcard-456",
                "programId": "giftcards",
                "currency": "USD",
                "contactId": "unique-id-123",
                "balance": 2500,
                "uses": null,
                "discount": false,
                "active": true,
                "frozen": false,
                "canceled": false,
                "preTax": false,
                "redemptionRule": null,
                "valueRule": null,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-05-06T13:02:12.000Z"
            }
