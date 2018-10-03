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

            {REQUEST_REPLACEMENT:attachValue1.body}
    
+ Response 200 (application/json)
    
    If the Value has a unique code (or no code) it will be attached to the Contact by setting the `contactId` on the Value.
    
    If the Value has a generic code it will be copied. The new Value will have an `id` that is a hash of the original Value `id` and the Contact `id`.  The original Value will have `usesRemaining` decremented by 1 if `usesRemaining` is not null.
    
    + Attributes (Value)

    + Body
            
            {REQUEST_REPLACEMENT:attachValue1.response.body}

+ Response 409 (application/json)
    
    A Value with `isGenericCode=true` true and `usesRemaining=0` cannot be attached to any more Contacts.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value with id '123abc' cannot be attached because it has a generic code and has 0 usesRemaining."
                "messageCode": "InsufficientUses"
            }

+ Response 409 (application/json)
    
    A Value that is frozen cannot be attached.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value cannot be attached because it is frozen."
                "messageCode": "ValueFrozen"
            }

+ Response 409 (application/json)
    
    A Value that is canceled cannot be attached.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value cannot be attached because it is canceled."
                "messageCode": "ValueCanceled"
            }
