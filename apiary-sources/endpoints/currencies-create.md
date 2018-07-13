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

            {"code":"USD_run14","name":"US Dollars","symbol":"$","decimalPlaces":2}
    
+ Response 201 (application/json)
    + Attributes (Currency)

    + Body
            
            {"code":"USD_run14","name":"US Dollars","symbol":"$","decimalPlaces":2}
