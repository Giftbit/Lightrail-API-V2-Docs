### Delete Customer [DELETE /customers/{customerId}]

Delete a Customer by customerId.

The Customer can only be deleted if it is not associated with any Values.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + customerId (string) - the customerId of the Customer to delete.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
