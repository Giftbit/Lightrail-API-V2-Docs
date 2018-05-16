### Delete Value Store Contact [DELETE /valueStores/{valueStoreId}/contact]

Remove the Contact as the owner of a Value Store.  The Contact's info is not deleted.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to remove the Contact from.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
