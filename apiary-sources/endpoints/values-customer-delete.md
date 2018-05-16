### Delete Value Customer [DELETE /values/{id}/customer]

Remove the Customer as the owner of a Value.  The Customer's info is not deleted.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the id of the Value to remove the Customer from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
