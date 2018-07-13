### Get a Currency [GET /currencies/{code}]

+ Parameter
    + code (string) - the code of the Currency to get.

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Currency)

    + Body

            {"code":"USD_run14","name":"US Dollars","symbol":"$","decimalPlaces":2}

### List Currencies [GET /currencies]

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (array[Currency])

    + Body

            [{"code":"CAD","name":"Beaver pelts","symbol":"$","decimalPlaces":2},{"code":"USD","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run1","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run10","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run13","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run14","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run2","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run3","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run4","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run5","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run6","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run7","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run8","name":"US Dollars","symbol":"$","decimalPlaces":2},{"code":"USD_run9","name":"US Dollars","symbol":"$","decimalPlaces":2}]
