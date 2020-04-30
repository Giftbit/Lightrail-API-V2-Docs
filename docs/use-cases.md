# Use Cases

<p class="intro">
Lightrail supports many use cases for how you can use customer value. We offer the ability to do Points Programs, Referrals, Generic and Unique Codes, Discount and Dollar-off Promotions, Digital Giftcards and many more. 
</p>

## Accounts and Points
<p class="intro">Accounts or Loyalty Point solutions are used when tracking value associated with a customer.</p>
  
Typically this is used for integrations where a customer can earn value, such as dollars or credits. We think of this value as an "account" associated with the customer.  

Your customer's account may represent value that can be used during checkout or it may represent points or credits that can be redeemed for in-app rewards or promotions. 

Like all other Lightrail value, accounts are backed by `Values`. 

### Getting Started with Accounts
To get started with accounts, you first need to create a `Program` which defines the default parameters for your accounts.

#### Creating a Program
The `Program` will define basic properties like currency for the accounts (`Values`) that will be created from it. 
Below are the required and optional attributes needed for creating a `Program` for an account or a loyalty points use-case.   

Creating an account `Program`. Note, typically Programs are created through the app. 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "id": "customer-accounts-usd",
    "currency": "USD",
    "name": "Accounts USD",
    "discount": false,
    "pretax": false
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating an Account Program. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
 - **id** (_required_): Unique idempotent ID for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer (default: `false`). Typically should be `false` for Account Programs.
 - **pretax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `false`). Set this to `false` for Account Programs.
 - **name** (_optional_): A human-readable name for the Program.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Creating an Account
Creating an account for a customer means creating a `Value` from your Accounts `Program`: 

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
Below is the list of attributes commonly used when creating an account from a Program. For full attribute details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
- **id** (_required_): Unique idempotent id for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **contactId** (_required_): Unique ID for the Customer.
- **balance** (_optional_): An integer greater than or equal to 0 representing the initial balance of the Account.

### Common Requests  
Below are the most common requests made when interacting with accounts.

#### Crediting
Crediting is used when adding value to an account.

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

See full `credit` endpoint details [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/credit). 

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
    "currency": "POINTS",
    "metadata": {
      "note": "Reduce loyalty points after 3mo customer inactivity"
    }
}
```

See full `debit` endpoint details [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/debit).

#### Using Accounts as a Payment Source in Checkout
Checkout uses the `/transactions/checkout` endpoint. To use an account directly as a payment source simply provide the following in the `sources` property of the request. 

```json
{
    "rail": "lightrail",
    "valueId": "account-h54sya3"
}
```

Alternatively, since the account is associated with the Contact, you can directly use the `contactId` as a payment source. This will cause all `Values` associated with the Contact to be considered as payment sources.
```json
{
    "rail": "lightrail",
    "contactId": "cus_123"
}
```

See [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for full documentation of the `/transactions/checkout` endpoint.

## Promotions
Lightrail supports a wide variety of promotion use cases. A few common examples are:

 1. Personalized promotion associated with a customer.
 2. A site wide promotion code that can be entered during checkout.
 3. Unique promotion code delivered to a potential customer.  
 
Promotions can be valid for a percentage or dollar-off discount. 
These variations are all determined by properties on the `Value` which represents the promotion.

### Getting Started with Promotions
To get started with promotions, you first need to create a `Program` which defines the default parameters for your promotion.

Let's look at an example of creating a sign-up promotion which will be attached to new sign-ups for $5 off their first purchase.  

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
    "pretax": true,
    "balanceRule": {
        "rule": "500 + value.balanceChange",
        "explanation": "Up to $5 off purchase."
    }
}
``` 

#### Attributes
Below is the list of attributes commonly used when creating a Promotion Program. For full attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
 - **id** (_required_): Unique idempotent ID for the Program.
 - **currency** (_required_): Currency code. Can be a standard ISO form such as USD or CAD but can also be any branded currency, eg: `megabucks`.
 - **name** (_optional_): A human-readable name for the Program.
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer. Set to `true` (default: `false`). 
 - **pretax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `false`). 
 - **minInitialBalance** (_optional_): The minimum balance the Values in this Program can be created with.
 - **maxInitialBalance** (_optional_): The maximum balance the Values in this Program can be created with.  
 - **fixedInitialBalances** (_optional_): A list of exact balances the Values in this Program can be created with. 
 - **balanceRule**: A Balance Rule controlling the effective balance of the Value in a checkout transaction - for example, a percent-off discount. See the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for usage details.
 - **redemptionRule**: A Redemption Rule controlling when the Value can be used in checkout. See the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for usage details.
 - **metadata** (_optional_): Arbitrary data associated with the Program.

