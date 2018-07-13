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
    
            {"id":"checkoutExample1-_rn1","sources":[{"rail":"lightrail","valueId":"valueForCheckout1-_rn1"},{"rail":"lightrail","valueId":"valueForCheckout2-_rn1"},{"rail":"lightrail","valueId":"valueForCheckout3-_rn1"}],"lineItems":[{"productId":"socks","unitPrice":500,"quantity":2,"taxRate":0.08},{"productId":"chocolate_bar","unitPrice":199,"taxRate":0.05},{"productId":"shipping","unitPrice":349,"taxRate":0.0}],"currency":"USD"}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body
    
            {"id":"checkoutExample1-_rn1","transactionType":"checkout","currency":"USD","totals":{"subtotal":1548,"tax":71,"discount":250,"payable":1369,"remainder":0},"lineItems":[{"productId":"socks","unitPrice":500,"quantity":2,"taxRate":0.08,"lineTotal":{"subtotal":1000,"taxable":800,"tax":64,"discount":200,"remainder":0,"payable":864}},{"productId":"shipping","unitPrice":349,"taxRate":0,"quantity":1,"lineTotal":{"subtotal":349,"taxable":349,"tax":0,"discount":0,"remainder":0,"payable":349}},{"productId":"chocolate_bar","unitPrice":199,"taxRate":0.05,"quantity":1,"lineTotal":{"subtotal":199,"taxable":149,"tax":7,"discount":50,"remainder":0,"payable":156}}],"steps":[{"rail":"lightrail","valueId":"valueForCheckout2-_rn1","contactId":null,"code":null,"balanceBefore":50,"balanceAfter":0,"balanceChange":-50},{"rail":"lightrail","valueId":"valueForCheckout3-_rn1","contactId":null,"code":null,"balanceBefore":0,"balanceAfter":-200,"balanceChange":-200},{"rail":"lightrail","valueId":"valueForCheckout1-_rn1","contactId":null,"code":null,"balanceBefore":2000,"balanceAfter":631,"balanceChange":-1369}],"paymentSources":[{"rail":"lightrail","valueId":"valueForCheckout1-_rn1"},{"rail":"lightrail","valueId":"valueForCheckout2-_rn1"},{"rail":"lightrail","valueId":"valueForCheckout3-_rn1"}],"metadata":null,"createdDate":"2018-07-13T18:59:49.000Z"}

+ Response 409 (application/json)

    You cannot checkout if the balance of all Values does not cover the `lineItems` and there is no credit card to charge (if `allowRemainder` is not `true`).

    + Attributes (Transaction)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
