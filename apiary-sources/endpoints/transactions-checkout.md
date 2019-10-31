### Checkout [POST /transactions/checkout]

The checkout endpoint collects all payment for a purchase.  It can apply all Lightrail promotions, calculate tax, debit funds from Lightrail and charge credit cards through Stripe. Your Stripe account must be [connected to Lightrail](https://www.lightrail.com/app/#/account/api) in order for Lightrail to make charges on your behalf.

Lightrail and Stripe payment sources are referred to as the payment rails `lightrail` and `stripe` respectively. There is also an `internal` payment rail which can be used to represent any other payment source. This is intended as a stop-gap solution to support transitioning from legacy systems.

Error responses: If using the `stripe` rail, it is possible for checkout transactions to fail for reasons outside of Lightrail's control, such as an invalid card token or a card being declined. Stripe errors will be passed on in full under the `stripeError` key in the response. 

+ Request (application/json)
    
    Data used in example:
    - Purchasing: 
        - 2x $5 socks (8% tax rate)
        - 1x $1.99 chocolate bar  (5% tax rate)
        - 1x $3.49 shipping (0% tax rate)
    - Payment Sources:
        - Contact with prepaid account and a chocolate bar promotion.
            - Account has $10.
            - Sock promo is for 20% off retail price of socks.
        - Credit card
    
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
        + tax (Tax, optional) 
        + metadata (object, optional) - {{transaction.checkout.metadata}}
        
    + Body 
    
            {REQUEST_REPLACEMENT:checkoutExample1.body}
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body
    
            {REQUEST_REPLACEMENT:checkoutExample1.response.body}

+ Response 409 (application/json)

    You cannot checkout if the balance of all Values does not cover the `lineItems` and there is no credit card to charge (if `allowRemainder` is not `true`).

    + Attributes (StripeRestError)

    + Body

            {
                "statusCode": 409,
                "message": "Insufficient balance for the transaction.",
                "messageCode": "InsufficientBalance"
            }

+ Response 409 (application/json)

    Idempotency error: you cannot create use a Transaction `id` more than once, for the same or a different Transaction request.
    
    + Attributes (RestError)

    + Body

            {
                "statusCode": 409,
                "message": "A Lightrail transaction with transactionId 'transac-12345' already exists.",
                "messageCode": "TransactionExists"
            }

+ Response 409 (application/json)

    Stripe minimum charge error: Stripe will not process charges for less than $0.50 USD ([or equivalent](https://stripe.com/docs/currencies#minimum-and-maximum-charge-amounts)). This error can be triggered in a split tender transaction if the customer does not have quite enough balance in their account or on their gift card. You can handle this error by forgiving the small charge and setting `forgiveSubMinAmount=true` on the Stripe source, asking your customer to top up their account balance, or by adding a "minimum credit card amount fee" line item to the order that covers the difference. 
    
    + Body

            {
                "statusCode": 409,
                "message": "The transaction cannot be processed because it contains a Stripe charge (45) below the minimum (50).  Please see the documentation on `allowRemainder` and `source.forgiveSubMinCharges` or create a fee to raise the total charge.",
                "messageCode": "StripeAmountTooSmall",
                "amount": 45,
                "minAmount": 50
            }
