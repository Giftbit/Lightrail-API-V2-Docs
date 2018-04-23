### Get Programs [GET /programs{?limit}{?offset}{?currency}{?access}{?discount}{?pretax}{?active}{?minUses}{?maxUses}{?tags}{?minCreatedDate}{?maxCreatedDate}{?minUpdatedDate}{?maxUpdatedDate}]

Get multiple Value Stores.

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + offset (number, optional) - {{pagination.offset}}
    + programId (string, optional) - Filter by programId.
    + currency (string, optional) - Filter by currency.
    + access (string, optional) - Filter by access.
    + discount (string, optional) - Filter by discount.
    + pretax (string, optional) - Filter by pretax.
    + active (boolean, optional) - Filter active/inactive.
    + minUses (number, optional) - Filter by minimum uses, inclusive.
    + maxUses (number, optional) - Filter by maximum uses, inclusive.
    + tags (number, optional) - Filter by tags.
    + minCreatedDate (string, optional) - Filter by he minimum createdDate, inclusive.
    + maxCreatedDate (string, optional) - Filter by the maximum createdDate, inclusive.
    + minUpdatedDate (string, optional) - Filter by the minimum updatedDate, inclusive.
    + maxUpdatedDate (string, optional) - Filter by the maximum updatedDate, inclusive.
    
+ Response 200
    + Attributes
        + count (number, required) - {{pagination.count}}
        + limit (number, required) - {{pagination.limit}}
        + offset (number, required) - {{pagination.offset}}
        + maxLimit (number, required) - {{pagination.maxLimit}}
        + programs (array[Program], required) - the list of Programs.

    + Body

            {
                "count": 1,
                "limit": 100,
                "offset": 0,
                "maxLimit": 1000,
                "programs": [
                    {
                        "programId": "unique-id-123",
                        "name": "Giftcard programm",
                        "currency": "CAD",
                        "access": "generatedCode",
                        "discount": "false",
                        "pretax": "false",
                        "active": "true",
                        "redemptionRule": null,
                        "valueRule": null,
                        "minInitialValue": null,
                        "maxInitialValue": null,
                        "fixedInitialValues": [
                            500,
                            1500,
                            2500
                        ],
                        "uses": null,
                        "tags": [],
                        "metadata": null,
                        "createdDate": "2018-04-17T23:20:08.404Z",
                        "updatedDate": "2018-04-17T23:20:08.404Z"
                    }
                ]
            }

### Get Program [GET /programs/{programId}]

Get Program by programId

---

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Parameter
    + programId (string) - the programId of the Program to get.

+ Response 200
    + Attributes (Program)

    + Body

            {
                "programId": "unique-id-123",
                "name": "Giftcard programm",
                "currency": "CAD",
                "access": "generatedCode",
                "discount": "false",
                "pretax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": null,
                "maxInitialValue": null,
                "fixedInitialValues": [
                    500,
                    1500,
                    2500
                ],
                "uses": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
