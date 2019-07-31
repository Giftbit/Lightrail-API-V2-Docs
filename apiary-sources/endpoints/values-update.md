### Update a Value [PATCH /values/{id}]

+ Parameter
    + id (string) - the ID of the Value to modify.

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + pretax (boolean, optional) - {{value.pretax}}
        + discount (boolean, optional) - {{value.discount}}
        + discountSellerLiability (number, optional) - {{value.discountSellerLiability}}
        + genericCodeOptions (GenericCodeOptions, optional) - To update requires `isGenericCode: true`. Note, property `isGenericCode` cannot be updated.
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + balanceRule (Rule, optional) - {{value.balanceRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {REQUEST_REPLACEMENT:updateValue1.body}
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {REQUEST_REPLACEMENT:updateValue1.response.body}
