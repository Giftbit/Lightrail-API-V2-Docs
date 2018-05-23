### Get a Currency [GET /currencies/{code}]

+ Request
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Currency to get.

+ Response 200 (application/json)
    + Attributes (Currency)

    + Body

            {
                "code": "USD",
                "name": "Dollars",
                "symbol": "$",
                "decimalPlaces": 2
            }

### List Currencies [GET /currencies]

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (array[Currency])

    + Body

            [
                {
                    "code": "USD",
                    "name": "Dollars",
                    "symbol": "$",
                    "decimalPlaces": 2
                }
            ]
