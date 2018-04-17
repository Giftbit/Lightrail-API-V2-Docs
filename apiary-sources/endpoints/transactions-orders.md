### Create Order [POST /transactions/orders]

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


Notes:

---
+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + transactionId (string, required) - {{transaction.transactionId}}
        + currency (string, required) - {{currency}}
        + lineItems (array[LineItem])
        + paymentSources (array[PaymentSource])
        
    + Body 
    
            {
                "transactionId": "unique-id-123",
                "currency": "USD",
                "lineItems": [
                    {
                        "type": "product",
                        "productId": "pid_12345", 
                        "unitPrice": 500,
                        "taxRate": 0.08, 
                        "description": "Socks.", 
                        "quantity": 2
                    },
                    {
                        "type": "product",
                        "productId": "pid_41234", 
                        "unitPrice": 199,
                        "taxRate": 0.05, 
                        "description": "Chocolate bar."
                    },
                    {
                        "type": "shipping",
                        "productId": "standard-shipping",
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
                        "tags": ["clothing"],
                        "quantity": 2,
                        "promotions": [
                            {
                                "valueStoreId": "2018-alice-socks-promo",
                                "rule": "item.productId == "pid_12345'",
                                "ruleExplanation": "Socks 20% discount",
                                "amount": 200,
                                "pretax": true
                            },
                            {
                                "valueStoreId": "2018-10percent-off-over-5-orders",
                                "rule": "order.total > 500 && item.type != 'shipping", 
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": 80,
                                "pretax": true
                            }
                        ],
                        "lineTotal": {
                            "price": 1000,
                            "pretaxDiscount": 280,
                            "taxable": 720,
                            "tax": 58,
                            "postTaxDiscount": 0,
                            "payable": 778
                        }  
                    },
                    {
                        "type": "product",
                        "id": "pid_41234", 
                        "unitPrice": 199,
                        "taxRate": 0.05, 
                        "tags": ["food"],
                        "promotions": [
                            {
                                "valueStoreId": "2018-10percent-off-over-5-orders",
                                "rule": "order.total > 500 && item.type != 'shipping", 
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": 20,
                                "pretax": true
                            },
                            {
                                "valueStoreId": "2018-50cent-chocobar-credit",
                                "rule": "item.productId == "pid_41234",
                                "ruleExplanation": "50 cents towards chocolate bars.",
                                "amount": 50,
                                "pretax": false
                            }
                        ],
                        "lineTotal": {
                            "price": 199,
                            "pretaxDiscount": 20,
                            "taxable": 179,
                            "tax": 9,
                            "postTaxDiscount: 50,
                            "payable": 138
                        }
                    },
                    {
                        "type": "shipping",
                        "id": "standard-shipping", 
                        "unitPrice": 349,
                        "taxRate": 0, 
                        "promotions": [
                        ],
                        "lineTotal": {
                            "price": 349,
                            "pretaxDiscount": 0,
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
                        "valueChange": -200,
                        "valueAfter": null,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "2018-10percent-off-over-5-orders",
                        "valueChange": -100,
                        "valueAfter": null,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "2018-50cent-chocobar-credit",
                        "valueChange": -50,
                        "valueAfter": null,
                        "type": "PROMOTION"
                    },
                    {
                        "valueStoreId": "alice-account-USD",
                        "valueChange": -1265,
                        "valueAfter": 735,
                        "type": "PREPAID"
                    }
                ]
            }