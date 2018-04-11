### Debit [POST /transactions/debit]

Data used in example:

Purchasing: 
 - 2x $5 socks (8% tax rate)
 - 1x $1.99 chocolate bar  (5% tax rate)
 - 1x $3.49 shipping (0% tax rate)
 
 Payment Sources:
 - Customer with prepaid account, and a sock and chocolate bar promotion.
    - Account has $20.
    - Sock promo is for 20% off retail price of socks.
    - Chocolate bar promo is a $0.50 credit towards the purchase of a chocolate bar.
- Generic code for 10% off orders over $5 (does not apply to shipping). 

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}\
        + currency (string, required) - {{currency}}
        + lineItems (array[LineItem])
        
    + Body 
    
            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "lineItems": [
                    {
                        "type": "product",
                        "id": "pid_12345", 
                        "unitPrice": 500,
                        "taxRate": 0.08, 
                        "description": "Socks.", 
                        "quantity": 2
                    },
                    {
                        "type": "product",
                        "id": "pid_41234", 
                        "unitPrice": 199,
                        "taxRate": 0.05, 
                        "description": "Chocolate bar."
                    },
                    {
                        "type": "shipping",
                        "id": "standard-shipping",
                        "unitPrice": 349,
                        "taxRate": 0
                    }
                ],
                "paymentSources": [
                    {
                        "rail": "lightrail",
                        "customerEmail": "alice@example.com"
                    },
                    {
                        "rail": "lightrail",
                        "code": "SAVE10PERCENT"
                    }
                ]
            }
    
+ Response 200
    + Attributes
        + lineItems (array[LineItemResponse])

    + Body
    
            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "subtotal": 1548,
                "discount": 350,
                "tax": 67,
                "payable": 1265,                
                "lineItems": [
                    {
                        "type": "product",
                        "id": "pid_12345", 
                        "unitPrice": 500,
                        "taxRate": 0.08, 
                        "description": "Socks.", 
                        "quantity": 2,
                        "promotions": [
                            {
                                "type": "ITEM_DISCOUNT",
                                "valueStoreId": "2018-alice-socks-promo",
                                "ruleExplanation": "Socks 20% discount",
                                "amount": 200,
                                "pretax": true
                            },
                            {
                                "type": "CART_DISCOUNT",
                                "valueStoreId": "2018-10percent-off-over-5-orders",
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": 80,
                                "pretax": true
                            }
                        ],
                        "lineTotal": {
                            "price": 1000,
                            "preTaxDiscount": 280,
                            "taxable": 720,
                            "tax": 58,
                            "postTaxDiscount": 0,
                            "payable": 778
                        }  
                    },
                    {
                        "type": "product",
                        "id": "pid_41234", 
                        "unitCost": 199,
                        "taxRate": 0.05, 
                        "description": "Chocolate bar.",
                        "promotions": [
                            {
                                "type": "CART_DISCOUNT",
                                "valueStoreId": "2018-10percent-off-over-5-orders",
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": 20,
                                "pretax": true
                            },
                            {
                                "type": "ITEM_DISCOUNT",
                                "valueStoreId": "2018-50cent-chocobar-credit",
                                "ruleExplanation": "50 cents towards chocolate bars.",
                                "amount": 50,
                                "pretax": false
                            }
                        ],
                        "lineTotal": {
                            "price": 199,
                            "preTaxDiscount": 20,
                            "taxable": 179,
                            "tax": 9,
                            "postTaxDiscount: 50,
                            "payable": 138
                        }
                    },
                    {
                        "type": "shipping",
                        "id": "standard-shipping", 
                        "unitCost": 349,
                        "taxRate": 0, 
                        "promotions": [
                        ],
                        "lineTotal": {
                            "price": 349,
                            "preTaxDiscount": 0,
                            "taxable": 349,
                            "tax": 0,
                            "postTaxDiscount: 0,
                            "payable": 349
                        }
                    }                    
                ],
                "paymentSources": [
                    {
                        "rail": "lightrail",
                        "customerEmail": "alice@example.com",
                        "valueStores": [
                            "alice-account-USD", "2018-alice-socks-promo", "2018-50cent-chocobar-credit"
                        ]
                    },
                    {
                        "rail": "lightrail",
                        "code": "SAVE10PERCENT",
                        "valueStores": [
                            "2018-10percent-off-over-5-orders"
                        ]
                    }
                ],
                "transactionSteps": [
                    {
                        "valueStoreId": "2018-alice-socks-promo",
                        "amount": -200,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "2018-10percent-off-over-5-orders",
                        "amount": -100,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "2018-50cent-chocobar-credit",
                        "amount": -50,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "alice-account-USD",
                        "amount": -1265,
                        "type": "PREPAID"
                    }
                ]
            }