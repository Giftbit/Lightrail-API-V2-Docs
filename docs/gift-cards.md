# Gift Cards
Allow your customers to purchase gift cards from your store and redeem them directly as part of the checkout process.   

Like all other Lightrail value, gift cards are backed by `Values`. You’ll need to set up a Gift Card program to establish the default parameters for your gift cards.

### Getting Started with Gift Cards
To get started with gift cards, you first need to create a `Program` which defines the default parameters for your gift cards.

#### Creating a Program
The Program will define the basic properties like currency and allowed value ranges for your gift cards (`Values`). 
Below are the required and optional attributes needed for creating a Program for gift cards.   

How to create a Gift Card Program through the API. Note, typically Programs are created through the app (coming soon!). 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "id": "gift-cards-usd",
    "name": "Gift Cards USD",
    "currency": "USD",
    "minInitialBalance": 500,
    "maxInitialBalance": 100000,
    "discount": false,
    "pretax": false,
    "tags": ["giftCard"]
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating a Gift Card Program. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
 - **id** (_required_): Unique idempotent ID for the Program.
 - **name** (_optional_): A human-readable name for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **active** (_optional_): Whether Values in this Program are active and can be used upon creation.
 - **minInitialBalance** (_optional_): The minimum balance the Values in this Program can be created with.
 - **maxInitialBalance** (_optional_): The maximum balance the Values in this Program can be created with.  
 - **fixedInitialBalances** (_optional_): A list of exact balances the Values in this Program can be created with. Not set in combination with `minInitialBalance` and `maxInitialBalance`.
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer (default: `true`). Use `false` for Gift Card Programs.
 - **pretax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `true`). Use `false` for Gift Card Programs.
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Issuing a Gift Card
`POST https://api.lightrail.com/v2/values`
```json
{
    "id": "gc-n6se54",
    "programId": "gift-cards-usd",
    "balance": 2500
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating a Gift Card from a Program. For full attribute details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
- **id** (_required_): Unique idempotent ID for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **balance** (_optional_): An integer greater than or equal to 0 representing the initial balance of the Gift Card.
- **code** (_optional_): Can by used by the customer to use the Gift Card as a payment source. 
- **generateCode** (_optional_): Parameters to generate a secure code. To use the default length and character set, simply set to an empty object: `{}`. See the [reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value) for usage details.

### Common Requests  
Below are the most common requests made when interacting with Gift Cards.

#### Retrieve Gift Code
The unique code that's generated for a Gift Card can be retrieved via the following endpoint. By default it is not returned with the Gift Card (`Value`) for security purposes.

`GET https://api.lightrail.com/v2/values/<id>?showCode=true`

The response will be the same as the response returned for creating a Value, but with the full code displayed instead of only the last four characters:

```json 
{
  "id": "gc-n6se54",
  "currency": "USD",
  "balance": 2500,
  "uses": null,
  "programId": "gift-cards-usd",
  "issuanceId": null,
  "contactId": null,
  "code": "ABCDEF123456",
  "isGenericCode": false,
  "pretax": false,
  "active": true,
  "canceled": false,
  "frozen": false,
  "discount": false,
  "discountSellerLiability": null,
  "redemptionRule": null,
  "valueRule": null,
  "startDate": null,
  "endDate": null,
  "metadata": null,
  "createdDate": "2018-08-02T21:12:24.000Z",
  "updatedDate": "2018-08-02T21:12:24.000Z"
}
```

#### Using a Gift Card as a Payment Source in Checkout
Checkout uses the `/transactions/checkout` endpoint. To use a Gift Card as a payment source simply provide the following in the sources property of the request. 

```json
{
    "rail": "lightrail",
    "code": "ABCDEFGHIJKLM"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for full documentation of the `/transactions/checkout` endpoint.

### Support
Want more information on your gift card use-case? [Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
