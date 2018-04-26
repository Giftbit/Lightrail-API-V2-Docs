# Accounts and Loyalty Points
Accounts or Loyalty Point solutions are used when tracking value associated with a customer.  
Typically this is used for integrations where a customer can earn value, such as dollars or credits and we think of this value as an "Account" associated with the customer.  

Your customer's account may represent value that can be used during checkout or it may represent points or credits that can be redeemed for in app rewards or promotions. 

Like all other Lightrail value, Accounts are backed by `ValueStores`. You’ll need to set up an Account program to establish the default behaviour for your customer accounts.

## Creating an Account Program
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
 - **programId:** (_required_) Unique idempotent ID for the Program.
 - **currency:** (_required_) Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **access:** (_required_) Always use value `customerId` for creating account programs. This means the ValueStores must be attached to a Customer.  
 - **name:** (_optional_) A human-readable name for the Program.
 - **tags:** (_optional_) Segmentation tags.
 - **metadata:** (_optional_) Arbitrary data associated with the Program.

## Creating Accounts
Creating Accounts for your customers is easy. Below is an example of how this is done.

`POST https://api.lightrail.com/v2/programs`
```json
{
    "valueStoreId": "vs-1",
    "programId": "customer-accounts-usd",
    "customerId": "cus_123",
    "value": 2500
}
``` 

## Crediting

## Debiting

## Transactions
