### Delete Contact [DELETE /contacts/{contactId}]

Delete a Contact by contactId.

The Contact can only be deleted if it is not associated with any Value Stores.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + contactId (string) - the contactId of the Contact to delete.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
