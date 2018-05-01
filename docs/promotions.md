# Promotions
Lightrail enables a wide variety of promotion use-cases. A few common examples are:
 1. Personalized promotion associated with a customer.
 2. A site wide promotion code that can be entered during checkout.
 3. Unique promotion code delivered to a potential customer.  
 
These types of promotions are differentiated primarily based on the `accessType` property.
In addition to how the promotion is accessed, they type of value they hold can also differ. 
Promotions can be valid for a number of dollars or points off, but they can also represent a percent discount.
These variations are all determine by properties on the `ValueStore` which represents the promotion.

## Getting Started with Promotions
To get started with promotions, you first need to create a `Program` which defines the default parameters for the promotion you want to create.

### Creating a Program
The `Program` will define the basic properties like `currency`, `accessType` and `value` for the (`ValueStores`) that will be created from it. 
Below are the required and optional attributes needed for creating a `Program` for a promotion.

Creating a promotion `Program`. Note, typically Programs are created through the app (coming soon!). 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "programId": "sign-up-promotion-10off",
    "currency": "USD",
    "access": "customerId",
    "name": "Sign-up $10",
    "tags": ["promotion", "sign-up"]
}
``` 

### Attributes
Below is the list of attributes used when creating an Account Program.
 - **programId** (_required_): Unique idempotent ID for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **access** (_required_): Always use value `customerId` for creating account programs. This means the ValueStores must be attached to a Customer.  
 - **name** (_optional_): A human-readable name for the Program.
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

## Creating an Account
Request to create an account.  

`POST https://api.lightrail.com/v2/valueStores`
```json
{
    "valueStoreId": "account-h54sya3",
    "programId": "customer-accounts-usd",
    "customerId": "cus_123",
    "value": 2500
}
``` 

### Attributes
Below is the list of attributes used when creating an account from a Program.
- **valueStoreId** (_required_): Unique idempotent id for the ValueStore.
- **programId** (_required_): The programId of the Program this ValueStore is in.
- **customerId** (_required_): Unique ID for the Customer.
- **value** (_optional_): An integer greater than or equal to 0 representing the initial value of the Account.

## Common Requests  
Below are the most common requests made when interacting with accounts.

### Crediting
Crediting is used when adding value to an account.

`POST https://api.lightrail.com/v2/transactions/credit`
```json
{
    "transactionId": "unique-id-123",
    "destination": {
        "rail": "lightrail",
        "valueStoreId": "account-h54sya3"
    },
    "amount": 2500,
    "currency": "USD",
    "metadata": {
        "note": "Reloaded balance from credit card.",
        "chargeId": "ch_1234567"
    }
}  
```

See full credit endpoint [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/credit). 

### Debiting
Debiting is used when removing value from an account.

`POST https://api.lightrail.com/v2/transactions/credit`
```json
{
    "transactionId": "unique-id-123",
    "source": {
        "rail": "lightrail",
        "valueStoreId": "account-h54sya3"
    },
    "amount": 2500,
    "currency": "XXX",
    "metadata": {
      "note": "Reduce loyalty points after 3mo customer inactivity"
    }
}
```

See full debit endpoint [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/debit).

### Using Accounts as a Payment Source in Checkout
Checkout is done using the `/transactions/orders` endpoint. To use an account directly as a payment source simply provide the following in the sources property of the request. 

```json
{
    "rail": "lightrail",
    "valueStoreId": "account-h54sya3"
}
```

Alternatively, since the account is associated with the customer, you can directly use the `customerId` as a payment source. This will consider all `ValueStores` associated with the customer.
```json
{
    "rail": "lightrail",
    "customerId": "cus_123"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order) for full documentation of `/transactions/orders` endpoint.

## Support
Want more information on your accounts or loyalty points use-case? [Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 