### Update a Value [PATCH /values/{id}]

+ Parameter
    + id (string) - the ID of the Value to modify.

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + contactId (string, optional) - {{value.create.contactId}}
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + canceled (boolean, optional) - {{value.canceled}}
        + preTax (boolean, optional) - {{value.preTax}}
        + discount (boolean, optional) - {{value.discount}}
        + discountSellerLiability (number, optional) - {{value.discountSellerLiability}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "frozen": true
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "vs-1",
                "programId": "springpromo",
                "currency": "USD",
                "balance": 2500, 
                "active": true,
                "frozen": true,
                "canceled": false,
                "preTax": false,
                "discount": false,
                "discountSellerLiability": null,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
            }
