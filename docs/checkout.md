# Checkout Integration

<p class="intro">The Checkout endpoint unifies payment allowing you to charge multiple sources, including credit cards, all within a single step.</p>

Accepting multiple payment methods is complicated because it requires logic to ensure each payment source is charged in the correct order, for the right amount, and with transactional consistency. The Checkout Endpoint calculates the subtotal, applies any relevant Customer Value (eg. promotion, gift card), and charges the user’s credit card, if applicable, all in a single request. 

### Where does the Checkout API fit in? 

When a customer of yours wants to make a purchase, you need to accept payment. It’s at this step of that you would make a Checkout API Request sending the items they are purchasing along with any payment methods for the purchase. Checkout can also be used to simulate a purchase, allowing you to display to your customer what Customer Value applies to their transaction before you actually process the transaction. 

### How does the Checkout API work? 

Checkout can be broken into two primary components:

- line items - the customer’s shopping cart
- payment sources - the customer’s methods of payment

#### Line Items
Line items represent a shopping cart and contain all of the information required for Lightrail to calculate the transaction. Below is an example shopping cart with two line items. Note, by including the `taxRate`, Lightrail will automatically calculate and charge for tax that must be collected.

    "lineItems":[
          {
             "productId":"shoes-pid-133241",
             "unitPrice":4999,
             "taxRate":0.05
          },
          {
             "productId":"hat-pid-43545",
             "unitPrice":1799,
             "taxRate":0.05
          }
    ]

#### Payment Sources
The `sources` property in the `checkout` endpoint contains a list of payment sources. 
A `source` consists of an object with a `rail` identifier along with some additional data. Rail refers to “payment rail” and is used to differentiate where a particular source must be charged. 

Promotions, gift cards, and loyalty points you’ve created within Lightrail will all be accessed via `"rail``"``:` `"``lightrail``"`. Credit card processing is done via Stripe through `"``rail``"``:` `"``stripe``"`. There’s one more `"``rail``"``:` `"``internal``"` which means internal to your system. It means you’re tracking the collection of funds as it is outside of Lightrail and Stripe. For example, this allows you to migrate off a legacy gift card system you might have.

See the [full endpoint reference](https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout) for details. 

#### Rail: Lightrail
With `"rail":"lightrail"` you’ll supply an identifier of an object in Lightrail. The following is an example of supplying a Lightrail payment source.

    { 
        "rail": "lightrail",
        "contactId": "contact-123456"
    }

There are 3 possible variations for the Lightrail rail: 

- contactId: The ID of a Contact. This will cause all Values attached to that Contact to be considered for the Checkout Transaction.
- valueId: The ID of a Value. Uniquely identifies a single value in Lightrail.
- code: The code of a Value in Lightrail. Often represents a gift card code or some type of promotion code that the customer enters during checkout. 

#### Rail: Stripe
The Stripe rail is used when payment from a credit card is required for the transaction. 
You must OAuth your Stripe account with Lightrail so that Lightrail can charge the credit card on your behalf using [Stripe Connect](https://stripe.com/connect).

Usage:

    {
        "rail": "stripe",
        "source": "tok_12345"
    }

The `source` is a tokenized credit card, created from Stripe Elements.

Checkout Example

Suppose a Customer has a promotion attached to their Contact. The remainder they will pay via credit card. The following is an example of the Checkout Request and Response. 
Request: `POST /transactions/checkout`

    {
       "id":"sample-transaction-123",
       "currency":"USD",
       "sources":[
          {
             "rail":"lightrail",
             "contactId":"sample-contact-id-123"
          },
          {
             "rail":"stripe",
             "source":"tok_visa"
          }
       ],
       "lineItems":[
          {
             "productId":"shoes-pid-133241",
             "unitPrice":4999,
             "taxRate":0.05
          },
          {
             "productId":"hat-pid-43545",
             "unitPrice":1799,
             "taxRate":0.05
          }
       ],
       "simulate":true
    }

Response:

    {
       "id":"sample-transaction-123",
       "transactionType":"checkout",
       "currency":"USD",
       "createdDate":"2019-12-20T21:34:13.000Z",
       "tax":{
          "roundingMode":"HALF_EVEN"
       },
       "paymentSources":[
          {
             "rail":"lightrail",
             "contactId":"sample-contact-id-123"
          },
          {
             "rail":"stripe",
             "source":"tok_visa"
          }
       ],
       "totals":{
          "subtotal":6798,
          "tax":272,
          "discount":1360,
          "payable":5710,
          "remainder":0,
          "forgiven":0,
          "discountLightrail":1360,
          "paidLightrail":0,
          "paidStripe":5710,
          "paidInternal":0
       },
       "lineItems":[
          {
             "productId":"shoes-pid-133241",
             "unitPrice":4999,
             "taxRate":0.05,
             "quantity":1,
             "lineTotal":{
                "subtotal":4999,
                "taxable":3999,
                "tax":200,
                "discount":1000,
                "remainder":0,
                "payable":4199
             }
          },
          {
             "productId":"hat-pid-43545",
             "unitPrice":1799,
             "taxRate":0.05,
             "quantity":1,
             "lineTotal":{
                "subtotal":1799,
                "taxable":1439,
                "tax":72,
                "discount":360,
                "remainder":0,
                "payable":1511
             }
          }
       ],
       "steps":[
          {
             "rail":"lightrail",
             "valueId":"sample-value-id-123",
             "contactId":"sample-contact-id-123",
             "code":null,
             "balanceBefore":null,
             "balanceChange":-1360,
             "balanceAfter":null,
             "usesRemainingBefore":1,
             "usesRemainingChange":-1,
             "usesRemainingAfter":0
          },
          {
             "rail":"stripe",
             "chargeId":null,
             "charge":null,
             "amount":-5710
          }
       ],
       "pending":false,
       "metadata":null,
       "createdBy":"user-5022fccf827647ee9cfb63b779d62193-TEST"
    }

As you can see, Lightrail handles the complexity of applying the promotion, calculating tax and charging the various payment sources. In this example the customer was discounted $13.60 and paid the remaining $57.60 via credit card. Lightrail returns a summary and detailed information of the transaction so that it's easy to display a breakdown to the customer. 




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
         "charge":  {
            // ...full Stripe charge response: for an example, see the endpoint reference at https://lightrailapi.docs.apiary.io/#reference/0/transactions/checkout)
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
 

[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
