### Delete Value Store Code [DELETE /valueStores/{valueStoreId}/code]

Delete a Value Store's code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to delete the code of.

+ Response 200

    + Body

            {
                "success": true
            }
