# Accounts and Loyalty Points
Accounts or Loyalty Point solutions are used when tracking value associated with a customer.  
Typically this is used for integrations where a customer can earn value, such as dollars or credits and we think of this value as an "Account" associated with the customer.  

Your customer's account may represent value that can be used during checkout or it may represent points or credits that can be redeemed for in app rewards or promotions. 

Like all other Lightrail value, Accounts are backed by `ValueStores`. You’ll need to set up an Account program to establish the default parameters for your customer accounts.

## Getting Started with Accounts
To get started with Accounts, you first need to create a Program which defines common properties of your Accounts.

### Creating a Program
The Program will define the basic properties like currency and tags for the accounts (`ValueStores`) that will be created from it. 
Below are the required and optional attributes needed for creating an Account or Loyalty Points Program.   

How to create an Account Program through the API. Note, typically Programs are created through the app (coming soon!). 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "programId": "customer-accounts-usd",
    "currency": "USD",
    "access": "customerId",
    "name": "Accounts USD",
    "tags": ["accounts-usd"]
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
Creating Accounts for your customers is easy. Below is the call to do this. 

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
Below is the list of attributes used when creating an Account from a Program.
- **valueStoreId** (_required_): Unique idempotent id for the ValueStore.
- **programId** (_required_): The programId of the Program this ValueStore is in.
- **customerId** (_required_): Unique ID for the Customer.
- **value** (_optional_): An integer greater than or equal to 0 representing the initial value of the Account.

## Common Account Requests  
Below are the most common requests made when interacting with Accounts.

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

Alternatively, since the account is associated with the customer, you can directly use the `customerId` as a payment source. This will consider all value associated with the customer.
```json
{
    "rail": "lightrail",
    "customerId": "cus_123"
}
```

## Support
Please [contact us](mailto:hello@lightrail.com) any time, we're here to help.