### Attaching the Promotion to a Contact 
This request attaches a new Value to a Contact, so that this promotion will be applied automatically when the Contact is specified as a payment source in checkout (see next section).

`POST https://api.lightrail.com/v2/values`
```json
{
    "id": "cus_123-sign-up-promotion",
    "programId": "sign-up-promotion",
    "contactId": "cus_123"
}
``` 

#### Attributes
Below is the list of attributes used when creating a promotional Value from a Program. For full Value creation attribute details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
- **id** (_required_): Unique idempotent id for the Value.
- **programId** (_required_): The programId of the Program this Value is in.
- **contactId** (_required_): Unique ID for the Contact.

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

## Marketplace
Beyond single brand e-commerce integrations, Lightrail supports the more sophisticated requirements of marketplaces and multi-merchant coalitions. 

To highlight some of the additional functionality, consider the ride-sharing marketplace example. Here the marketplace, the platform, takes a fee for any rides purchased through the app. The marketplace must pay out the drivers for any completed rides. Suppose the marketplace wants to offer a promotion giving customers 50% off their first ride. Depending on the requirements, the marketplace may need to be fully liable for that promotion. Alternatively, it might be a promotion that has shared liability between the marketplace and the driver. Finally, a promotion may not apply to all purchases. Perhaps the promotion is restricted by location. Lightrail supports a diverse set of configurations to model these different scenarios.    

