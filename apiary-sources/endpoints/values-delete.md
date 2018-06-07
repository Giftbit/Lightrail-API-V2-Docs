### Delete a Value [DELETE /values/{id}]

+ Parameter
    + id (string) - the ID of the Value to delete.

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    
    + Body

            {
                "success": true
            }

+ Response 409 (application/json)

    Attempting to delete a Value that has been used in a Transaction.

    + Body
    
            {
                "statusCode": 409,
                "message": "Value 'abc123' is in use.",
                "messageCode": "ValueInUse"
            }
