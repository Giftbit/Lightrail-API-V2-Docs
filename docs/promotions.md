# Promotions
Lightrail enables a wide variety of promotion use-cases. A few common examples are:
 1. Personalized promotion associated with a customer.
 2. A site wide promotion code that can be entered during checkout.
 3. Unique promotion code delivered to a potential customer.  
 
Promotions can be valid for a number of dollars or points off, but they can also represent a percent discount.
These variations are all determined by properties on the `Value` which represents the promotion.

### Getting Started with Promotions
To get started with promotions, you first need to create a `Program` which defines the default parameters for the promotion you want to create.

Let's look at an example of creating a sign-up promotion which will be attached to new sign-ups.  

#### Creating a Program for a Customer Promotion
The `Program` will define the basic properties for the promotional `Values` that will be created from it. 
Below are the required and common optional attributes needed for creating a `Program` for promotions. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).

Example of creating a `Program` for a $5 promotion:  

`POST https://api.lightrail.com/v2/programs`
```json
{
    "id": "sign-up-promotion",
    "name": "Spring Promotion USD",
    "currency": "USD",
    "discount": true,
    "preTax": false,
    "fixedInitialBalances": [
        500
    ],
    "tags": ["promotion", "new-sign-up"]
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating a Promotion Program. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
 - **id** (_required_): Unique idempotent ID for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **name** (_optional_): A human-readable name for the Program.
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer. Set to `true` (default: `true`). 
 - **preTax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `true`). 
 - **minInitialBalance** (_optional_): The minimum balance the Values in this Program can be created with.
 - **maxInitialBalance** (_optional_): The maximum balance the Values in this Program can be created with.  
 - **fixedInitialBalances** (_optional_): A list of exact balances the Values in this Program can be created with. 
 - **valueRule**: A Value Rule controlling the effective balance of the Value in a Checkout - for example, a percent-off discount. See the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for usage details.
 - **redemptionRule**: A Redemption Rule controlling when the Value can be used in checkout. See the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for usage details.
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Attaching the Promotion to a Contact 
This request attaches a new Value to a Contact, so that this promotion will be applied automatically when the Contact is specified as a payment source in checkout (see next section).

`POST https://api.lightrail.com/v2/values`
```json
{
    "id": "cus_123-sign-up-promotion",
    "programId": "sign-up-promotion",
    "contactId": "cus_123",
    "balance": 500
}
``` 

#### Attributes
Below is the list of attributes used when creating a promotional Value from a Program. For full Value creation attribute details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
- **id** (_required_): Unique idempotent id for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **contactId** (_required_): Unique ID for the Contact.
- **balance** (_required_): In this case, must match the amount set in `fixedInitialBalances`. 

#### Using the Promotion as a Payment Source in Checkout
Checkout uses the `/transactions/checkout` endpoint. Since the promotion is associated with the customer, you can directly use the `contactId` as a payment source. 
This will automatically use the promotion along with any other Values attached to the Contact.  

```json
{
    "rail": "lightrail",
    "contactId": "cus_123"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for full documentation of the `/transactions/checkout` endpoint.

### Support
Want more information on promotions? [Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
