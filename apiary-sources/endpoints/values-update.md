### Update a Value [PATCH /values/{id}]

+ Parameter
    + id (string) - the ID of the Value to modify.

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + pretax (boolean, optional) - {{value.pretax}}
        + discount (boolean, optional) - {{value.discount}}
        + discountSellerLiability (number, optional) - {{value.discountSellerLiability}}
        + genericCodeOptions (GenericCodeOptions, optional)
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + balanceRule (Rule, optional) - {{value.balanceRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {REQUEST_REPLACEMENT:updateValue1.body}
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {REQUEST_REPLACEMENT:updateValue1.response.body}
