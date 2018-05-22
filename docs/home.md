# Welcome to Lightrail V2
Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.

The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order. The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder of the order. Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

### Checkout with Lightrail
Checkout is done by creating an order through the `/transactions/orders` endpoint. Let's look at an example. 

Suppose you're running an ad campaign for 20% all orders that use the promotion code "EASYMONEY". 
Perhaps a customer who has $20 account credits visits your store, enters the promotion code, and wants to purchase a $30 product. Using the `orders` endpoint it is easy to complete the payment for this entire transaction in a single request.

**Request**: `POST /transactions/orders`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05,
        }
    ],
    "sources": [
        {
            "rail": "lightrail",
            "contactId": "cus_123"
        },
        {
            "rail": "lightrail",
            "publicCode": "EASYMONEY"
        },
        {
            "rail": "stripe",
            "cardToken": "tok_12345"
        }
    ]
}
```       

You can see `lineItems` contains the basic shopping cart information. 

Also, note the `sources` property in the request. It includes three sources, two of which are value stored in Lightrail, the other is a tokenized card from Stripe.

- `"contactId": "cus_123"`: uses any value associated with that customer in Lightrail. 
- `"code: "EASYMONEY"`: represents the promotion code entered during checkout.
- `"cardToken": "tok_12345"`: tokenized card using Stripe elements.  
 
**Response**: `200 OK`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "totals": {
        "subtotal": 3000,
        "tax": 120,
        "discount": 600,
        "payable": 2520
    },
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05,
            "lineTotal": {
                "price": 3000,
                "discount": 600,
                "taxable": 2400,
                "tax": 120,
                "payable": 2520
            }
        }
    ],
    "steps": [
        {
            "rail": "lightrail",
            "id": "easymoney-promo",
            "amount": -600, 
            "discount": true
        },
        {
            "rail": "lightrail",
            "id": "cus_123-account",
            "amount": -2000, 
            "discount": false
        },
        {
            "rail": "stripe",
            "chargeId": "ch_abcde",
            "amount": -520
        }
    ]
} 
``` 

As a result of this transaction, the promotion was applied, the customer's account has been charged $20, and finally, their credit card was charged the remaining $5.20.
As you can see, Lightrail handles the complexity of applying the promotion, calculating tax and charging the various payment sources, all within a single transaction. 
Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 

### Orders Payment Sources
The `sources` property in the `orders` endpoint contains a list of payment sources. 
A source consists of an object with a `rail` identifier along with some additional data. There are currently two payment rails: `lightrail` and `stripe`. Support for more credit card processors such as BrainTree and Square is coming soon!

#### Rail: Lightrail
A source with `"rail": "lightrail"` means the value is stored in Lightrail. 

##### How Lightrail Stores Value: `Values`
Value stored in Lightrail, whether it represents a gift card, account credits or points, or a promotional offer for a discount, are stored as `Values`.   
Different types of value are represented by modifying the properties of `Values`.

The way `Values` are passed into the `sources` property of the `orders` resource depends on what type of value it is.

##### `contactId`
Some value may be attached directly to a `Customer` (see the [create customer documentation](https://lightrailapi.docs.apiary.io/#reference/0/customers/create-customer) for details on creating `Customers`).
For example account credits or promotions are commonly attached directly to a `Customer`. 

Usage:
```json
{
    "rail": "lightrail",
    "contactId": "cus_123"
}
```     

This will cause the `orders` endpoint to consider all `Values` associated with that customer and will resolve the complexity of applying them to the order in the correct order. 

##### `secureCode`       
A `secureCode` is a unique-unguessable code and is most commonly used by gift cards and unique promotion codes. 

Usage:
```json
{
    "rail": "lightrail",
    "secureCode": "UNIQUE-UNGUESSABLE-CODE"
}
``` 

##### `publicCode`
A `publicCode` is usually a human-readable code like `EASYMONEY` which would be displayed through various channels (ads, etc) to many users.

Usage:
```json
{
    "rail": "lightrail",
    "publicCode": "EASYMONEY"
}
```  

#### Rail: Stripe
The `"rail": "stripe"` is used when payment from a credit card is required for the `order`. 
You must OAuth your Stripe account with Lightrail so that Lightrail can charge the credit card on your behalf using [Stripe Connect](https://stripe.com/connect).

Usage:
```json
{
    "rail": "stripe",
    "cardToken": "tok_12345"
}
```  

The `cardToken` is a tokenized credit card, created from Stripe Elements.

### Getting Started
See our examples below to get started with:

- [Gift cards](https://localhost:8181/docs/#gift-cards/gift-cards)
- [Accounts and loyalty points](https://localhost:8181/docs/#accounts/accounts-and-points)
- [Promotions](https://localhost:8181/docs/#discounts/promotions) 
- [Checkout](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order)
 
[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
