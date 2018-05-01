# Welcome
Welcome to Lightrail V2. 

Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.
The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order.
The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder on the order.
Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

## Example of Checkout with Lightrail
Suppose a customer has loaded $20 onto their account on your site. Also, imagine you're running a Facebook ad campaign for 20% all orders that use the promotion code `EASYMONEY`.

Now, perhaps that customer of yours wants to buy a $30 product. Using the `/orders` endpoint it is easy to complete this entire transaction, in a single request.

**Request**: `POST /transactions/orders`
```json
{
    "transactionId": "unique-id-123",
    "currency": "USD",
    "lineItems": [
        {
            "unitPrice": 3000,
            "taxRate": 0.05,
        }
    ],
    "sources": [
        {
            "rail": "lightrail",
            "customerId": "cus_123"
        },
        {
            "rail": "lightrail",
            "code": "EASYMONEY"
        },
        {
            "rail": "stripe",
            "cardToken": "tok_12345"
        }
    ]
}
```       
 
**Response**: `200 OK`
```json
{
    "transactionId": "unique-id-123",
    "currency": "USD",
    "totals": {
        "subtotal": 3000,
        "tax": 120,
        "discount": 600,
        "payable": 2520
    },
    "lineItems": [
        {
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
            "valueStoreId": "easymoney-promo",
            "amount": -600, 
            "discount": true
        },
        {
            "rail": "lightrail",
            "valueStoreId": "cus_123-account",
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

As a result of this transaction, the promotion was applied, the customer's account has been charged $20, and finally their credit card was charged the remaining $5.20.
As you can see, Lightrail handles the complexity of applying the promotion, calcuating tax and charging the various payment sources, all within a single transaction. 

## Core Concepts
Value, whether it is a gift card with a balance or a promotional offer for a discount, are stored as `ValueStores`.   
 
The Lightrail system revolves around two core concepts:

**Programs** allow you to specify how value is made available to your customers, whether that means running a "25% off everything this weekend" site-promotion, selectively giving your top customers extra loyalty points, or selling gift cards. 

**Value Stores** are created based on a particular Program and represent the actual value available to your customers, from unique coupon codes to reloadable accounts. 

Once you've created a Program, you can use it to generate as many Value Stores as you like. This means you can set the rules once for how your customers will interact with a particular kind of value, and then let the actual value creation and distribution happen independently, however it fits best with your existing marketing flow. 

For example, you can create a Program for giving first-time customers 10 loyalty points when they sign up. Then you can add some simple logic to automatically generate a new Value Store from this Program every time a customer joins, so they can immediately start collecting points.  

You can attach value directly to **Customers** in the Lightrail system. This is common for things like accounts and registered gift cards, and can also be used for personalized promotions and discounts. Customers records in Lightrail are linked to records in your existing system through a shared identifier, so you can easily track spending behaviour. 

See our examples below to get started with gift cards, account credit, or promotions. 