#### Marketplace Commission Rate
You can set the marketplace rate, which is the marketplace’s commission rate, on each line item in checkout. This enables you to have items that have variable fees. See the [checkout endpoint](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for more information. Details of `marketplaceRate` can be found under the `lineItems` request attribute. 

#### Liability
The marketplace or seller (the driver, in our example), must be responsible for the promotional liability. You can create promotions that discount your service fees only. This gives you fine control over which party-the marketplace or the seller-is liable for the discount. For example, you (or your merchants) can create promotions that discount their seller amount only.
See the request attribute `discountSellerLiability` under the [create value endpoint](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).

#### Restricting Usage
You can make promotions only applicable to certain activities, locations, or merchants. For example, a promotion that is only applicable for rides in LA. The Value `redemptionRule` attribute supports this. 
See the [Redemption Rule documentation](#use-cases/redemption-rules-and-balance-rules) for more information.


## Gift Cards
<p class="intro">Lightrail enables you to create a custom gift card solution with ease and optimize your gift cards for acquisition, engagement, and retention.</p>
 
Lightrail provides the core infrastructure to power your gift cards. Some development effort is required for implementation — we’re here to make that process as easy as possible.

#### Intention and Audience
This document explains how to set up gift cards using Lightrail to work within an e-commerce checkout that uses [Stripe](https://stripe.com/) or a similar payment processor.  The intended audience is technical people who are comfortable making API calls, or those who understand typical REST HTTP Methods.

### Overview

There are typically four key elements of the gift card experience. 

1. The consumer buying experience
2. Registering the gift card to an account or wallet as a recipient
3. Accepting gift cards in checkout as a payment method
4. Checking the balance of a gift card

#### Getting Started
For our example we will assume you are creating a section of your website that allows your customers to buy gift cards and send them to a recipient, and that there needs to be a means for accepting the gift card code in the checkout experience. Gift cards are identified by a unique code which is the primary way recipients will interact with the gift card value.
The gift card will also need to be delivered to the recipient — for example via email, SMS, displayed on a web page, downloaded, etc.  For brevity we will omit the delivery step from this example and assume you will use your usual customer communication flow.

### Consumer Buying Experience

#### Setting up Gift Cards
To get started with gift cards, [create a](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) [Program](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) to organize and provide a template for your gift card Values. [Values](https://www.lightrail.com/docs/#object-model/values) are the core object in Lightrail which represent the gift card balance and unique gift code. Values can also be used to represent other types of promotions and customer value in Lightrail, so Programs allow for the definition of common gift card defaults such as:

- No expiry date
- Variable denominations
    - Range eg. $0-$2000 
    - Fixed eg. $5, $10, $20, $50, $100 etc.
- Post-tax in checkout
- No rules or conditions for redemption
- Unlimited uses

Additionally, Lightrail’s web app includes Program performance stats to help you understand and assess a Program’s success. 

For full `Program` attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program). 

#### Creating the Gift Card Program
This Program will define the parameters of the Values that will be created and used for the gift card.

#### Call to Create a Gift Card Program that allows you to issue gift cards from $0 — $2000:
`POST https://api.lightrail.com/v2/programs`
```json
{
  "id": "range-gift-card-program-id",
  "name": "Range Gift Card Program",
  "currency": "USD",
  "minInitialBalance": 0,
  "maxInitialBalance": 200000,
  "discount": false,
  "pretax": false,
  "startDate": null,
  "endDate": null
}
```

#### Important Notes:
- **metadata**: If you are interested in distributing your gift cards in an email, you can use `metadata` to support things like **company logos**, **email subject**, and **message**. For full `Program` attribute details, see the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program).
- **minInitialBalance / maxInitialBalance**: This sets the minimum and maximum balance range that a gift card Value can be issued for. Lightrail stores currency in the the smallest whole unit, so `200000` USD is $2000.00. 
    Alternately you could set `fixedInitialBalances`  as a list of exact balances that are permissible. 

#### Selling gift cards
Gift cards are represented in Lightrail as Values and will be created from the Program we set up earlier. For our example we will demonstrate creating the Value at the time of purchase, and we will be creating them from our *Range Program*.

#### Selling a gift card follows these basic steps:

1. You will need a page on your website where the customer can purchase the gift card. You can use [Lightrail’s checkout functionality](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout), or use your existing payment handling flow to process payment for the gift card. 
1. Once the gift card has been paid for, you make a call to Lightrail to create the `Value` that will represent the gift card. For full `Value` creation details, see the [Values endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/values/create-a-value).
1. Send the recipient the gift card code. This is dependent on your use case and the distribution is entirely up to you. The recipient will need the Value’s code to [register it to their account/wallet](#use-cases/register-the-gift-card-to-an-account-or-wallet), use it in a [checkout transaction](#use-cases/accepting-the-gift-card-in-checkout), or [check the balance](#use-cases/balance-check)). 

 
#### Call to Create Gift Card Value in Step 2:
`POST https://api.lightrail.com/v2/values`
```json
{
  "id": "b4b3598a-857d-4f6c-b",
  "programId": "range-gift-card-program-id",
  "balance": 5000,
  "generateCode": {} // leave this object blank to accept the defaults
}
```

The parameter `generateCode` tells the server to generate our gift card code for us. The generated code is returned in the response. We’ll use `GIFT-CARD-DEMO-1234-5678` for the rest of the example.

#### Important Notes:
- **id**: This is the ID you choose to represent the Value. Lightrail recommends [UUID v4](https://en.wikipedia.org/wiki/Universally_unique_identifier) as an excellent way to generate an `id`.
- **programId**: It is important to use the `programId` to ensure the `Value` will be created and tracked under the appropriate *Range Program*. This ensures that the defaults set in the Program will apply to the gift card Value .
- **balance**: Amounts are represented in cents. Since we defined our `Program` to use USD, the `5000` represents $50.00.
- **generateCode:** This property generates a unique code. We recommend using the default length and character set. To do so, simply set this to an empty object, i.e. `generateCode: {}`. Alternatively you can set the `code` property to a unique code of your choosing. This can be completely random or follow a pattern that makes sense for your organization. 
- **metadata:** You may want to use the Value’s `metadata` property to include the associated payment `id` you would receive from your payment provider. This will help you cross reference the transaction later.
- In this example we have omitted properties that were already set in the `Program`, such as `discount`, `pretax`, `startDate`, and `endDate`, however these can be overridden on a per `Value` basis if need be.

### Register the Gift Card to an Account or Wallet

Gift cards can be used anonymously, but the easiest way for a recipient to use a gift card as a payment source is to register it to their account or wallet. This means [creating a Lightrail](https://lightrailapi.docs.apiary.io/#reference/0/contacts/create-a-contact) `[Contact](https://lightrailapi.docs.apiary.io/#reference/0/contacts/create-a-contact)` record for the recipient and attaching the gift card `Value` to that `Contact`. For brevity we will assume that the contact record already exists — otherwise, see the API docs.

Once you’ve attached the gift card to the Contact, the balance will be automatically available in their checkout. 

Using the ID of the existing Contact, you can now attach the gift card `Value` to the `Contact`:

`POST https://api.lightrail.com/v2/contacts/<contactId>/values/attach`
```json
{
  "code": "GIFT-CARD-DEMO-1234-5678"
}
```

For the rest of this example, we’ll assume that you’ve attached the gift card to a contact with ID `CONTACT-ABCD-1234-EFGH`. We’ll use that ID in the checkout step.


### Accepting the Gift Card in Checkout

Now that we’ve attached the gift card `Value` to the `Contact`, for the next step in this example we’ll assume that this person is logged in to your site, has an item in their cart, and is ready to checkout. 

We will supply the `contactId` as one of the payment `sources` in the `checkout` call. When a `contactId` is present, Lightrail will use any Values attached to the contact that are not frozen, expired, or otherwise can’t be applied to the transaction. 

Lightrail allows you to split payment over multiple payment sources, which makes it easy for your customers to checkout for amounts greater than the balance of their attached Values. For our example, we will demonstrate how the attached gift card would be used in combination with Stripe.

Alternatively, you could allow for anonymous users by providing the gift card `code` as a source instead of the `contactId`.

For full `checkout` request details, see the [Transaction / Checkout endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout). 

#### Call to Checkout
`POST https://api.lightrail.com/v2/transactions/checkout`

```json
{
  "id": "transaction-id-FGHI-9876",
  "currency": "USD",
  "sources": [
    { 
      "rail": "lightrail",
      "contactId": "CONTACT-ABCD-1234-EFGH" 
    },
    {
      "rail": "stripe",
      "source": "tok_visa"
    }
  ],
  "lineItems": [
    {
      "unitPrice": 8500
    }
  ]
}
```    
    
#### Important Note:
You can use `"simulate": true` to test the `checkout` request before submitting the transaction.

### Balance Check

In order for customers to be able to easily check the remaining `balance` on their gift card, you can provide a page that accepts a gift card `code` and looks up the `Value`. Lightrail recommends using a [CAPTCHA](https://en.wikipedia.org/wiki/CAPTCHA) challenge-response system to ensure the user is human. See the [Values](https://lightrailapi.docs.apiary.io/#reference/0/values/get-a-value-by-code) [endpoint to retrieve the value by code](https://lightrailapi.docs.apiary.io/#reference/0/values/get-a-value-by-code).

`GET https://api.lightrail.com/v2/values?code=GIFT-CARD-DEMO-1234-5678`

**RESPONSE**
```json
[
  {
    "id": "b4b3598a-857d-4f6c-b",
    "currency": "USD",
    "balance": 5000,
    "programId": "range-gift-card-program-id",
    "contactId": "CONTACT-ABCD-1234-EFGH",
    "code": "…5678",
    ... // additional properties omitted for brevity
  }
]  
```

If you have any questions or comments, please get in touch with us at [hello@lightrail.com](mailto:hello@lightrail.com)

## Referral Programs 
 
<p class="intro">Referrals are an effective type of promotion for acquisition and growth. Referral value needs to be a cohesive part of your payment experience, just like a promotion or gift card.</p>

You can use Lightrail to create a best-in-class referral program. Lightrail provides the core infrastructure for your referral program but will require some development effort to fully implement. 

_In the following scenario, we will demonstrate a sample referral flow. An existing customer, Jamie, will refer a new user, Tim. This flow supposes that Jamie creates a personal referral code to share with friends, but you can change or augment this flow as you see fit._

_In our example API calls we will suppose that we're offering both the referring person and the referred person $20 USD each for a successfully referred new customer. As you can see we’ve used USD, but any currency (including points) will work._
    
_**Note**: Your business will need to determine what makes a referral successful. In this example, the referrer will receive their credit after the new user has signed up and made their first purchase. In your flow, you may wish to add extra conditions, eg: wait until after the order has been fulfilled, or until the end of the refund window, or until a pending order has been finalized, etc._

### How to set up your Referrals 

To get started with a Referral Program, you will create two separate Programs:

1. To generate and track personal referral codes ("Referral Program")
1. To give account credit to users that successfully refer someone ("Referrer Credit Program")

### Step 1: Creating the Referral Program

The first `Program` will define the parameters for personal referral codes that your existing users can generate and give to their friends. 
We will cover the steps for creating a personal referral code for an existing user in **Step 3**.

#### Call to Create Referral Program:

`POST https://api.lightrail.com/v2/programs`
```json
{
  "id": "referral-program-id",
  "currency": "USD",
  "name": "Referral Program",
  "discount": true,
  "pretax": true,
  "redemptionRule": {
    "rule": "metadata.purchaseCount == 0 && !!metadata.purchasingContactId && !!value.metadata.referringContactId && metadata.purchasingContactId != value.metadata.referringContactId",
    "explanation": "Must be used on first purchase and can't be used by referrer."
  } 
}
```

#### Important Note:
The `redemptionRule` as written, is required to make sure that the referral code can only be used by new users. The metadata properties this rule depends on will be set in other calls we address below. 

### Step 2: Creating the Referrer Credit Program

This is the `Program` you will use to credit **the referring** users who successfully refers a new user(s).

#### Call to Create Credit Program:

`POST https://api.lightrail.com/v2/programs`
```json
{
  "id": "credit-program-id",
  "currency": "USD",
  "name": "Credit Program",
  "discount": true,
  "pretax": false
}
```

### Step 3: Creating Referral Codes

In this step, an existing user creates a personal referral code that they can distribute to their friends. This is accomplished by using the Referral Program (created in Step 1) to generate a “generic value” with a specific code that the existing user can distribute to their friends.

When an existing user creates their referral code two things need to happen. 

1. Generate a Referral Code from the Referral Program
1. Generate a Value to be credited from the Credit Program (this is a Value that will be attached to the referrer and will store the credit they receive when new users sign up using their referral code: details in **Step 4**)


#### Call to Create a Referral Code for the Existing User

`POST https://api.lightrail.com/v2/values`
```json
{
  "id": "jamie-referral-code-id",
  "programId": "referral-program-id",
  "isGenericCode": true,
  "code": "JAMIE_GIVES_20",
  "genericCodeOptions": {
    "perContact": {
      "usesRemaining": 1,
      "balance": 2000
    }
  },
  "metadata": {
    "referringContactId": "referring-jamie-contact-id"
  }
}
```

#### Important Notes:

- **id**: Use a [deterministic](https://en.wikipedia.org/wiki/Deterministic_system) ID for the referral code (i.e. `<contactId>-referral-code-id`).
    - You’ll use this to lookup a user’s referral code. 
- **code**: We have used the referring user’s first name as part of the code to add some personalization, but this could completely random if need be.
- **genericCodeOptions**: Here we define the `perContact` attributes that fit our example. The receiving user will get $20 (`"balance": 2000`) towards their first purchase (`"usesRemaining": 1`).
- **metadata**: Set `referringContactId` in the metadata. This is required for the Referral Program `redemptionRule` to work in `checkout` 
- You may wish to set other `Value` attributes that pertain to your use case, such as `startDate` and  `endDate` etc., but we’ll be excluding them from the example for brevity.

### Step 4: Generating the Value for the Referrer Credit Program

In this step, you’ll create a unique `Value` and attach it to the existing user — the referrer. When new users sign up using the existing user’s referral code, you’ll give credit to the existing user by adding balance to this `Value`.

#### Call to Create a Credit Value for the Existing User

`POST https://api.lightrail.com/v2/values`
```json
{
  "id": "referring-jamie-credit-id",
  "programId": "credit-program-id",
  "contactId": "referring-jamie-contact-id",
  "balance": 0
}
```

#### Important Note:     
- **balance**: The Value is created with `"balance": 0` so that when they successfully refer a new user this `Value` will be credited.  

### Step 5: Attaching the Value to the Contact
 
In this step, we will be demonstrating how to create the new user and attach the referral code to the user. There are a number of ways a referred user could have received the code—via email, text message, word-of-mouth, etc. You will need _somewhere_ for a new user to “Register” and enter a referral code. 

Here we will suppose you have a form field on a `/register` page that allows a new user to enter the referral code. We will also suppose that when your user requested the referral code, your site provides a shareable link to the registration page to help them with distributing it to their friends. This way you could pass the `code` along in a link to auto-populate the form field on the registration page for them like so: 
`https://yourcompany.com/register?code=JAMIE_GIVES_20`. 

The same link/code strategy would work well if you allowed your existing users to distribute their referral codes in a branded email, which could contain the code embedded in a link. In this case your referral page could just have a field for your users to enter the email addresses of friends they wanted to share the `code` with.

Using this method your site can check the query string for a `code` and if present, show it in the “Referral Code” in the form field for them.

#### Call to Create a Contact from the Register form

This call will create a `Contact` record for the new user, who is signing up after being referred by an existing user.

`POST https://api.lightrail.com/v2/contacts`
```json
{
  "id": "referred-tim-contact-id",
  "firstName": "Tim",
  "lastName": "Tam",
  "email": "timtam@email.com"
}
```
Once their `Contact` record has been created, you will apply their referral credit by attaching the referral code `Value` to the new `Contact`.

_**Note**: It’s important to wait for the response before attaching the `Value`_

#### Call to Attach Value to Contact

Using the ID of the `Contact` you just created, you can attach the referral code `Value`:

`POST https://api.lightrail.com/v2/contacts/<NEW-contactId>/values/attach`
```json
{
  "code": "JAMIE_GIVES_20"
}
```

Once you’ve attached the referral code to the new `Contact`, the discount will be automatically applied during their first checkout.

### Step 6: Modifying Checkout to Support Referrals

If you’re an existing Lightrail user, you will need to modify your checkout calls to include both `purchaseCount` and `purchasingContactId` in the request metadata. This will provide the required context for the Redemption Rule on the referral code `Value` be properly evaluated, and give credit to both your new users and your existing user who sent out the referral.

If you’re new to Lightrail and just getting set up, we suggest including this information from the beginning.

The new metadata properties should be populated as follows:
`purchaseCount` should reflect the number of purchases that have been made by the contact checking out. In the case of a new user who has just signed up, this will be `0`.
`purchasingContactId` is the ID of the contact making the purchase, i.e., the new user’s `contactId`. It should be the same as the `contactId` listed in the payment sources.

Because the referral code `Value` was attached to the new user in the previous step, when their `contactId` is used as a payment source with these metadata properties set, the discount will be automatically applied to their purchase.

#### Call to Checkout

`POST https://api.lightrail.com/v2/transactions/checkout`
```json
{
  "id": "referred-tim-purchase-id",
  "currency": "USD",
  "sources": [
    { 
      "rail": "lightrail", 
      "contactId": "referred-tim-contact-id" 
    }
  ],
  "lineItems": [
    {
      "unitPrice": 5000
    }
  ],
  "allowRemainder": true,
  "metadata": {
    "purchasingContactId": "referred-tim-contact-id",
    "purchaseCount": 0
  }
}
```

#### Important Notes:

- **metadata**: Both `purchasingContactId` and `purchaseCount` are extremely important to include for referrals to work. This is the glue between the referral code `redemptionRule`, and is required for both the referrer (existing user) and the referred (new user) to receive their referral offers.
- You can use `"simulate": true` to test the `checkout` request above and see the discount if you wish to show the discounted savings to the user before submitting the transaction.

### Step 7: Paying Referrers

When the the request to `checkout` is submitted and you receive a successful response you’ll then call your internal system to credit the `Value` set up earlier for the referrer (`referring-jamie-credit-id`).

Here is a pseudo-code version of that call:

```javascript
// This lives in your internal system code and it will be called upon a successful response (201) from the checkout call
referringCreditFunction(tx: LightrailCheckoutTransaction) {
  // Check that it is the user's first purchase and that there is a "lightrail step"  
  if (tx.metadata["purchaseCount"] == 0 && tx.steps.find(step => step.rail == "lightrail")) {
    // for each LR step, lookup value, check metadata for a referring contact id
    for (const step of tx.steps) {
      const value = getValue(step.valueId)
      if (value.metadata.referringContactId !== null) {
        // credit referrer
    }
  }
}
```

Alternatively, rather than putting this step in your core checkout logic, you can create a webhook which would execute the above logic. See our [webhook documentation](#webhooks) for more information about webhooks.   

### Summary

In our example scenario we created the following:
- Two `Programs`
    - One for creating personal referral codes that existing users can distribute to their friends 
    - One for crediting existing users when new users sign up using their referral codes
- One `Value` that will be our generic referral code
- One `Value` that will allow us to credit the referring user when a successful referral is completed

In this example scenario, referral codes were created on demand, programmatically, for existing users who wished to invite new users. New users who received a referral code would register on your site at a `/register` page, which would create a new `Contact` record for them and attach the referral code `Value`. 

There are many possible variations to this scenario — if you have any questions about configuring something different, please [reach out](mailto:hello@lightrail.com). We are here to help.

There are a few additional points of note:
- Currently the Lightrail API allows Jamie to attach the referral code to himself, but the Redemption Rule on the referral code `Value` prevents him from spending it.
- In this scenario, only new users making their first purchase can use a referral code.
- Referral codes can’t be accidentally applied to ineligible purchases, because if the metadata properties outlined in Step 6 are omitted, the `Value` won’t be applied.
- The Value’s ID of Jamie's referral code must be stored in your internal system or it must be deterministic.
    - This allows you to look up a Contact's referral code.
    - This allows you to look up a Contact to view the attached values and therefore contacts they've referred
        - additional look ups are required to tell if those referred users have spent their credits
    - In the event that a new user who received a referral credit returns the item that they purchased, you can choose to remove their referral credit (rather than refunding it) and/or remove the credit that was issued to the referrer.

If you have any questions or comments, please get in touch with us at [hello@lightrail.com](mailto:hello@lightrail.com)

## Redemption and Balance Rules

<p class="intro">Redemption Rules and Balance Rules are extra conditions placed on Values that are evaluated during checkout.</p>

A Value's Redemption Rule evaluates to true or false and determines if that Value can be applied. This does not affect whether other Values can be used since each Value's own Redemption Rule determines whether or not it can be applied. Balance Rules enable more advanced balance behaviour, such as percent off, and evaluate to a number in the context of a particular Transaction. Balance Rules and Redemption Rules are typically used for promotions that represent a discount to the customer.   

**Example 1: $5 off transactions over $100** 

In this case, the Value would simply have a balance of $5 and the Redemption Rule would require that the transaction subtotal is over $100.

Create Value request - `POST https://api.lightrail.com/v2/values`:
```json
{
    "id": "example",
    "currency": "USD",
    "balance": 500,
    "redemptionRule": {
        "rule": "totals.subtotal >= 10000",
        "explanation": "Applies to orders over $100."
    },
    "discount": true
}
```

**Example 2: 50% off red hats**

This example requires the use of a Balance Rule in combination with a Redemption Rule. The Redemption Rule restricts the Value to apply strictly to an item with `productId: red-hat`. The Balance Rule causes the Value to be worth 50% of the item's subtotal.

Create Value request - `POST https://api.lightrail.com/v2/values`:
```json
{
    "id": "example",
    "currency": "USD",
    "redemptionRule": {
        "rule": "currentLineItem.productId == 'red-hat'",
        "explanation": "Promotion can be used towards purchase of red hats."
    },
    "balanceRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.5",
        "explanation": "50% off item's subtotal."
    },
    "discount": true
}
```

### How Rules Work
Values are applied one by one to each line item in turn during checkout. Balance Rules and Redemption Rules are evaluated for each line item. Rules operate on a rule context, described below. Redemption Rules only determine whether the Value they're set on can be applied and do not affect whether other Values can be applied. 

#### Rule Context 
```json
{
    "currentLineItem": {
        "type": "product | shipping | fee",
        "productId": "string",
        "variantId": "string",
        "unitPrice": "number",
        "quantity": "number",
        "tags": "string[]",
        "taxRate": "number",
        "metadata": "object",
        "lineTotal": {
            "subtotal": "number",
            "discount": "number",
            "remainder": "number"
        }
    }, 
    "totals": {
        "subtotal": "number"
    }, 
    "lineItems": [
        {
            "type": "product | shipping | fee",
            "productId": "string",
            "variantId": "string",
            "unitPrice": "number",
            "quantity": "number",
            "tags": "string[]",
            "taxRate": "number",
            "metadata": "object",
            "lineTotal": {
                "subtotal": "number",
                "discount": "number",
                "remainder": "number"
            }
        }
    ],
    "metadata": "object",
    "value": {
        "balanceChange": "number",
        "metadata": "object"
    }
}
```

You can think of the Rule Context as a simple map which the Rules evaluate on.

### Limiting How Many Promotions Can Be Applied to Checkout 
By default, any number of Values can be applied to a checkout Transaction. If you want to limit promotions (Values with discount: true) to one promotion per Transaction or one per line item you must include the corresponding Redemption Rule on all of your promotions. Remember that each Value's applicability is determined by its own Redemption Rule and Balance Rule and not affected by rules set on other Values.

#### Limiting to One Promotion per Checkout
If you want to limit promotions (Values with `discount: true`) to one promotion per Transaction you must include the following `redemptionRule` on all of your promotions.
```json
{
    "redemptionRule": {
        "rule": "!(lineItems.find(item => item.lineTotal.discount > 0)) || value.balanceChange < 0",
        "explanation": "Limited to 1 promotion per transaction."
    }
}
``` 

#### Limiting to One Promotion per Line Item
If you want to limit promotions (Values with `discount: true`) to one promotion per `lineItem` you must include the following `redemptionRule` on all of your promotions.
```json
{
    "redemptionRule": {
        "rule": "currentLineItem.lineTotal.discount == 0",
        "explanation": "Limited to 1 promotion per line item."
    }
}
 ``` 

### Examples Continued
**50% off everything, limited to one promotion per transaction**

Create Value request - `POST https://api.lightrail.com/v2/values`:
```json
{
    "id": "example",
    "currency": "USD",
    "balanceRule": {
         "rule": "currentLineItem.lineTotal.subtotal * 0.5",
         "explanation": "50% off line item's subtotal."
     },
    "redemptionRule": {
        "rule": "!(lineItems.find(item => item.lineTotal.discount > 0)) || value.balanceChange < 0",
        "explanation": "Limited to 1 promotion per transaction."
    },
    "discount": true
}
```

**Up to $5 off order, limiting to one discount per line item**

Create Value request - `POST https://api.lightrail.com/v2/values`:
```json
{
    "id": "example",
    "currency": "USD",
    "balanceRule": {
        "rule": "500 + value.balanceChange",
        "explanation": "Up to $5 off order."
    },
    "redemptionRule": {
        "rule": "currentLineItem.lineTotal.discount == 0",
        "explanation": "Limited to 1 discount per item."
    },
    "discount": true
}
```
Values are applied to checkout item by item. The Rule Context property `value.balanceChange` keeps track of the total amount paid by the Value as it gets applied to each item. Note, it is a negative since it represents the change in balance. Also, to enforce that at most one promotion is applied to each line item the redemptionRule `"currentLineItem.lineTotal.discount == 0"` must be set on all promotions.  

**25% off transactions over $100 and limited to 1 promotion per transaction**

Create Value request - `POST https://api.lightrail.com/v2/values`:
```json
{
    "id": "example",
    "currency": "USD",
    "balance": 500,
    "redemptionRule": {
        "rule": "totals.subtotal >= 10000 && (!(lineItems.find(item => item.lineTotal.discount > 0)) || value.balanceChange < 0)",
        "explanation": "Applies to orders over $100. Limited to 1 discount per transaction."
    },
    "balanceRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.25",
        "explanation": "25% off item's subtotal."
    },
    "discount": true
}
```

### Rule Syntax
For more information on rule syntax please see [Rule Sytnax](#advanced/lightrail-rule-syntax).