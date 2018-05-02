# Welcome to Lightrail V2
Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.

The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order. The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder of the order. Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

### Checkout with Lightrail
Let's look at an example. 

Suppose you're running an ad campaign for 20% all orders that use the promotion code "EASYMONEY". 
Perhaps a customer who has $20 account credits visits your store, enters the promotion code, and wants to purchase a $30 product. Using the `orders` endpoint it is easy to complete the payment for this entire transaction in a single request.

**Request**: `POST /transactions/orders`
```json
{
    "transactionId": "unique-id-123",
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
            "customerId": "cus_123"
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

- `"customerId": "cus_123"`: uses any value associated with that customer in Lightrail. 
- `"code: "EASYMONEY"`: represents the promotion code entered during checkout.
- `"cardToken": "tok_12345"`: tokenized card using Stripe elements.  
 
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

As a result of this transaction, the promotion was applied, the customer's account has been charged $20, and finally, their credit card was charged the remaining $5.20.
As you can see, Lightrail handles the complexity of applying the promotion, calculating tax and charging the various payment sources, all within a single transaction. 
Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 

### How Lightrail Stores Value: ValueStores
Value stored in Lightrail, whether it represents a gift card or a promotional offer for a discount, are stored as `ValueStores`.   
Different types of value are represented by modifying the properties of `ValueStores`. `ValueStores` are created using `Programs`. 

#### Programs
`Programs` define default properties for `ValueStores`. 
Whether running an advertised promotion code, selectively giving your top customers extra loyalty points, or selling gift cards the `ValueStores` are issued from `Programs`.

`Programs` also define how the `ValueStores` are accessed. Whether they are attached to a customer or referenced via a secure or public code, this is how the `ValueStores` is referenced in the `sources` property for checkout. For example:
```json

    [
        {
            "rail": "lightrail",
            "customerId": "cus_123"
        },
        {
            "rail": "lightrail",
            "secureCode": "ABCD-EFGH-IJKLM"
        },
        {
            "rail": "lightrail",
            "publicCode": "EASYMONEY"
        }
    ]

```

Lightrail makes it very easy to associate many types of value directly with your customers. This allows you to incentivize your customers through personalized promotions and loyalty programs, all of which work together in a seamless checkout experience. 

### Getting Started
See our examples below to get started with:

- [Gift cards](https://localhost:8181/docs/#gift-cards/gift-cards)
- [Accounts and loyalty points](https://localhost:8181/docs/#accounts/accounts-and-points)
- [Promotions](https://localhost:8181/docs/#discounts/promotions) 
- [Checkout](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order)
 
[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
