## LightrailTransactionParty (object)
+ rail (string, required) - The payment rail: `lightrail`. Must be used in combination with one of the following identifiers.
+ code (string) - The code of a Gift Card or Promotion. {{whitespace.valueCodeNote}}
+ contactId (string) - A Contact's ID.  This is shorthand for all Values that a Contact is associated with.
+ valueId (string) - A Value's ID.

## StripeTransactionParty (object)
+ rail (string, required) - The payment rail: `stripe`. Must be used in combination with a `source` or `customer` identifier.
+ source (string) - A tokenized credit card for Stripe.
+ customer (string) - A Stripe customer ID (uses customer's default source).
+ maxAmount (number, optional) - The maximum amount that can be charged to the given Stripe source.
+ minAmount (number, optional) - The minimum amount that can be charged to the given Stripe source.  If unset [Stripe's default for the currency](https://stripe.com/docs/currencies#minimum-and-maximum-charge-amounts) will be used.  Setting a lower number is not recommended unless the settlement currency is different from the transaction currency.
+ forgiveSubMinAmount (boolean, optional) - If `true` charge amounts below `minAmount` will be forgiven (not charged so that the transaction may complete).  This amount will be tracked in the response `totals.forgiven`.  Has no effect if the top level `allowRemainder=true`.
+ additionalStripeParams (AdditionalStripeChargeParams, optional) - Additional parameters passed to Stripe when creating a charge.  See [Stripe's documentation](https://stripe.com/docs/api) for more information.

## InternalTransactionParty (object)
+ rail (string, required) - The payment rail: `internal`.
+ internalId (string, required) - The ID of the internal value.
+ balance (number, required) - The amount of internal value stored.
+ beforeLightrail (boolean, optional) - If true this value is applied before Lightrail Values, otherwise it will be applied after (default: false).

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
