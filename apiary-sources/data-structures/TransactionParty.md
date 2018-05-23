## TransactionParty (object)
+ rail (string, required) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ code (string, optional) - `lightrail`: the code of a Gift Card or Promotion.
+ contact (string, optional) - `lightrail`: a Contact's ID.  This is shorthand for all Values that a Contact is associated with.
+ account (string, optional) - `lightrail`: an Account's ID.
+ promotion (string, optional) - `lightrail`: a Promotion's ID.
+ giftCard (string, optional) - `lightrail`: a Gift Card's ID.
+ value (string, optional) - `lightrail`: a Value's ID.
+ token (string, optional) - `stripe`: a tokenized credit card for Stripe.  
+ id (string, optional) - `internal`: the ID of the internal value.
+ balance (number, optional) - `internal`: the amount of internal value stored.
+ beforeLightrail (boolean, optional) - `internal`: if true this value is applied before Lightrail Values, otherwise it will be applied after.
