## TransactionParty (object)
+ rail (string, required) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ customerId (string, optional) - `lightrail`: the Customer's customerId.
+ code (string, optional) - `lightrail`: the code of a gift card or promotion.
+ id (string, optional) - `lightrail`: The ID of a Value.
+ token (string, optional) - `stripe`: a tokenized credit card for Stripe.  
+ id (string, optional) - `internal`: the ID of the internal value.
+ balance (number, optional) - `internal`: the amount of internal value.
+ beforeLightrail (boolean, optional) - `internal`: if true this value is applied before Lightrail Values, otherwise it will be applied after.
