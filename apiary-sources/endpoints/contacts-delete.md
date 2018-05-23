### Delete a Contact [DELETE /contacts/{id}]

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

+ Response 409 (application/json)

    Attempting to delete a Contact that is associated with one or more Values. Values that are associated with the Contact would need to be deleted first. 

    + Body

            {
                "statusCode": 409,
                "message": "Contact 'unique-id-123' is in use",
                "messageCode": "ContactInUse"
            }
