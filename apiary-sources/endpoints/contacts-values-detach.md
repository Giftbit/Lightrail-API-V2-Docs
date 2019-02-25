### Detach a Contact from a Value [POST /contacts/{id}/values/detach]
      
+ Parameter
    + id (string) - the ID of the Contact to detach the Value from.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + valueId (string, required) - The `id` of the Value to detach from the Contact. 

    + Body

            {REQUEST_REPLACEMENT:detachValue1.body}
    
+ Response 200 (application/json)
    
    + Attributes (Value)

    + Body
            
            {REQUEST_REPLACEMENT:detachValue1.response.body}

+ Response 409 (application/json)
    
    A Value that is not attached cannot be detached.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value X is not Attached to the Contact Y."
                "messageCode": "AttachedValueNotFound"
            }

+ Response 409 (application/json)
    
    A Value that is frozen cannot be detached.
    
    + Attributes (RestError)
    
    + Body
    
            {
                "statusCode": 409,
                "message": "The Value cannot be detached because it is frozen."
                "messageCode": "ValueFrozen"
            }
