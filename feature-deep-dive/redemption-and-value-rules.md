# Redemption Rules and Value Rules
Redemption Rules and Value Rules are extra conditions placed on Values that are evaluated during checkout. Redemption rules determine if a Value can be used and evaluate to a boolean. Value Rules enable more advanced balance behaviour, such as percent off, and evaluate to a number. Rules are typically used for promotions and represent a discount to the customer. Let's look at a few examples.  

**Example 1: $5 off orders over $100** 
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
This example requires the use of a Value Rule in combination with a Redemption Rule. The Redemption Rule restricts the Value to apply strictly to a single select item. The Value Rule causes the Value to be worth 50% of the select item's subtotal.

Create Value request:
```json
{
    "id": "example",
    "currency": "USD",
    "redemptionRule": {
        "rule": "currentLineItem.productId == 'red-hat'",
        "explanation": "Promotion can be used towards purchase of red hats."
    },
    "valueRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.5",
        "explanation": "50% off item's subtotal."
    },
    "discount": true
}
```

## How Rules Work
Value and Redemption Rules are evaluated for each line item during checkout. When evaluating a line item the Rules operate on a Rule Context which contains the current item and the entire order.

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
        "marketplaceRate": "number",
        "metadata": "object",
        "lineTotal": {
            "subtotal": "number",
            "taxable": "number",
            "tax": "number",
            "discount": "number",
            "remainder": "number",
            "payable": "number"
        }
    }, 
    "totals": {
        "subtotal": "number",
        "tax": "number",
        "discount": "number",
        "payable": "number",
        "remainder": "number"

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
            "marketplaceRate": "number",
            "metadata": "object",
            "lineTotal": {
                "subtotal": "number",
                "taxable": "number",
                "tax": "number",
                "discount": "number",
                "remainder": "number",
                "payable": "number"
            }
        }
    ]
}
```

You can think of the Rule Context being created as a simple map which the Rules evaluate on. 

## Examples
**50% off each item**

Create Value request:
```json
{
    "id": "example",
    "currency": "USD",
    "valueRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.5",
        "explanation": "50% off item's subtotal."
    },
    "discount": true
}
```
Note, often you'll want to limit promotions to one per item.

**Limiting to one discount per item**
Create Value request:
```json
{
    "id": "example",
    "currency": "USD",
    "redemptionRule": {
        "rule": "currentLineItem.lineTotal.discount == 0",
        "explanation": "Limited to 1 discount per item."
    },
    // needs balance or valueRule depending on what the Value should be worth
    "discount": true
}
```

**50% off orders over $100 and limited to 1 promotion per item**
Create Value request:
```json
{
    "id": "example",
    "currency": "USD",
    "redemptionRule": {
        "rule": "totals.subtotal >= 10000 && currentLineItem.lineTotal.discount == 0",
        "explanation": "Applies to orders over $100. Limited to 1 discount per item."
    },
    "valueRule": {
        "rule": "currentLineItem.lineTotal.subtotal * 0.5",
        "explanation": "50% off item's subtotal."
    },
    "discount": true
}
```

## Support
For more information on rule syntax please see: 

[Contact us](mailto:hello@lightrail.com) any time if you have any questions, we're here to help. 