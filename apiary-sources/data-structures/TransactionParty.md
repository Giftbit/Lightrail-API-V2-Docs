## TransactionParty (object)
+ rail (string) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ code (string) - `lightrail`: the code of a Gift Card or Promotion.
+ contactId (string) - `lightrail`: a Contact's ID.  This is shorthand for all Values that a Contact is associated with.
+ valueId (string) - `lightrail`: a Value's ID.
+ token (string) - `stripe`: a tokenized credit card for Stripe.  
+ id (string) - `internal`: the ID of the internal value.
+ balance (number) - `internal`: the amount of internal value stored.
+ beforeLightrail (boolean) - `internal`: if true this value is applied before Lightrail Values, otherwise it will be applied after.
