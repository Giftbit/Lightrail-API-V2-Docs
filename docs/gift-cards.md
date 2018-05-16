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
    "programId": "gift-cards-usd",
    "name": "Gift Cards USD",
    "currency": "USD",
    "access": "secureCode",
    "minInitialValue": 500,
    "maxInitialValue": 100000,
    "tags": ["giftcard"]
}
``` 

#### Attributes
Below is the list of attributes used when creating an Account Program.
 - **programId** (_required_): Unique idempotent ID for the Program.
 - **name** (_optional_): A human-readable name for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **access** (_required_): Always use value `secureCode` for creating account programs. This means the gift card will be created using a unique unguessable code.
 - **active** (_optional_): Whether the Value is active and can be used upon creation.
 - **minInitialValue** (_optional_): The minimum value the Value can be created with.
 - **maxInitialValue** (_optional_): The maximum value the Value can be created with.  
 - **fixedInitialValues** (_optional_): A list of values the Value can be created with.  
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Issuing a Gift Card
Creating Gift Cards is easy. Below is the call to do this. 

`POST https://api.lightrail.com/v2/values`
```json
{
    "valueId": "gc-n6se54",
    "programId": "gift-cards-usd",
    "value": 2500
}
``` 

#### Attributes
Below is the list of attributes used when creating an Account from a Program.
- **valueId** (_required_): Unique idempotent id for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **value** (_optional_): An integer greater than or equal to 0 representing the initial value of the Account.

### Common Requests  
Below are the most common requests made when interacting with Gift Cards.

#### Retrieve Gift Code
The unique code that's generated for a Gift Card must be retrieved via the following endpoint. It is not returned with the Gift Card (`Value`) for security purposes.

`GET https://api.lightrail.com/v2/values/<valueId>/code`

Example response:

```json 
{
    "code": "ABCDEFGHIJKLM"
}
``` 

#### Using a Gift Card as a Payment Source in Checkout
Checkout is done using the `/transactions/orders` endpoint. To use a Gift Card as a payment source simply provide the following in the sources property of the request. 

```json
{
    "rail": "lightrail",
    "code": "ABCDEFGHIJKLM"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order) for full documentation of `/transactions/orders` endpoint.

### Support
Want more information on your gift card use-case? [Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
