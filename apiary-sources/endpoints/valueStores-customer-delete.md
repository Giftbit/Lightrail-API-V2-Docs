### Delete Value Store Customer [DELETE /valueStores/{valueStoreId}/customer]

Remove the Customer as the owner of a Value Store.  The Customer's info is not deleted.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to remove the Customer from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
