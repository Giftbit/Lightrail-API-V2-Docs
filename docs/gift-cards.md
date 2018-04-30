# Gift Cards
Allow your customers to purchase Gift Cards from your store and redeem them directly as part of the checkout process.   

Like all other Lightrail value, Gift Cards are backed by `ValueStores`. You’ll need to set up a Gift Card program to establish the default parameters for your gift cards.

## Getting Started with Gift Cards
To get started with Gift Cards, you first need to create a Program which defines common properties of your Gift Cards.

### Creating a Program
The Program will define the basic properties like currency and tags for the Gift Cards (`ValueStores`) that will be created from it. 
Below are the required and optional attributes needed for creating an A Gift Card Program.   

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

### Attributes
Below is the list of attributes used when creating an Account Program.
 - **programId** (_required_): Unique idempotent ID for the Program.
 - **name** (_optional_): A human-readable name for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **access** (_required_): Always use value `customerId` for creating account programs. This means the ValueStores must be attached to a Customer.
 - **active** (_optional_): Whether the ValueStore is active and can be used upon creation.
 - **minInitialValue** (_optional_): The minimum value the Value Store can be created with.
 - **maxInitialValue** (_optional_): The maximum value the Value Store can be created with.  
 - **fixedInitialValues** (_optional_): A list of values the Value Store can be created with.  
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

## Creating a Gift Card
Creating Gift Cards is easy. Below is the call to do this. 

`POST https://api.lightrail.com/v2/valueStores`
```json
{
    "valueStoreId": "gc-n6se54",
    "programId": "gift-cards-usd",
    "value": 2500
}
``` 

### Attributes
Below is the list of attributes used when creating an Account from a Program.
- **valueStoreId** (_required_): Unique idempotent id for the ValueStore.
- **programId** (_required_): The programId of the Program this ValueStore is in.
- **value** (_optional_): An integer greater than or equal to 0 representing the initial value of the Account.

## Common Gift Card Requests  
Below are the most common requests made when interacting with Gift Cards.

### Retrieve Gift Code
The unique code that's generated for a Gift Card must be retrieved via the following endpoint. It is not returned with the Gift Card (`ValueStore`) for security purposes.

`GET https://api.lightrail.com/v2/valueStores/<valueStoreId>/code`

Example response:

```json 
{
    "code": "ABCDEFGHIJKLM"
}
``` 

### Using a Gift Card as a Payment Source in Checkout
Checkout is done using the `/transactions/orders` endpoint. To use a Gift Card as a payment source simply provide the following in the sources property of the request. 

```json
{
    "rail": "lightrail",
    "code": "ABCDEFGHIJKLM"
}
```

## Support
If you have any questions regarding Gift Card integrations, please [contact us](mailto:hello@lightrail.com) any time, we're here to help.