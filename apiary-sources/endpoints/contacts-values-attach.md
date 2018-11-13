### Attach a Contact to a Value [POST /contacts/{id}/values/attach]

Attaching a Contact to a Value sets the Value's `contactId` to that Contact's ID.  The Contact "has" that Value.  In a checkout Transaction specifying the same `contactId` will have all applicable Values for the Contact applied to the Transaction. 

Note, attaching a generic Value is currently deprecated as we're in the process of updating this functionality. Please [let us know](mailto:hello@lightrail.com) for more information on the changes. 

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
