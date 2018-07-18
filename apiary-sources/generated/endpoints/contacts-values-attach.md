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

            {"valueId":"value1-_rn1"}
    
+ Response 200 (application/json)
    
    If the Value has a unique code (or no code) it will be attached to the Contact by setting the `contactId` on the Value.
    
    If the Value has a generic code it will be copied. The new Value will have an `id` that is a hash of the original Value `id` and the Contact `id`.  The original Value will have `uses` decremented by 1 if `uses` is not null.
    
    + Attributes (Value)

    + Body
            
            {"id":"value1-_rn1","currency":"USD","balance":500,"uses":null,"programId":"spring-promotion-usd_rn1","contactId":"id_JeffreyLebowski_rn1","code":null,"isGenericCode":null,"pretax":true,"active":true,"canceled":false,"frozen":false,"discount":true,"discountSellerLiability":null,"redemptionRule":null,"valueRule":null,"startDate":null,"endDate":null,"metadata":null,"createdDate":"2018-07-18T21:45:37.000Z","updatedDate":"2018-07-18T21:45:37.000Z"}

+ Response 409 (application/json)
    
    A Value with `isGenericCode=true` true and `uses=0` cannot be attached to any more Contacts.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value with id '123abc' cannot be attached because it has a generic code and has 0 uses remaining."
                "messageCode": "InsufficientUses"
            }
