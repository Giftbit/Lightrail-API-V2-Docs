### Delete a Currency [DELETE /currencies/{code}]

+ Parameter
    + code (string) - the code of the Currency to delete.

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    
    + Body

            {
                "success": true
            }

+ Response 409 (application/json)

    Attempting to delete a Currency that is in use.  If the Currency is referenced by a Value or Program those objects would need to be deleted first.  If the Currency is referenced by a Transaction it cannot be deleted because Transactions cannot be deleted.  Currencies in use can still be updated.
    
    + Attributes (RestError)

    + Body
    
            {
                "statusCode": 409,
                "message": "Currency 'USD' is in use.",
                "messageCode": "CurrencyInUse"
            }
