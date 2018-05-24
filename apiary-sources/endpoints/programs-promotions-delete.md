### Delete a Promotion Program [DELETE /programs/promotions/{id}]

+ Request
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Promotion Program to delete.

+ Response 200 (application/json)
    
    + Body

            {
                "success": true
            }

+ Response 409 (application/json)

    Attempting to delete a Promotion Program that is in use. If the Program is referenced by one or more Values, those objects would need to be deleted first. If a Value created through this Program is referenced by a Transaction, it cannot be deleted because Transactions cannot be deleted. Programs in use can still be updated. 

    + Body
    
            {
                "statusCode": 409,
                "message": "Program 'abc123' is in use.",
                "messageCode": "ProgramInUse"
            }
