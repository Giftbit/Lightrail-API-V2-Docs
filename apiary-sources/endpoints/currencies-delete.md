### Delete Currency [DELETE /currencies/{code}]

Delete a Currency by code.

The Currency can only be deleted if it is not used by any Value Stores or Programs.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Currency to delete.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
