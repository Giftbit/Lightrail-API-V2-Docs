### Update a Currency [PATCH /currencies/{code}]

+ Parameter
    + code (string) - the code of the Currency to modify.

+ Request (application/json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + code (string, optional) - {{currency.code}} If present must match the code in the path.
        + name (string, optional) - {{currency.name}}
        + symbol (string, optional) - {{currency.symbol}}
        + decimalPlaces (number, optional) - {{currency.decimalPlaces}}
        
    + Body
    
            {
                "name": "Zimbabwe Dollars",
                "symbol": "Z$"
            }
    
+ Response 200 (application/json)
    + Attributes (Currency)

    + Body
    
            {
                "code": "ZWD",
                "name": "Zimbabwe Dollars",
                "symbol": "Z$",
                "decimalPlaces": 2
            }
