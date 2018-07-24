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
    
            {"frozen":true}
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {"id":"c4a10df5-4e31-4fa0-b","currency":"USD","balance":500,"uses":null,"programId":"e46823bb-6fd5-40bf-9","contactId":"e7db2103-806e-4887-b","code":null,"isGenericCode":null,"pretax":true,"active":true,"canceled":false,"frozen":true,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-24T18:49:49.000Z","updatedDate":"2018-07-24T18:49:50.000Z"}
