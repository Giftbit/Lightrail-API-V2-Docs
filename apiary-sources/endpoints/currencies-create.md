### Create a Currency [POST /currencies]

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + code (string, required) - {{currency.code}}
        + name (string, required) - {{currency.name}}
        + symbol (number, required) - {{currency.symbol}}
        + decimalPlaces (number, required) - {{currency.decimalPlaces}}

    + Body

            {
                "code": "USD",
                "name": "Dollars",
                "symbol": "$",
                "decimalPlaces": 2
            }
    
+ Response 200 (application/json)
    + Attributes (Currency)

    + Body
            
            {
                "code": "USD",
                "name": "Dollars",
                "symbol": "$",
                "decimalPlaces": 2
            }
