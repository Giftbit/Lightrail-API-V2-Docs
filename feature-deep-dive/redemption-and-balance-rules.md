# Redemption Rules and Balance Rules
Redemption Rules and Balance Rules are extra conditions placed on Values that are evaluated during checkout. A Value's Redemption Rule evaluates to true or false and determines if that Value can be applied. This does not affect whether other Values can be used since each Value's own Redemption Rule determines whether or not it can be applied. Balance Rules enable more advanced balance behaviour, such as percent off, and evaluate to a number in the context of a particular Transaction. Balance Rules and Redemption Rules are typically used for promotions that represent a discount to the customer.   

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

## How Rules Work
Values are applied one by one to each line item in turn during checkout. Balance Rules and Redemption Rules are evaluated for each line item. Rules operate on a rule context, described below. Redemption Rules only determine whether the Value they're set on can be applied and do not affect whether other Values can be applied. 

### Rule Context 
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

## Limiting How Many Promotions Can Be Applied to Checkout 
By default, any number of Values can be applied to a checkout Transaction. If you want to limit promotions (Values with discount: true) to one promotion per Transaction or one per line item you must include the corresponding Redemption Rule on all of your promotions. Remember that each Value's applicability is determined by its own Redemption Rule and Balance Rule and not affected by rules set on other Values.

### Limiting to One Promotion per Checkout
If you want to limit promotions (Values with `discount: true`) to one promotion per Transaction you must include the following `redemptionRule` on all of your promotions.
```json
{
    "redemptionRule": {
        "rule": "!(lineItems.find(item => item.lineTotal.discount > 0)) || value.balanceChange < 0",
        "explanation": "Limited to 1 promotion per transaction."
    }
}
``` 

### Limiting to One Promotion per Line Item
If you want to limit promotions (Values with `discount: true`) to one promotion per `lineItem` you must include the following `redemptionRule` on all of your promotions.
```json
{
    "redemptionRule": {
        "rule": "currentLineItem.lineTotal.discount == 0",
        "explanation": "Limited to 1 promotion per line item."
    }
}
 ``` 

## Examples Continued
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

## Support
For more information on rule syntax please see [Rule Sytnax](https://github.com/Giftbit/Lightrail-API-V2-Docs/blob/master/feature-deep-dive/rule-syntax.md). 

[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 
