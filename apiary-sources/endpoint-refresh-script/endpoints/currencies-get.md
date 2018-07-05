### Get a Currency [GET /currencies/{code}]

+ Parameter
    + code (string) - the code of the Currency to get.

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Currency)

    + Body

            {REQUEST_REPLACEMENT:createCurrency1.response.body}

### List Currencies [GET /currencies]

+ Request
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (array[Currency])

    + Body

            {REQUEST_REPLACEMENT:listCurrencies1.response.body}
