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

            {REQUEST_REPLACEMENT:createCurrency1.body}
    
+ Response 201 (application/json)
    + Attributes (Currency)

    + Body
            
            {REQUEST_REPLACEMENT:createCurrency1.response.body}
