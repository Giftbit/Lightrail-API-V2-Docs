### Get Value Store Code [GET /valueStores/{valueStoreId}/code]

Get a Value Store's code.

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + valueStoreId (string) - the valueStoreId of the Value Store to get the code of.

+ Response 200 (application/json)
    + Attributes
        + code (string, optional) - {{valueStore.code}}

    + Body

            {
                "code": "BLACKFRIDAY20%"
            }
