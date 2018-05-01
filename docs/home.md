# Welcome
Welcome to Lightrail V2. 

Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.

The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order. The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder on the order. Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

## Checkout with Lightrail
Let's look at an example. 

Suppose you're running an ad campaign for 20% all orders that use the promotion code `EASYMONEY`. 
Perhaps a customer who has $20 account credits visits your store, enters the promotion code, and wants to purchase a $30 product. Using the `/orders` endpoint it is easy to complete the payment for this entire transaction in a single request.

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

You can see lineItems contain the basic information required to represent this purchase. Also, note the sources property in the request. 
It includes two Lightrail sources. The source `"customerId": "cus_123"` will us any value associated with that customer in Lightrail and the other is the `EASYMOENY` promotion code. 
The customer has also entered their credit card to pay for any remaining balances and this is supplied as a tokenized card from Stripe.  
 
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
Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 

## How Lightrail Stores Value: ValueStores
Value stored in Lightrail, whether it represents a gift card or a promotional offer for a discount, are stored as `ValueStores`.   
Different types of value are represented by modifying the properties of `ValueStores`. `ValueStores` are created using `Programs`. 

### Programs
Programs define default properties for the `ValueStores` issued from them. 
Whether running a "25% off everything this weekend" site-promotion, selectively giving your top customers extra loyalty points, or selling gift cards these `ValueStores` are issued from Programs created to represent the type of value they represent. 
Programs also define how the ValueStore is referenced. There are three types:
- `secureCode` - a unique, unguessable code (used for gift cards or unique promotion codes)
- `publicCode` - a code you supply which will be distributed publicly (ie, `EASYMONEY`)
- `customerId` - attached to a customer

### Customers
You can attach value directly to **Customers** in the Lightrail system. This is common for things like accounts and registered gift cards, and can also be used for personalized promotions and discounts. Customers records in Lightrail are linked to records in your existing system through a shared identifier, so you can easily track spending behaviour. 

## Getting Started
See our examples below to get started with gift cards, account credit, or promotions. 
