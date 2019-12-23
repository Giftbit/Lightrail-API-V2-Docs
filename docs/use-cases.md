# Use Cases

<p class="intro">
Lightrail supports many Use Cases for how you can use Customer Value. We offer the ability to do Points Programs, Referrals, Generic and Unique Codes, Discount and Dollar-off Promotions, Digital Giftcards and many more. 
</p>

---
## Accounts and Points
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
    "currency": "POINTS",
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

---

## Promotions
Lightrail enables a wide variety of promotion use-cases. A few common examples are:
 1. Personalized promotion associated with a customer.
 2. A site wide promotion code that can be entered during checkout.
 3. Unique promotion code delivered to a potential customer.  
 
Promotions can be valid for a percentage or dollar-off discount. 
These variations are all determined by properties on the `Value` which represent the promotion.

### Getting Started with Promotions
To get started with promotions, you first need to create a `Program` which defines the default parameters for the promotion you want to create.

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
 - **discount** (_optional_): Determines whether the Values in this Program represent a discount to the customer. Set to `true` (default: `true`). 
 - **pretax** (_optional_): Determines whether the Values in this Program are applied before taxes (default: `true`). 
 - **minInitialBalance** (_optional_): The minimum balance the Values in this Program can be created with.
 - **maxInitialBalance** (_optional_): The maximum balance the Values in this Program can be created with.  
 - **fixedInitialBalances** (_optional_): A list of exact balances the Values in this Program can be created with. 
 - **balanceRule**: A Balance Rule controlling the effective balance of the Value in a Checkout - for example, a percent-off discount. See the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for usage details.
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

---

## Drop-in Gift Cards  

<p class="intro">Lightrail's Drop-in Gift Card solution makes it easy to offer gift cards to your customers. Integrating into Lightrail is an easy process that can be completed in no more than a few hours.</p> 

The solution is component based, using elements generated from our client-side library Lightrail UI.
When your customers receive a gift card, they can easily redeem and apply the gift card value to their account.
Your checkout process requires a simple update to accept payment from your customer accounts.

