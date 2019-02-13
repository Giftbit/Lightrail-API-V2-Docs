### Detach a Value from a Contact [POST /contacts/{id}/values/detach]
      
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