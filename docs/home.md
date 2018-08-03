# Welcome to Lightrail V2
Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.

The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order. The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder of the order. Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

### Checkout with Lightrail
Checkout transactions use the `/transactions/checkout` endpoint. Let's look at an example. 

Suppose you're running an ad campaign for 20% off all orders that use the promotion code "EASYMONEY". 
Perhaps a customer who has $20 account credits visits your store, enters the promotion code, and wants to purchase a $30 product. Using the `orders` endpoint it is easy to complete the payment for this entire transaction in a single request.

**Request**: `POST /transactions/checkout`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "lineItems": [
        {
            "productId": "pid_1",
            "unitPrice": 3000,
            "taxRate": 0.05,
            "quantity": 1
        }
    ],
    "sources": [
        {
            "rail": "lightrail",
            "contactId": "cus_123"
        },
        {
            "rail": "lightrail",
            "code": "EASYMONEY"
        },
        {
            "rail": "stripe",
            "source": "tok_12345"
        }
    ]
}
```       

The `lineItems` array contains the details of the items in the order. 

Also, note the `sources` property in the request. It includes three sources, two of which are Values stored in Lightrail, the other is a tokenized card from Stripe.

- `"contactId": "cus_123"`: uses any value associated with that customer in Lightrail. 
- `"code: "EASYMONEY"`: represents the promotion code entered during checkout.
- `"source": "tok_12345"`: tokenized card using Stripe elements.  
 
**Response**: `200 OK`
```json
{
    "id": "unique-id-123",
    "currency": "USD",
    "totals": {
        "subtotal": 3000,
        "tax": 120,
        "discount": 600,
        "payable": 2520,
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
                "taxable": 2400,
                "discount": 600,
                "tax": 120,
                "payable": 2520
            }
        }
    ],
    "steps": [
        {
            "rail": "lightrail",
            "valueId": "easymoney-promo",
            "code": "EASYMONEY",
            "contactId": null,
            "balanceBefore": 0,
            "balanceAfter": 0,
            "balanceChange": -600, 
            "discount": true
        },
        {
            "rail": "lightrail",
            "valueId": "cus_123-account",
            "contactId": "cus_123",
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
            "rail": "lightrail",
            "code": "EASYMONEY"
        },
        {
            "rail": "stripe",
            "source": "tok_12345"
        }
    ]
} 
``` 

As a result of this transaction, the promotion was applied, the customer's account has been charged $20, and finally, their credit card was charged the remaining $5.20.
As you can see, Lightrail handles the complexity of applying the promotion, calculating tax and charging the various payment sources, all within a single transaction. 
Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 

### Checkout Payment Sources
The `sources` property in the `checkout` endpoint contains a list of payment sources. 
A `source` consists of an object with a `rail` identifier along with some additional data. See the [full endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for details. 

#### Rail: Lightrail
A source with `"rail": "lightrail"` means the value is stored in Lightrail. 

##### How Lightrail Stores Value: `Values`
Value stored in Lightrail, whether it represents a gift card, account credits or points, or a promotional offer for a discount, are stored as `Values`.   
Different types of value are represented by modifying the properties of `Values`.

The way `Values` are passed into the `sources` property of the `checkout` endpoint depends on what type of value it is.

##### `contactId`
Some value may be attached directly to a `Contact` (see the [create Contact documentation](https://lightrailapi.docs.apiary.io/#reference/0/contacts/create-a-contact) for details on creating `Contacts`).
For example account credits or promotions are commonly attached directly to a `Contact`. 

Usage:
```json
{
    "rail": "lightrail",
    "contactId": "cus_123"
}
```     

This will cause the `checkout` endpoint to consider all `Values` attached to that customer and will resolve the complexity of charging them in the correct order. 

##### `code`
A Value can be identified by a `code`. A `code` can be secret and meant for use by one person (commonly used for gift cards and unique promotion codes), or it can be generic - a human-readable code such as "EASYMONEY" that can be shared publicly through many channels (ads, flyers, etc). 

Usage:

Secret codes and generic codes are passed in the same way in the request. Generic codes will be displayed in full in the response, and only the last four characters of a secret code will be returned. 

```json
{
    "rail": "lightrail",
    "code": "UNIQUE-UNGUESSABLE-CODE"
}
```

Response: 
```json
{
    "paymentSources": [
        {
            "rail": "lightrail",
            "code": "...CODE"
        }
    ]
}
```


#### Rail: Stripe
The `"rail": "stripe"` is used when payment from a credit card is required for the transaction. 
You must OAuth your Stripe account with Lightrail so that Lightrail can charge the credit card on your behalf using [Stripe Connect](https://stripe.com/connect).

Usage:
```json
{
    "rail": "stripe",
    "source": "tok_12345"
}
```  

The `source` is a tokenized credit card, created from Stripe Elements.

### Getting Started
See our examples below to get started with:

- [Gift cards](https://www.lightrail.com/docs/#gift-cards/gift-cards)
- [Accounts and loyalty points](https://www.lightrail.com/docs/#accounts/accounts-and-points)
- [Promotions](https://www.lightrail.com/docs/#discounts/promotions)
- [Checkout](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order)
 
[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
