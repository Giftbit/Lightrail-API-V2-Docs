## TransactionParty (object)
A partner in the transaction; either a source or a destination for value.  Some TransactionParty objects refer to a single specific Value and some may be capable of referring to multiple value stores.  Not all transactions support the ability to transact with multiple value stores or support all rails.
+ rail (string, required) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailvalueIdTransactionParty (TransactionParty)
+ rail (string, required) - `lightrail`
+ valueId (string, required) - the Value's valueId to transact with.

## LightrailCodeTransactionParty (TransactionParty)
+ rail (string, required) - `lightrail`
+ code (string, required) - the Value's code to transact with.

## LightrailCustomerIdTransactionParty (TransactionParty)
This refers to *all* Values associated with the customer.
+ rail (string, required) - `lightrail`
+ customerId (string, required) - the Customer's customerId.

## StripeTransactionParty (TransactionParty)
+ rail (string, required) - `stripe`
+ token (string, required) - the Stripe token.

## InternalTransactionParty (TransactionParty)
Represents an existing storage for value outside of Lightrail.  This Value can be debited for up to its total value.  The Lightrail system cannot protect against double billing for this value store so manual precautions must be taken.

This is intended as a stop gap solution while transitioning from a legacy system.

+ rail (string, required) - `internal`
+ id (string, required) - the ID of the value.
+ value (number, required) - the amount of value.
+ beforeLightrail (boolean, optional) - if true this Value is applied before Lightrail Values, otherwise it will be applied after.
