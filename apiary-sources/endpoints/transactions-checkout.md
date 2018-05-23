### Checkout [POST /transactions/checkout]

Process a checkout by debiting (removing value from) one or more payment rails.  The payment rails `lightrail`, `stripe` and `internal` are supported.

+ Request (application/json)
    
    Data used in example:
    - Purchasing: 
        - 2x $5 socks (8% tax rate)
        - 1x $1.99 chocolate bar  (5% tax rate)
        - 1x $3.49 shipping (0% tax rate)
    - Payment Sources:
        - Contact with prepaid account, and a sock and chocolate bar promotion.
            - Account has $20.
            - Sock promo is for 20% off retail price of socks.
            - Chocolate bar promo is a $0.50 credit towards the purchase of a chocolate bar.
        - Generic code for 10% off orders over $5 (does not apply to shipping). 
    
    + Headers
    
            {{header.authorization}}

    + Attributes
        + id (string, required) - {{transaction.id}}
        + currency (string, required) - {{currency.code}}
        + lineItems (array[LineItem])
        + sources (array[TransactionParty])
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}
        
    + Body 
    
            {
                "id": "unique-id-123",
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
                "sources": [
                    {
                        "rail": "lightrail",
                        "contact": "alice-1234"
                    },
                    {
                        "rail": "lightrail",
                        "code": "SAVE10PERCENT"
                    }
                ]
            }
    
+ Response 201 (application/json)
    + Attributes (Transaction)

    + Body
    
            {
                "id": "unique-id-123",
                "transactionType": "order",
                "currency": "USD",
                "totals": {
                    "subtotal": 1548, 
                    "tax": 67,
                    "discount": 350,
                    "payable": 1265 
                },
                "lineItems": [
                    {
                        "type": "product",
                        "id": "pid_12345", 
                        "unitPrice": 500,
                        "taxRate": 0.08, 
                        "description": "Socks.", 
                        "quantity": 2,
                        "valuesApplied": [
                            {
                                "id": "2018-alice-socks-promo",
                                "rule": "item.productId == "pid_12345'",
                                "ruleExplanation": "Socks 20% discount",
                                "amount": -200,
                                "preTax": true,
                                "discount": true
                            }, 
                            {
                                "id": "2018-10percent-off-over-5-orders",
                                "rule": "order.total > 500 && item.type != 'shipping", 
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": -80,
                                "preTax": true,
                                "discount": true
                            }
                        ],
                        "lineTotal": {
                            "price": 1000,
                            "taxable": 720,
                            "tax": 58,
                            "discount": 280,
                            "payable": 778
                        }  
                    },
                    {
                        "type": "product",
                        "id": "pid_41234", 
                        "unitCost": 199,
                        "taxRate": 0.05, 
                        "description": "Chocolate bar.",
                        "valuesApplied": [
                            {
                                "rail": "lightrail",
                                "id": "2018-10percent-off-over-5-orders",
                                "rule": "order.total > 500 && item.type != 'shipping", 
                                "ruleExplanation": "Take 10% off order if over $5.",
                                "amount": -20,
                                "preTax": true,
                                "discount": true
                            },
                            {
                                "rail": "lightrail",
                                "id": "2018-50cent-chocobar-credit",
                                "rule": "item.productId == "pid_41234",
                                "ruleExplanation": "50 cents towards chocolate bars.",
                                "amount": -50,
                                "preTax": false,
                                "discount": true
                            }
                        ],
                        "lineTotal": {
                            "price": 199,
                            "taxable": 179,
                            "tax": 9,
                            "discount": 70,
                            "payable": 138
                        }
                    },
                    {
                        "type": "shipping",
                        "id": "standard-shipping", 
                        "unitCost": 349,
                        "taxRate": 0, 
                        "valuesApplied": [
                            {
                                "id": "alice-account-USD",
                                "amount": -349,
                                "preTax": false,
                                "discount": false
                            }
                        ],
                        "lineTotal": {
                            "price": 349,
                            "taxable": 349,
                            "tax": 0,
                            "discount": 0,
                            "payable": 349
                        }
                    }
                ],
                "steps": [
                    {
                        "rail": "lightrail",
                        "id": "2018-alice-socks-promo",
                        "currency": "USD",
                        "contact": "alice-1234",
                        "amount": -200,
                        "balance": null,
                        "uses": {
                            "before": 1,
                            "after": 0,
                            "change": -1
                        }
                    },
                    {
                        "rail": "lightrail",
                        "id": "2018-10percent-off-over-5-orders",
                        "currency": "USD",
                        "code": "SAVE10PERCENT",
                        "amount": -100,
                        "balance": null,
                        "uses": null
                    },
                    {
                        "rail": "lightrail",
                        "id": "2018-50cent-chocobar-credit",
                        "currency": "USD",
                        "contact": "alice-1234",
                        "amount": -50,
                        "balance": {
                            "before": 50,
                            "after": 0,
                            "change": -50
                        },
                        "uses": null
                    },
                    {
                        "rail": "lightrail",
                        "id": "alice-account-USD",
                        "currency": "USD",
                        "contact": "alice-1234",
                        "amount": -1265,
                        "balance": {
                            "before": 2000,
                            "after": 735,
                            "change": -1265
                        },
                        "uses": null
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z",
                "metadata": {}
            }