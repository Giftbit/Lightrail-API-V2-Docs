# Drop-in Gift Cards  

## Quickstart
Lightrail's Drop-in Gift Card solution makes it easy to offer gift cards to your customers. 
Integrating into Lightrail is an easy process that can be completed in no more than a few hours.

The solution is component based, using elements generated from our client-side library Lightrail UI.
When your customers receive a gift card, they can easily redeem and apply the gift card value to their account.
Your checkout process requires a simple update to accept payment from your customer accounts.

### Getting Started
[Sign up](https://www.lightrail.com/app/#/register) for a Lightrail account. 

Note this quickstart assumes you are using Stripe to process payments: if you are using another payment processor and want to build a custom solution, please [contact us](mailto:hello@lightrail.com).

You will need configure a few settings to get started. 

If at any point you want to see a working example of the entire Drop-in Gift Card solution, check out our [sample app](https://github.com/Giftbit/stripe-integration-sample-webapp).

### Step 0: Authentication & Configuration
Create your Lightrail API key from the [Integrations](https://www.lightrail.com/app/#/account/api) section of your Lightrail account. 
Your Lightrail API key is used to complete the server side requests from checkout, and also to generate Shopper Tokens which are passed into the Lightrail UI library for component authentication.  

Note: For development, toggle your Lightrail account to test mode, this will allow you to use [Stripe's test credit cards](https://stripe.com/docs/testing#cards).

Also, before going live or to see test Stripe charges show up in your Stripe account, you'll need to connect your Stripe account on your account's [Integrations](https://www.lightrail.com/app/#/account/api) page. 

#### Shared Secret
Set the shared secret that Lightrail will use to verify calls made using shopper tokens (see below). This step is usually done in the web app (coming soon!) but currently must be done through the API:

`PUT https://api.lightrail.com/v1/storage/jwtSecret`

The request body will simply be a string, which will be stored as your shared secret: 

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
    "preTax": false
}
```

See the [Programs endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/programs/create-program) for details on what parameters can be set.

#### Drop-in Configuration
This step is usually done in the web app (coming soon!) but currently must be done through the API. This example uses the fictional company "Rocketship" to represent your company. 

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

Shopper Tokens must be generated server side, for example using our [Node (Typescript/Javascript) Client Library](https://github.com/Giftbit/lightrail-client-javascript). (Coming soon: client libraries in Java, Ruby, PHP, and C#.)

The current version of the Lightrail Javascript Client is under the alpha tag: `npm install lightrail-client@alpha`

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

### Step 1: Selling Gift Cards
The Gift Card Purchase Component allows your customers to purchase gift cards from your site. 
Lightrail powers the entire gift card purchase and delivery flow. 

![Gift Card Purchase Component](https://raw.githubusercontent.com/Giftbit/Lightrail-API-Docs/master/docs/assets/purchase-widget.png)

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

![Purchase Using Saved Credit Card](https://raw.githubusercontent.com/Giftbit/Lightrail-API-Docs/master/docs/assets/saved-credit-cards.png)

To enable this, you need to **provide the customer ID from Stripe** when you generate the Shopper Token. 

How to pass in the `stripeCustomerId` during Shopper Token generation to enable the use of saved credit cards:
```javascript
const options = {
    metadata: {stripeCustomerId: "cus_abcd1234"}
};
const shopperToken = lightrail.generateShopperToken("cust_123abc", options);

```

### Step 2: Redeeming Gift Cards

The Gift Card Redemption Component enables your customers to redeem gift cards to their account.

<br/>

![Gift Card Redemption Component](https://raw.githubusercontent.com/Giftbit/Lightrail-API-Docs/master/docs/assets/redemption-widget.png)

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

### Step 3: Checkout

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

##### Simulate a Charge / Balance Check
When your customer chooses to use their account credit, you need to see whether the account can cover the requested amount and whether the customer has any other attached value that can be used for the transaction. Our API makes it easy to post a split-tender charge where part of the transaction is covered by a Lightrail account, and part is covered by Stripe.

The following is an example of the call that must be made by your simulation endpoint.

`POST https://api.lightrail.com/v2/transactions/checkout`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05
        }
    ],
    "sources": [
        {
            "rail": "lightrail",
            "contactId": "cust_123abc"
        },
        {
            "rail": "stripe",
            "source": "tok_12345"
        }
    ],
    "simulate": true
}
```

The `lineItems` array contains the details of the items in the order.

The `sources` array specifies the payment sources: in this case, the Contact who received the gift card and attached it to their account, and a tokenized credit card from Stripe to cover any remaining balance. Specifying `"contactId": "cust_123abc"` will use any value associated with that customer in Lightrail.

The `simulate` flag tells Lightrail to calculate the amounts that each source can cover without actually charging them. Stripe is not called; it is assumed that any remaining amount not covered by Lightrail will be successfully charged to the credit card.

##### Post the Charge
To complete the transaction, simply send the same request again without the `simulate` flag (or with `"simulate": false`).

The following is an example of the call that must be made by your charge endpoint. 

`POST https://api.lightrail.com/v2/transactions/checkout`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05
        }
    ],
    "sources": [
        {
            "rail": "lightrail",
            "contactId": "cust_123abc"
        },
        {
            "rail": "stripe",
            "source": "tok_12345"
        }
    ]
}
```

At this point, the charge has been posted to both Lightrail and Stripe. You can handle post-checkout flow as you otherwise would. The response will include the Lightrail transaction details as well as the full Stripe charge response: 

`200 OK`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "totals": {
        "subtotal": 3000,
        "tax": 150,
        "discount": 0,
        "payable": 3150,
        "remainder": 0
    },
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05,
            "quantity": 1,
            "lineTotal": {
                "subtotal": 3000,
                "taxable": 3000,
                "discount": 0,
                "tax": 150,
                "payable": 3150
            }
        }
    ],
    "steps": [
        {
            "rail": "lightrail",
            "valueId": "cust_123abc-account",
            "contactId": "cust_123abc",
            "code": null,
            "balanceBefore": 4500, 
            "balanceAfter": 2500, 
            "balanceChange": -2000, 
            "discount": false
        },
        {
            "rail": "stripe",
            "chargeId": "ch_abcde",
            "amount": -520,
            "charge": {
                "id": "ch_abcde",
                // ...full Stripe charge response: for an example, see the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout)
            }
        }
    ],
    "paymentSources": [
        {
            "rail": "lightrail",
            "contactId": "cus_123"
        },
        {
            "rail": "stripe",
            "source": "tok_12345"
        }
    ]
} 
```

## Customization and Advanced UI
The appearance of components is fully customizable. Using Lightrail UI you can also attach event listeners to the components to respond to customer activity. For more information on this usage, see [Lightrail UI](#lightrail-ui).

## Support
Contact us any time at [hello@lightrail.com](mailto:hello@lightrail.com) —- we are here to help.