### Delete Value Code [DELETE /values/{valueId}/code]

Delete a Value's code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueId (string) - the valueId of the Value to delete the code of.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
