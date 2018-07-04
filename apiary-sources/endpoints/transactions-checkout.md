### Checkout [POST /transactions/checkout]

The checkout endpoint is used to collect all payment for a purchase. It will debit funds from Lightrail and also charge credit cards through Stripe. Your Stripe account must be connected to Lightrail in order for Lightrail to make charges on your behalf. 

Lightrail and Stripe payment sources are referred to as the payment rails `lightrail` and `stripe` respectively. There is also an `internal` payment rail which can be used to represent any other payment source. This is intended a stop-gap solution to support transitioning from legacy systems.    

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
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + currency (string, required) - {{currency.code}}
        + lineItems (array[LineItem])
        + sources (array[TransactionParty])
        + simulate (boolean, optional) - {{transaction.simulate}}
        + allowRemainder (boolean, optional) - {{transaction.allowRemainder}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.checkout.metadata}}
        
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
                        "contactId": "alice-1234"
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
                        "valueId": "2018-alice-socks-promo",
                        "code": null,
                        "contactId": "alice-1234",
                        "balanceBefore": null,
                        "balanceAfter": null,
                        "balanceChange": -200
                    },
                    {
                        "rail": "lightrail",
                        "valueId": "2018-10percent-off-over-5-orders",
                        "code": "SAVE10PERCENT",
                        "contactId": null,
                        "balanceBefore": null,
                        "balanceAfter": null,
                        "balanceChange": -100
                    },
                    {
                        "rail": "lightrail",
                        "valueId": "2018-50cent-chocobar-credit",
                        "code": null,
                        "contactId": "alice-1234",
                        "balanceBefore": 50,
                        "balanceAfter": 0,
                        "balanceChange": -50
                    },
                    {
                        "rail": "lightrail",
                        "valueId": "alice-account-USD",
                        "code": null,
                        "contactId": "alice-1234",
                        "balanceBefore": 2000,
                        "balanceAfter": 735,
                        "balanceChange": -1265
                    }
                ],
                "remainder": 0,
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z",
                "metadata": {}
            }
