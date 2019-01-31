# Accounts and Points
Accounts or Loyalty Point solutions are used when tracking value associated with a customer.  
Typically this is used for integrations where a customer can earn value, such as dollars or credits and we think of this value as an "account" associated with the customer.  

Your customer's account may represent value that can be used during checkout or it may represent points or credits that can be redeemed for in app rewards or promotions. 

Like all other Lightrail value, accounts are backed by `Values`. 

### Getting Started with Accounts
To get started with accounts, you first need to create a `Program` which defines the default parameters for your accounts.

#### Creating a Program
The `Program` will define the basic properties like currency for the accounts (`Values`) that will be created from it. 
Below are the required and optional attributes needed for creating a `Program` for an account or a loyalty points use-case.   

Creating an account `Program`. Note, typically Programs are created through the app (coming soon!). 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "id": "customer-accounts-usd",
    "currency": "USD",
    "name": "Accounts USD",
    "discount": false,
    "pretax": false,
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating an Account Program. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
 - **id** (_required_): Unique idempotent ID for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer (default: `true`). Typically should be `false` for Account Programs.
 - **pretax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `true`). Set this to `false` for Account Programs.
 - **name** (_optional_): A human-readable name for the Program.
 - **tags** (_optional_): Segmentation tags.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Creating an Account
Request to create an account.  

`POST https://api.lightrail.com/v2/values`
```json
{
    "id": "account-h54sya3",
    "programId": "customer-accounts-usd",
    "contactId": "cus_123",
    "balance": 2500
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating an Account from a Program. For full attribute details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
- **id** (_required_): Unique idempotent id for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **contactId** (_required_): Unique ID for the Customer.
- **balance** (_optional_): An integer greater than or equal to 0 representing the initial balance of the Account.

### Common Requests  
Below are the most common requests made when interacting with Accounts.

#### Crediting
Crediting is used when adding value to an Account.

`POST https://api.lightrail.com/v2/transactions/credit`
```json
{
    "id": "unique-id-123",
    "destination": {
        "rail": "lightrail",
        "valueId": "account-h54sya3"
    },
    "amount": 2500,
    "currency": "USD",
    "metadata": {
        "note": "Reloaded balance from credit card.",
        "chargeId": "ch_1234567"
    }
}  
```

See full credit endpoint details [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/credit). 

#### Debiting
Debiting is used when removing value from an account.

`POST https://api.lightrail.com/v2/transactions/debit`
```json
{
    "id": "unique-id-123",
    "source": {
        "rail": "lightrail",
        "valueId": "account-u824rj0"
    },
    "amount": 2500,
    "currency": "XXX",
    "metadata": {
      "note": "Reduce loyalty points after 3mo customer inactivity"
    }
}
```

See full debit endpoint details [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/debit).

#### Using Accounts as a Payment Source in Checkout
Checkout uses the `/transactions/checkout` endpoint. To use an Account directly as a payment source simply provide the following in the sources property of the request. 

```json
{
    "rail": "lightrail",
    "valueId": "account-h54sya3"
}
```

Alternatively, since the account is associated with the Contact, you can directly use the `contactId` as a payment source. This will consider all `Values` associated with the Contact.
```json
{
    "rail": "lightrail",
    "contactId": "cus_123"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for full documentation of the `/transactions/orders` endpoint.

### Support
Want more information on your accounts or loyalty points use-case? [Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
