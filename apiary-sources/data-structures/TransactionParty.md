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
+ minAmount (number) - `stripe`: the minimum amount that can be charged to the given Stripe source.  If unset [Stripe's default for the currency](https://stripe.com/docs/currencies#minimum-and-maximum-charge-amounts) will be used.
+ forgiveSubMinCharges (boolean) - `stripe`: if true charge amounts below `minAmount` will be forgiven (not charged so that the transaction may complete).  This amount will be tracked in the response `totals.forgiven`.
+ additionalStripeParams (AdditionalStripeChargeParams) - `stripe`: additional parameters passed to Stripe when creating a charge.  See [Stripe's documentation](https://stripe.com/docs/api) for more information.

## TransactionParty (StripeOrLightrailTransactionParty)
+ rail (string) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ internalId (string) - `internal`: the ID of the internal value.
+ balance (number) - `internal`: the amount of internal value stored.
+ beforeLightrail (boolean) - `internal`: if true this value is applied before Lightrail Values, otherwise it will be applied after.

## AdditionalStripeChargeParams (object)
+ application_fee (string)
+ application_fee_amount (number)
+ description (string)
+ on_behalf_of (string)
+ receipt_email (string)
+ shipping (AdditionalStripeChargeParams_Shipping)
+ statement_descriptor (string)
+ transfer_group (string)

## `AdditionalStripeChargeParams_Shipping` (object)
+ address (AdditionalStripeChargeParams_Shipping_Address)
+ carrier (string)
+ name (string)
+ phone (string)
+ tracking_number (string)

## `AdditionalStripeChargeParams_Shipping_Address` (object)
+ city (string)
+ country (string)
+ line1 (string)
+ line2 (string)
+ postal_code (string)
+ state (string)
