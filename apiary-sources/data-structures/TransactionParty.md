## LightrailTransactionParty (object)
+ rail (string) - The payment rail: `lightrail`. Must be used in combination with one of the following identifiers.
+ code (string) - `lightrail`: the code of a Gift Card or Promotion.
+ contactId (string) - `lightrail`: a Contact's ID.  This is shorthand for all Values that a Contact is associated with.
+ valueId (string) - `lightrail`: a Value's ID.

## StripeOrLightrailTransactionParty (LightrailTransactionParty)
+ rail (string) - The payment rail. Must belong to [`lightrail`, `stripe`]. Must be used in combination with one of the following identifiers.
+ source (string) - `stripe`: a tokenized credit card for Stripe.  
+ customer (string) - `stripe`: a Stripe customer ID (uses customer's default source).  
+ maxAmount (number) - `stripe`: the maximum amount that can be charged to the given Stripe source.
+ additionalStripeParams (AdditionalStripeChargeParams) - `stripe`: additional parameters passed to Stripe when creating a charge.  See [Stripe's documentation](https://stripe.com/docs/api) for more information.

## TransactionParty (StripeOrLightrailTransactionParty)
+ rail (string) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ id (string) - `internal`: the ID of the internal value.
+ balance (number) - `internal`: the amount of internal value stored.
+ beforeLightrail (boolean) - `internal`: if true this value is applied before Lightrail Values, otherwise it will be applied after.

## AdditionalStripeChargeParams (object)
+ description (string)
+ on_behalf_of (string)
+ receipt_email (string)
+ statement_descriptor (string)
+ transfer_group (string)
