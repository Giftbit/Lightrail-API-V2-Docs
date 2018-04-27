# Gift Cards

## Creating a Gift Card Program

*[POST /programs]*

Create a new Gift Card Program.

---
+ Request (application/json)
    + Headers
    
            Authorization: Bearer <API_KEY>
        
    + Attributes
        + programId (string, required) - Unique idempotent ID for the Program.
        + name (string, optional) - 
        + currency (string, required) - Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
        + access (enum[string], required) - How the valueStores can be accessed
            + `secureCode` - a code is generated or supplied and is stored securely.
        + active (boolean, optional) - Whether the ValueStore is active and can be used upon creation.
        + minInitialValue (number, optional) - The minimum value the Value Store can be created with.
        + maxInitialValue (number, optional) - The maximum value the Value Store can be created with.
        + fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
        + tags (array[string], optional) - Segmentation tags.
        + metadata (number, optional) - Arbitrary data associated with the Program.

    + Body

            {
                "programId": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                minInitialValue: 500,
                maxInitialValue: 100000,
                "tags": ["giftcard"]
            }
    
+ Response 200
    + Attributes (Customer)

    + Body
            
            {
                "programId": "gift-cards-usd",
                "name": "Gift Cards USD",
                "currency": "USD",
                "access": "secureCode",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": 500,
                "maxInitialValue": 100000,
                "fixedInitialValues": null,
                "uses": null,
                "tags": ["giftcard"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }

## Issuing Gift Cards

*Create a Value Store from a Gift Card Program [POST /valueStores]*

+ Request (application/json)
    + Headers
    
            Authorization: Bearer <API_KEY>

    + Attributes
        + valueStoreId (string, required) - Unique idempotent id for the ValueStore.
        + programId (string, required) - Associate with and copy default values from the given Program.
        + value (number, required) - An integer greater than or equal to 0 representing the smallest units of the currency. For example, $25 USD = 2500.
        + startDate (number, optional) - ISO date for when the valueStore can start to be transacted with.
        + endDate (number, optional) - ISO date for when the valueStore can last be transacted with.
        + metadata (number, optional) - Arbitrary data associated with the Value Store.
        
    + Body
    
            {
                "valueStoreId": "vs-1",
                "programId": "gift-cards-usd",
                "value": 2500
            }
    
+ Response 200
    + Attributes (ValueStore)

    + Body
    
            {
                "valueStoreId": "vs-1",
                "programId": "gift-cards-usd",
                "currency": "USD",
                "value": 2500, 
                "discount": false, 
                "preTax": false,
                "active": true,
                "frozen": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }

## Transactions