### Getting Started
[Sign up](https://www.lightrail.com/app/#/auth/register) for a Lightrail account.

Note this quickstart assumes you are using Stripe to process payments: if you are using another payment processor and want to build a custom solution, please [contact us](mailto:hello@lightrail.com).

You will need to configure a few settings to get started. 

### Step 1: Authentication & Configuration
Create your Lightrail API key from the [Integrations](https://www.lightrail.com/app/#/account/api) section of your Lightrail account. 
Your Lightrail API key is used to complete the server side requests from checkout, and also to generate Shopper Tokens which are passed into the Lightrail UI library for component authentication.  

Note: For development, toggle your Lightrail account to test mode, this will allow you to use [Stripe's test credit cards](https://stripe.com/docs/testing#cards).

Also, before going live or to see test Stripe charges show up in your Stripe account, you'll need to connect your Stripe account on your account's [Integrations](https://www.lightrail.com/app/#/account/api) page. 

#### Shared Secret
Set the shared secret that Lightrail will use to verify calls made using shopper tokens (see below). This step is done through the API:

`PUT https://api.lightrail.com/v1/storage/jwtSecret`

The request body will simply be a JSON string, which will be stored as your shared secret: 

`"unguessable-secret"`

Note that while you are in test mode the shared secret can be any string. Once you switch to live mode it should be set to something secure and unguessable. 

#### Create Drop-in Gift Card Program
Create the [Program](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) that will be used to set defaults for gift cards (currency, allowable gift card amounts, etc): 

`POST https://api.lightrail.com/v2/programs`
```json
{
    "id": "drop-in-gift-cards",
    "name": "drop-in-gift-cards",
    "currency": "USD",
    "fixedInitialBalances": [500, 1000, 2500, 5000, 7500, 10000],
    "discount": false,
    "pretax": false
}
```

See the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for details on what parameters can be set.

#### Drop-in Configuration
Is done through the API. This example uses the fictional company "Rocketship" to represent your company. 

**Important notes:**
- `stripePublicKey`: Use your test-mode publishable key for development and testing. 
- `claimLink`: This is a URL that you control, where you will host the Redemption Widget to allow customers to claim the gift cards they receive and attach them to their account. You must include `{{fullcode}}` somewhere in the path. You will be responsible for getting the gift card's code from the URL parameters on the redemption page. 

`PUT https://api.lightrail.com/v1/storage/turnkeyPublicConfig`
```json
{
    "copyright": "Rocketship, Inc",
    "companyName": "Rocketship",
    "emailSubject": "You've Received a Gift Card",
    "customerSupportEmail": "support@rocketship.com",
    "stripePublicKey": "pk_1234567890",
    "claimLink": "http://www.rocketship.com/dropin/?code={{fullcode}}",
    "giftEmailReplyToAddress": "gift.cards@rocketship.com",
    "termsAndConditions": "Terms and conditions.",
    "linkToTerms": "http://www.rocketship.com/dropin/terms-and-conditions",
    "additionalInfo": "Once applied, the entire gift card amount will be stored in your account's gift card balance, which doesn't expire. Your gift card balance can't be transferred to other accounts or used to buy gift cards.",
    "linkToPrivacy": "http://www.rocketship.com/dropin/privacy",
    "logo": "https://www.rocketship.com/images/logo.jpeg",
    "companyWebsiteUrl": "http://www.rocketship.com",
    "currency": "USD",
    "programId": "drop-in-gift-cards"
}
```

#### Shopper Tokens
Shopper Tokens act like customer-specific API tokens to be used client-side in the drop-in components. They are based on a Contact's `id` stored in Lightrail.

Shopper Tokens must be generated server side, for example using our [Node (Typescript/Javascript) Client Library](https://github.com/Giftbit/lightrail-client-javascript/tree/v2-client).

The current version of the Lightrail Javascript Client (^2.0.0) is under the alpha tag: `npm install lightrail-client@alpha`

You'll also need the shared secret that you created earlier. You can retrieve it here: `GET https://api.lightrail.com/v1/storage/jwtSecret`

##### Generating a Shopper Token:

First install the client library ([contact us](hello@lightrail.com) if you are not using Node):
```
npm install lightrail-client@alpha
```

Creating a Shopper Token in server side code (this will be passed to the client-side components in Steps 1, 2, & 3): 
```javascript
const lightrail = require("lightrail-client");
 
lightrail.configure({
    apiKey: process.env.LIGHTRAIL_API_KEY,
    sharedSecret: process.env.LIGHTRAIL_SHARED_SECRET
});
const shopperToken = lightrail.generateShopperToken("cust_123abc");
```

Note, usage of Lightrail UI components must be on authenticated pages as it requires a Contact's `id`.
You may decide whether you'd like your customers to be signed in to purchase gift cards. 
If you'd like to allow gift card purchase from an unauthenticated page simply generate a Shopper Token with an empty string as the Contact ID: `lightrail.generateShopperToken("")`. 

Also, you can enable customers to pay using saved credit cards. See [below](#drop-in-gift-cards/enable-your-customers-to-pay-using-saved-credit-cards) for details. 

### Step 2: Selling Gift Cards
The Gift Card Purchase Component allows your customers to purchase gift cards from your site. 
Lightrail powers the entire gift card purchase and delivery flow. 

![Gift Card Purchase Component](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/purchase-widget.png)

What you see here is our fictional brand called Rocketship. Once set up with our Drop-in solution, you will see your branding instead.

Adding the Gift Card Purchase Component:
```html
<html>
    <head>
        <!-- Include the Lightrail UI javascript library in your page header -->
        <script src="https://embed.lightrail.com/dropin_v2/v2/lightrail-ui.js"></script>
    </head>
    <body>
        <div id="launch-button-container">
            <!-- Container to inject launch button into -->
        </div>
        <script>
            // Server generated shopperToken
            var shopperToken = "{{shopperToken}}";
            var lightrailUI = new LightrailUI(shopperToken);
        
            //Tell the component to inject a launch button in #launch-button-container
            var options = {
               launch_btn_container: "#launch-button-container",
               launch_btn_label: "Buy Gift Card",
               launch_btn_classname: "ltrl_button"
            };
            
            //Initialize the component and mount / add it to the page
            var cardPurchaseDialog = lightrailUI.components.cardPurchaseDialog(options);
            cardPurchaseDialog.mount();
        </script>
    </body>
</html>
```

Alternatively, you could use your own button:
```html
    <div class="launch-button-container">
        <button id="buy-card-launch-button">Buy Gift Card</button>
    </div>
    <script>
        //...
        document.getElementById("buy-card-launch-button").addEventListener("click", function(){
            cardPurchaseDialog.open();
        });
    </script>
```

The gift card is automatically delivered to the recipient in a branded email. The email includes a button to apply the gift card to the recipient's account.

Note you will need to pass a server-generated Shopper Token into the above snippet - details [above](#drop-in-gift-cards/shopper-tokens). 

#### Enable Your Customers to Pay Using Saved Credit Cards
Allow your customers to pay with credit cards you've saved for them in Stripe. This will give the customer the option to pay using an existing card, if they have one, or to enter a new one. 

<br/>

![Purchase Using Saved Credit Card](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/saved-credit-cards.png)

To enable this, you need to **provide the customer ID from Stripe** when you generate the Shopper Token. 

How to pass in the `stripeCustomerId` during Shopper Token generation to enable the use of saved credit cards:
```javascript
const options = {
    metadata: {stripeCustomerId: "cus_abcd1234"}
};
const shopperToken = lightrail.generateShopperToken("cust_123abc", options);

```

### Step 3: Redeeming Gift Cards

The Gift Card Redemption Component enables your customers to redeem gift cards to their account.

<br/>

![Gift Card Redemption Component](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/redemption-widget.png)

When the recipient clicks the "apply to account" button in the email, they are taken to the redemption page indicated in your [Drop-in Configuration](#drop-in-gift-cards/drop-in-configuration).

Adding the Gift Card Redemption Component:
```html
<html>
    <head>
        <!-- Include the Lightrail UI javascript library in your page header -->
        <script src="https://embed.lightrail.com/dropin_v2/v2/lightrail-ui.js"></script>
    </head>
    <body>
            <div id="redemption-component"></div>
            
            <!-- Then add the following snippet to your redemption page -->
            <script>
                // Server generated shopperToken
                var shopperToken = "{{shopperToken}}";
                var lightrailUI = new LightrailUI(shopperToken);
    
                // Initialize our redemption component with a fullcode param so that it's auto-populated for the user
                // It's a good idea to ensure your site's log-in / registration flows won't break this
                var fullcodeValue = getUrlParamValue("fullcode");
                var options = {
                    fullcode: fullcodeValue
                };
                // Create the component and mount it inside of the redemption-component div
                var redemption = lightrailUI.components.codeRedemption(options);
                redemption.mount("#redemption-component");
            </script>
        </body>
</html>
```

When a gift card is redeemed, the Redemption Component applies the gift card amount to the customer's account. If the customer does not have an account in Lightrail already, a new account will be created automatically.

The Redemption Component uses a Shopper Token generated by your system to identify the customer and automatically apply the gift card to their account (see [above](#drop-in-gift-cards/shopper-tokens) for details about Shopper Tokens). Note, ensure your redemption page lives behind the login wall of your site so that the correct Shopper Token is generated by your system to identify the customer. 

Next, your existing checkout process needs to be modified to allow the customer to pay with their account, which now contains the balance of the gift card they received. 

### Step 4: Checkout

#### Fetch and Display Account Balance

Displaying Balances:
```html
<html>
    <head>
        <!-- Include the Lightrail UI javascript library in your page header -->
        <script src="https://embed.lightrail.com/dropin_v2/v2/lightrail-ui.js"></script>
    </head>
    <body>
        <p>Your Account Balance: <span id="account-balance"></span></p>
        <script>
                // Server generated shopperToken
                var shopperToken = "{{shopperToken}}";
                var lightrailUI = new LightrailUI(shopperToken);
                
                // Fetch and Display a simply formatted balance in the account-balance span
                lightrailUI.displayAccountBalance("#account-balance");
                
                // Alternatively, use fetchAccountBalance for more control
                lightrailUI.fetchAccountBalance(function(balance){
                    var formattedBalance = yourCustomFormatter(balance.balanceInCents, balance.currency);
                    document.getElementById("account-balance").innerHTML = formattedBalance;
                });
        </script>
    </body>
</html>
```

This can be used anywhere it makes sense to display an account balance to your customer. 
In the checkout, it gives your customer the information to choose whether or not to apply their account credit to their purchase.

#### Accept Payment
You will need to add a custom script to your checkout page to apply your customer's account credit to their purchase and accept a secondary payment method (such as a credit card) to cover any remaining balance. 

This script will need to do the following: 

- Let the customer choose whether to use their account credit
- Call a checkout simulation method on your server (see next section)
- Post the transaction (see next section)

#### Post the Transaction (server side)
The transaction is handled by backend methods. You'll need to set up two endpoints to handle submissions from the custom form you added to [accept payment](#drop-in-gift-cards/accept-payment) to: 
1. simulate transactions (check the customer's account balance),
1. post the transaction and redirect your customer to a success page. 

A brief example of the simulate/charge flow follows. For more details on the usage of the `/transactions/checkout` endpoint, see [here](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout).

#### Simulate a Charge / Balance Check
When your customer chooses to use their account credit, you need to see whether the account can cover the requested amount and whether the customer has any other attached value that can be used for the transaction. Our API makes it easy to post a split-tender charge where part of the transaction is covered by a Lightrail account, and part is covered by Stripe.

The following is an example of the call that must be made by your simulation endpoint.

`POST https://api.lightrail.com/v2/transactions/checkout`
```json
{
   "id":"unique-checkout-id-123",
   "currency":"USD",
   "lineItems":[
      {
         "productId":"pid_1",
         "unitPrice":3000,
         "taxRate":0.05
      }
   ],
   "sources":[
      {
         "rail":"lightrail",
         "contactId":"cus_234"
      },
      {
         "rail":"stripe",
         "source":"tok_visa"
      }
   ],
   "simulate": true
}
```

The `lineItems` array contains the details of the items in the order.

The `sources` array specifies the payment sources: in this case, the Contact who received the gift card and attached it to their account, and a tokenized credit card from Stripe to cover any remaining balance. Specifying `"contactId": "cust_123abc"` will use any value associated with that customer in Lightrail.

The `simulate` flag tells Lightrail to calculate the amounts that each source can cover without actually charging them. Stripe is not called; it is assumed that any remaining amount not covered by Lightrail will be successfully charged to the credit card.

#### Post the Charge
To complete the transaction, simply send the same request again without the `simulate` flag (or with `"simulate": false`).

The following is an example of the call that must be made by your charge endpoint. 

`POST https://api.lightrail.com/v2/transactions/checkout`
```json
{
   "id":"unique-checkout-id-123",
   "currency":"USD",
   "lineItems":[
      {
         "productId":"pid_1",
         "unitPrice":3000,
         "taxRate":0.05
      }
   ],
   "sources":[
      {
         "rail":"lightrail",
         "contactId":"cus_234"
      },
      {
         "rail":"stripe",
         "source":"tok_visa"
      }
   ]
}
```

At this point, the charge has been posted to both Lightrail and Stripe. You can handle post-checkout flow as you otherwise would. The response will include the Lightrail transaction details as well as the full Stripe charge response: 

`201 OK`
```json
{
   "id":"unique-checkout-id-123",
   "transactionType":"checkout",
   "currency":"USD",
   "createdDate":"2019-01-31T22:14:09.000Z",
   "tax":{
      "roundingMode":"HALF_EVEN"
   },
   "totals":{
      "subtotal":3000,
      "tax":150,
      "discount":0,
      "payable":3150,
      "remainder":0,
      "discountLightrail":0,
      "paidLightrail":1000,
      "paidStripe":2150,
      "paidInternal":0
   },
   "lineItems":[
      {
         "productId":"pid_1",
         "unitPrice":3000,
         "taxRate":0.05,
         "quantity":1,
         "lineTotal":{
            "subtotal":3000,
            "taxable":3000,
            "tax":150,
            "discount":0,
            "remainder":0,
            "payable":3150
         }
      }
   ],
   "steps":[
      {
         "rail":"lightrail",
         "valueId":"$10 GCa sfd",
         "contactId":"cus_234",
         "code":null,
         "balanceBefore":1000,
         "balanceAfter":0,
         "balanceChange":-1000,
         "usesRemainingBefore":null,
         "usesRemainingAfter":null,
         "usesRemainingChange":null
      },
      {
         "rail":"stripe",
         "chargeId":"ch_1DynnSCM9MOvFvZK7BGHlNLE",
         "charge":  {
            // ...full Stripe charge response: for an example, see the endpoint reference at https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout)
         },
         "amount":-2150
      }
   ],
   "paymentSources":[
      {
         "rail":"lightrail",
         "contactId":"cus_234"
      },
      {
         "rail":"stripe",
         "source":"tok_visa"
      }
   ],
   "pending":false,
   "metadata":null,
   "createdBy":"user-5022fccf827647ee9cfb63b779d62193-TEST"
}
```

### Lightrail UI

Lightrail UI is a javascript library that powers Lightrail's Drop-in Gift Card solution. Lightrail UI makes it easy to embed drop-in components into your page, interact with them, and respond to customer activity.

#### Customization and Advanced UI
The appearance of components is fully customizable. Using Lightrail UI you can also attach event listeners to the components to respond to customer activity.

#### Overview Example
Here's a basic example of how you can add a Card Purchase Dialog to your page using the Lightrail UI library.

```html
<html>
    <head>
        <title>Buy Gift Cards | Rocketship</title>
        
        <!-- Include this script in your page header -->
        <script src="https://embed.lightrail.com/dropin_v2/v2/lightrail-ui.js"></script>
        
        <!-- Now that you've included Lightrail UI, it's time to use it. -->
        <script>
            //Create an instance of LightrailUI using a server generated shopper token
            var shopperToken = "{{shopperToken}}";
            var lightrailUI = new LightrailUI(shopperToken);
            
            //Create instance of the Card Purchase Dialog component with a custom background color defined in the options object
            var cardPurchaseDialog = lightrailUI.components.cardPurchaseDialog({theme_bg_primary: "hotpink"});
            
            //Oops, lets fix that background theme color
            cardPurchaseDialog.setOptions({theme_bg_primary: "#eee"});
            
            //Add a "ready" event handler to enable our launch button
            cardPurchaseDialog.on("ready", function(){
                var launchButton = document.getElementById("launch-button");
                
                launchButton.setAttribute("disabled", "false");
                launchButton.addEventListener("click", function(){
                    cardPurchaseDialog.open();
                });
            });
            
            //This will load/mount the component once the document is finished loading
            cardPurchaseDialog.mount();
        </script>
    </head>
    <body>
        <div class="launch-container">
            <button id="launch-button" disabled="true">Buy a Gift Card!</button>
        </div>
    </body>
</html>
``` 

*More info on [shopper tokens](#drop-in-gift-cards/shopper-tokens).*

*More info on [customization & theming](#lightrail-ui/component-customization).*


#### Lightrail UI Object

The Lightrail UI object has the following properties
* [components](#lightrail-ui/components-overview)
  * [cardPurchaseDialog()](#lightrail-ui/card-purchase-dialog)
  * [codeRedemption()](#lightrail-ui/code-redemption)
* [fetchAccountBalance()](#lightrail-ui/fetchaccountbalance)
* [displayAccountBalance()](#lightrail-ui/displayaccountbalance)


#### Components Overview

The components namespace (`lightrailUI.components`) contains the methods that allow you to create components to use in your page. 

Currently it contains the following components:
* [cardPurchaseDialog()](#lightrail-ui/card-purchase-dialog)
* [codeRedemption()](#lightrail-ui/code-redemption)

Each component within the namespace has a common set of methods that allow you to interact with it and handle updates. These methods are described below.

#### mount
`mount(Element | #id | .classname)`

The mount method adds the component to the page and accepts one param, either an Html Element or string for element lookup using either the `#id`
or `.classname` formats.

Generally `mount()` should be the last method you call to ensure everything is setup properly before the component is added to your page.

---

#### unmount
`unmount()`

Unmount will remove the component from the page and clean up internal references. 
It will not remove event listeners added by calling the `on()` method though, we will be adding the ability to remove those separately in the future. 
This way, it is possible to `unmount()` the component and then call `mount()` at a later time without having to redefine options or events.

**Note:** Unmount should be called before removing or nulling an object if the user isn't navigating away from the page.
This is to ensure that any iframes etc added to the page will be cleaned up.

---

#### on
`on(event, handler)`

Allows you to attach handlers to specific component events.

```javascript
    component.on("ready", function(){
        componentIsReadyDoACustomThing();
    });
```

Events Dispatched by all components:


| Event  | Description | Sample Response |
| ------------- | ------------- | ------------- |
| "mount" | The component has been mounted successfully and is now loading.  | {} |
| "ready" | The component has finished loading and initializing and is ready for use.  | {} |
| "error" | There was an error loading or processing data.   | {status: 401, data: {type: "", message: "Unauthorized"}} |

---

#### getOptions
`getOptions()`

This will return an object with the option values that have been set, as well as the available options. 
You can also see a full list of options for each component below in [Component Customization](#lightrail-ui/component-customization).

```javascript
    var options = component.getOptions();
    console.log(options);
```

---

#### setOptions
`setOptions({})`

Set / replace the components options object. These options aren't automatically passed on to the mounted component
so if you use this, you should re-mount the component by calling `unmount()` and `mount()`.

```javascript
    var options = component.setOptions({theme_bg_primary: "#eee"});
    console.log(options);
```

---


#### Card Purchase Dialog

The Card Purchase Dialog is a dialog that lets users quickly and securely purchase and email gift cards. 

By default it's hidden and can be opened by calling the `open()` method. 
Alternatively, a launch button can be added to your page by adding the correct properties to the options object. *View [customization](#lightrail-ui/gift-card-purchase-theming) for more info.*

```javascript
        var cardPurchaseDialog = lightrailUI.components.cardPurchaseDialog({theme_bg_primary: "#ccc"});

        cardPurchaseDialog.on("ready", function(response){
            cardPurchaseDialog.open();
        });

        cardPurchaseDialog.on("purchaseComplete", function(response){
            startConfetti();
        });
        
        cardPurchaseDialog.on("close", function(response){
           stopConfetti(); 
        });
        
        cardPurchaseDialog.mount();
```

** Card Purchase Events**

| Event  | Description | Sample Response |
| ------------- | ------------- | ------------- |
| "open" | Open the Dialog. | {} |
| "close" | Close the Dialog.  | {} |
| "purchaseComplete" | A Gift Card was purchased and sent to another customer.  | {senderEmail: "user@aol.com", recipientEmail: "user2@aol.com", stripeChargeId:"12345", valueId:"12345"} |
| "purchaseError" | There was an error purchasing | {status: 401, data: {type: "", message: "Unauthorized"}} |


#### Code Redemption

The Code Redemption Component contains a small form that can be embedded in your page to easily and securely handle code redemption.

It was designed to be hosted at the claim url that is setup in the drop-in config so the fullcode can be passed in and auto-populated for the user. 

Once a user redeems a gift code, you can respond by handling the "redemption" event dispatched by the component. 
Alternatively, you can use the "success_btn_cta_label" and "success_btn_cta_href" params to setup a redirect button within the component.

```javascript
        var options = {fullcode: 1235813};
        var codeRedemption = lightrailUI.components.codeRedemption(options);

        codeRedemption.on("redemption", function(response){
            writeConfimationToScreen(response.cardAmountCents, currency);
            updateAccountBalanceDisplay(response.accountBalanceCents, currency);
        });
        
        cardPurchaseDialog.mount("#redemption-container");
```

**Code Redemption Events**

| Event  | Description | Sample Response |
| ------------- | ------------- | ------------- |
| "submit" | The user hit the submit button and the component is attempting to redeem the users code.  | {} |
| "tryAgain" | A previous claim failed and the user hit the Try Again button to re-submit a code.  | {} |
| "redemption" | Successful redemption.  | {cardAmountCents: 1000, accountBalanceCents: 2000, formattedCardAmount: $10, formattedAccountBalance: $20, currency: "USD"} |


#### fetchAccountBalance

LightrailUI(shopperToken).fetchAccountBalance(handler) allows you to fetch the account balance for the user connected with the shoppertoken. *View [customizaion](#lightrail-ui/gift-card-purchase-theming) for more info*

Usage:
```javascript
        lightrailUI.fetchAccountBalance(function(response){
            var balanceInCents = response.balanceInCents;
            var currency = response.currency;
            var formattedBalance = response.formattedBalance;
        });
```

**Note:** We do some very basic formatting to produce the formattedBalance property right now, if you want to support other currency symbols or custom formatting please use the balanceInCents value along with currency to format the value.


#### displayAccountBalance

LightrailUI(shopperToken).displayAccountBalance(Element | id | classname) will write the formattedValue to an element in your page.

ie:
```javascript
    lightrailUI.displayAccountBalance("#account-balance");

    //ie: <p>Balance: <span id="account-balance">$50</span> </p>
```

### Component Customization

This section outlines how to customize **Gift Card Purchase Dialog** and **Code Redemption** Components created by **Lightrail**. 

#### Theme properties

The drop in components are customizable via options passed in when you create your component. Each property should be a string color value or other CSS property like `padding`.

Values can be passed in as follows: 

- **Hex value** - `#FFF`, `#ffffff`, `#000000` (3 or 6 characters plus pound symbol)
- **Named color** - `black`, `white`, `firebrick`, `goldenrod`
- **rgb(a)** - `rgba(255, 255, 255, 0.2)`
- **Padding** - `theme_padding="50px 10px 1em 0"`

Should you have any questions regarding theming, please contact hello@lightrail.com

#### Gift Card Purchase Theming

**Example:**

```javascript
    var options = {
        theme_bg_primary: "#FF0",
        theme_btn_color_gift_amount_hover: "white"
    };

    var cardPurchseDialog = lightrailUI.components.cardPurchaseDialog(options);
    cardPurchseDialog.mount();
```

Below is a comprehensive list of values accepted by the **Card Purchase Dialog Component**. 

1. `theme_bg_primary`
2. `theme_bg_secondary`
3. `theme_color_primary`
4. `theme_color_secondary`
5. `theme_btn_bg_primary`
6. `theme_btn_color_primary`
7. `theme_btn_bg_primary_disabled`
8. `theme_btn_color_primary_disabled`
9. `theme_btn_bg_secondary`
10. `theme_btn_color_secondary`
11. `theme_btn_bg_gift_amount`
12. `theme_btn_color_gift_amount`
13. `theme_btn_bg_gift_amount_hover`
14. `theme_btn_color_gift_amount_hover`
15. `theme_btn_bg_gift_amount_select`
16. `theme_btn_color_gift_amount_select`
17. `theme_btn_bg_back`
18. `theme_btn_color_back`
19. `theme_error_color`
20. `theme_text_color`
21. `theme_input_color`
22. `theme_label_color`
23. `theme_stripe_placeholder_color`
24. `launch_btn_container: "#launch-button-container"`
25. `launch_btn_label: "Give a Gift"`
26. `launch_btn_classname: "rocketship-button__small"`
27. `resend_btn_hidden`: true (defaults to false)

_*All overrides are optional_

#### Gift Card Purchase Theming - 1
![Gift card purchase theming - 1](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/gift-card-purchase-theming-1.png)

#### Gift Card Purchase Theming - 2
![Gift card purchase theming - 2](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/gift-card-purchase-theming-2.png)

#### Gift Card Purchase Theming - 3
![Gift card purchase theming - 3](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/gift-card-purchase-theming-3.png)

#### Gift Card Purchase Theming - 4
![Gift card purchase theming - 4](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/gift-card-purchase-theming-4.png)

**Note:** #24 and #25 are special in the sense that you are able to pass in a label for the button text (#24), and if one isn’t provided, we default to "Buy a Gift Card". #25 accepts a button class name that you already use locally in your site, or you can define one to control the look of the button.

#### Code Redemption Theming

**Example:**

```javascript
    var options = {
        fullcode: "EMAIL_URL_PARAM_VALUE",
        theme_bg_primary: "#FF0",
        theme_btn_color_gift_amount_hover: "white"
    };

    var codeRedemption = lightrailUI.components.codeRedemption(options);
    codeRedemption.mount("#code-redemption-container");
````

Below is a comprehensive list of values accepted by the **Code Redemption Component**.

1. `theme_bg_primary`
2. `theme_padding`
3. `theme_form_align_bottom (default “absolute” to align to the bottom)`
4. `theme_text_color_header`
5. `theme_text_color_subheader`
6. `theme_input_border_color`
7. `theme_input_bg_color`
8. `theme_input_color`
9. `theme_btn_bg_primary`
10. `theme_btn_color_primary`
11. `theme_btn_bg_primary_hover`
12. `theme_btn_color_primary_hover`
13. `theme_btn_bg_secondary`
14. `theme_btn_color_secondary`
15. `theme_btn_bg_secondary_hover`
16. `theme_btn_color_secondary_hover`
17. `success_btn_cta_label: "Start Shopping Today"`
18. `success_btn_cta_href: "landingpage"`
 
![Code redemption theming - 3](https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/code-remption-theming-1.png)

**Note:** #17 provides a label to pass for the completed redemption step. #18 is the the href for where the button will redirect users on redemption completion.

---

## Redemption Rules and Balance Rules

<p class="intro">Redemption Rules and Balance Rules are extra conditions placed on Values that are evaluated during checkout.</p>

Redemption rules determine if a Value can be used and evaluate to true or false. Balance Rules enable more advanced balance behaviour, such as percent off, and evaluate to a number. Rules are typically used for promotions and represent a discount to the customer. Let's look at a few common examples.

**Example 1: $5 off transactions over $100** 

In this case, the Value would simply have a balance of $5 and the Redemption Rule would require that the transaction subtotal is over $100.

Create Value request:
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

This example requires the use of a Balance Rule in combination with a Redemption Rule. The Redemption Rule restricts the Value to apply strictly to an item with productId `red-hat`. The Balance Rule causes the Value to be worth 50% of the item's subtotal.

Create Value request:
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
Balance and Redemption Rules are evaluated for each line item during checkout. Rules operate on a Rule Context which contains the current line item (`currentLineItem`), the transaction totals (`totals`), a list of all of the line items in the transaction (`lineItems`), the transaction metadata (`metadata`), and the current Value being applied (`value`) - Value's are applied one by one during checkout.

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
        "balanceChange": "number"
    }
}
```

You can think of the Rule Context being created as a simple map which the Rules evaluate on. 

### Examples Continued
**50% off everything**

Create Value request:
```json
{
    "id": "example",
    "currency": "USD",
    "balanceRule": {
         "rule": "currentLineItem.lineTotal.subtotal * 0.5",
         "explanation": "50% off line item's subtotal."
     },
    "discount": true
}
```

**Up to $5 off order, limiting to one discount per line item**

Create Value request:
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
Values are applied to checkout item by item. The property `value.balanceChange` keeps track of the total amount paid by the Value as it's applied to each item. Note, it is a negative since it represents balance change. Also, to enforce that at most one promotion is applied to each line item the redemptionRule `"currentLineItem.lineTotal.discount == 0"` must be set on all promotions.  

**25% off transactions over $100 and limited to 1 promotion per item**
```json
{
    "id": "example",
    "currency": "USD",
    "balance": 500,
    "redemptionRule": {
        "rule": "totals.subtotal >= 10000 && currentLineItem.lineTotal.discount == 0",
        "explanation": "Applies to orders over $100. Limited to 1 discount per item."
    },
    "balanceRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.25",
        "explanation": "25% off item's subtotal."
    },
    "discount": true
}
```

### Rule Syntax
For more information on rule syntax please see [Rule Sytnax](https://github.com/Giftbit/Lightrail-API-V2-Docs/blob/master/feature-deep-dive/rule-syntax.md). 
