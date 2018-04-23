### Get Currencies [GET /currencies]

Get all the Currencies.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200
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

### Get Currency [GET /currencies/{code}]

Get Currency by code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + code (string) - the code of the Currency to get.

+ Response 200
    + Attributes (Program)

    + Body

            {
                "code": "USD",
                "name": "Dollars",
                "symbol": "$",
                "decimalPlaces": 2
            }
