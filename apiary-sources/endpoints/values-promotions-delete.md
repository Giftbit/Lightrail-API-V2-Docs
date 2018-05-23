### Delete a Promotion [DELETE /values/promotions/{id}]

+ Request
    + Headers
    
            {{header.authorization}}

+ Parameter
    + id (string) - the ID of the Promotion to delete.

+ Response 200 (application/json)
    
    + Body

            {
                "success": true
            }

+ Response 409 (application/json)

    Attempting to delete a Promotion that has been used in a Transaction.

    + Body
    
            {
                "statusCode": 409,
                "message": "Value 'abc123' is in use.",
                "messageCode": "ValueInUse"
            }
