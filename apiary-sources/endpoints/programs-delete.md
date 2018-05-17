### Delete Program [DELETE /program/{programId}]

Delete a Program by programId.

The Program can only be deleted if it is not associated with any Values.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + programId (string) - the programId of the Program to delete.

+ Response 200 (application/json)

    + Body

            {
                "success": true
            }
