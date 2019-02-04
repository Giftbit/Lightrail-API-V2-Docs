# Welcome to Lightrail
Lightrail makes it easy to run promotions, manage customer loyalty points, create gift cards, and collect payment all in one unified checkout solution.

The checkout solution allows you to submit a customer's shopping cart along with a list of sources to pay for the order. The payment sources can be value held by that customer in Lightrail along with external value, such as a credit card, to pay for any remainder of the order. Lightrail takes care of the complexity of this split-tender transaction, ensuring value in Lightrail and external credit cards are charged the correct amount.

### Checkout with Lightrail
Checkout transactions use the `/transactions/checkout` endpoint. Let's look at an example. 

For example, let's say you're running a Black Friday ad campaign for 20% off all orders that use the promotion code "BLACKFRIDAY". 
Perhaps a customer who has attached a $10 gift card to their account visits your store, enters the promotion code, and wants to purchase a $100 product. Using the `/transactions/checkout` endpoint it is easy to complete the payment for this entire transaction in a single request.

**Request**: `POST /transactions/checkout`
```json
{
   "id":"example-checkout-id-123",
   "currency":"USD",
   "lineItems":[
      {
         "productId":"pid_shoes2123",
         "unitPrice":10000,
         "taxRate":0.05,
         "quantity":1
      }
   ],
   "sources":[
      {
         "rail":"lightrail",
         "contactId":"cus_123"
      },
      {
         "rail":"lightrail",
         "code":"BLACKFRIDAY"
      },
      {
         "rail":"stripe",
         "source":"tok_visa"
      }
   ]
}
```       

The `lineItems` array contains the details of the items in the order. 

Also, note the `sources` property in the request. It includes three sources, two of which are Values stored in Lightrail, the other is a tokenized card from Stripe.

- `"contactId": "cus_123"`: uses any value associated with that customer in Lightrail. 
- `"code: "BLACKFRIDAY"`: represents the promotion code entered during checkout.
- `"source": "tok_12345"`: tokenized card using Stripe elements.  
 
**Response**: `201 OK`
```json
{
   "id":"example-checkout-id-123",
   "transactionType":"checkout",
   "currency":"USD",
   "createdDate":"2018-01-31T21:15:17.000Z",
   "tax":{
      "roundingMode":"HALF_EVEN"
   },
   "totals":{
      "subtotal":10000,
      "tax":400,
      "discount":2000,
      "payable":8400,
      "remainder":0,
      "discountLightrail":2000,
      "paidLightrail":1000,
      "paidStripe":7400,
      "paidInternal":0
   },
   "lineItems":[
      {
         "productId":"pid_shoes2123",
         "unitPrice":10000,
         "taxRate":0.05,
         "quantity":1,
         "lineTotal":{
            "subtotal":10000,
            "taxable":8000,
            "tax":400,
            "discount":2000,
            "remainder":0,
            "payable":8400
         }
      }
   ],
   "steps":[
      {
         "rail":"lightrail",
         "valueId":"BlackFriday Promo",
         "contactId":null,
         "code":"BLACKFRIDAY",
         "balanceBefore":null,
         "balanceAfter":null,
         "balanceChange":-2000,
         "usesRemainingBefore":null,
         "usesRemainingAfter":null,
         "usesRemainingChange":null
      },
      {
         "rail":"lightrail",
         "valueId":"$10 GC",
         "contactId":"cus_123",
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
         "chargeId":"ch_1DymsVCM9MOvFvZK11KdlGZr",
         "charge":{
            // ...full Stripe charge response: for an example, see the [endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout)
         },
         "amount":-7400
      }
   ],
   "paymentSources":[
      {
         "rail":"lightrail",
         "contactId":"cus_123"
      },
      {
         "rail":"lightrail",
         "code":"BLACKFRIDAY"
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

As a result of this transaction, the promotion was applied saving the customer $20, the customer's gift card attached to their account was charged $10, and finally their credit card was charged the remaining $74.
As you can see, Lightrail handles the complexity of applying the promotion, calculating tax and charging the various payment sources, all within a single transaction. 
Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 

### Checkout Payment Sources
The `sources` property in the `checkout` endpoint contains a list of payment sources. 
A `source` consists of an object with a `rail` identifier along with some additional data. See the [full endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for details. 

#### Rail: Lightrail
A source with `"rail": "lightrail"` means the value is stored in Lightrail. 

##### How Lightrail Stores Value: `Values`
Whether representing a promotional offer, loyalty points or a gift card, value in Lightrail is stored as a `Value`.   
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

- [Promotions](https://www.lightrail.com/docs/#promotions/getting-started-with-promotions)
- [Gift cards](https://www.lightrail.com/docs/#drop-in-gift-cards/drop-in-gift-cards)
- [Accounts and loyalty points](https://www.lightrail.com/docs/#accounts/accounts-and-points)
- [Checkout](https://lightrailapi.docs.apiary.io/#reference/0/transactions/process-an-order)
 
[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
