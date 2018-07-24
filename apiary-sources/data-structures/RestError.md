## RestError (object)
+ statusCode (number) - the HTTP status code.
+ message (string) - an English explanation of the error.  This is for display purposes only as the explanation may be formatted or change between system updates.
+ messageCode (string) - A constant corresponding to the message.  This can be used to take action in response to the error.

## StripeRestError (object)
+ statusCode (number) - the HTTP status code.
+ message (string) - an English explanation of the error.  This is for display purposes only as the explanation may be formatted or change between system updates.
+ messageCode (string) - A constant corresponding to the message.  This can be used to take action in response to the error.
+ stripeError (object) - When using the `stripe` rail: the full error response from Stripe in case of an error charging a credit card.
