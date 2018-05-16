### Delete Contact [DELETE /contacts/{id}]

Delete a Contact by ID.

The Contact can only be deleted if it is not associated with any Value Stores.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Contact to delete.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
