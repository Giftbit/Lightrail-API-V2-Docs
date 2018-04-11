### Debit [POST /transactions/debit]
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
            			"unitCost": 500,
            			"taxRate": 0.08, 
            			"description": "Socks.", 
            			"quantity": 2
            		},
                    {
            			"type": "product",
            			"id": "pid_41234", 
            			"unitCost": 199,
            			"taxRate": 0.05, 
            			"description": "Chocolate bar."
            		},            		
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
                "totalPrice": 1199,
                "discounted": 300,
                "tax": 77,
                "totalWithTax": 976,                
            	"lineItems": [
            		{
            			"type": "product",
            			"id": "pid_12345", 
            			"unitCost": 500,
            			"taxRate": 0.08, 
            			"description": "Socks.", 
            			"quantity": 2,
            			"promotions": [
            			    {
            			        "type": "ITEM_DISCOUNT",
            			        "ruleExplanation": "Socks 20% discount",
            			        "amount": 200,
            			        "pretax": true
                            }, 
                            {
                                "type": "CART_DISCOUNT",
                                "ruleExplanation": "Take 10% off order if over $10.",
                                "amount": 80,
                                "pretax": true
                            }
            			],
            			"totalPrice": 1000,
            			"discounted": 280,
            			"totalTaxable": 720,
            			"tax": 58,
            			"totalWithTax": 778
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
                                "ruleExplanation": "Take 10% off order if over $10.",
                                "amount": 20,
                                "pretax": true
                            }
            			],
            			"totalPrice": 199,
            			"discounted": 20,
            			"totalTaxable": 179,
            			"tax": 9,
            			"totalWithTax": 188
            		},            		
            	],
            	"paymentSources": [
            		{
            			"rail": "lightrail",
            			"customerEmail": "alice@example.com",
            			"valueStores": [
            			    "alice-account-USD", "2018-alice-socks-promo"
            			]
            		},
            		{
            		    "rail": "lightrail",
            		    "code": "SAVE10PERCENT",
            		    "valueStores": [
            		        "2018-10percent-off-over10-orders"
            		    ]
            		}
            	],
            	"transactionSteps": [
            	    {
            	        "valueStoreId": "2018-alice-socks-promo",
            	        "amount": -200,
            	        "currency": "USD"
            	    },            	    
            	    {
            	        "valueStoreId": "2018-10percent-off-over10-orders",
            	        "amount": -100,
            	        "currency": "USD"
            	    },            	    
            	    {
            	        "valueStoreId": "alice-account-USD",
            	        "amount": -676,
            	        "currency": "USD"
            	    }, 
            	]
            }