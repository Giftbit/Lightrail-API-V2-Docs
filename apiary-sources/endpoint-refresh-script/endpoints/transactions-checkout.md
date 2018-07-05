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
    
            {REQUEST_REPLACEMENT:checkoutExample1.body}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body
    
            {REQUEST_REPLACEMENT:checkoutExample1.response.body}

+ Response 409 (application/json)

    You cannot checkout if the balance of all Values does not cover the `lineItems` and there is no credit card to charge (if `allowRemainder` is not `true`).

    + Attributes (Transaction)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }
