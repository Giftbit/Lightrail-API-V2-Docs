## TransactionParty (object)
A partner in the transaction; either a source or a destination for value.  Some TransactionParty objects refer to a single specific Value and some may be capable of referring to multiple Values.  Not all transactions support the ability to transact with multiple Values or support all rails.
+ rail (string, required) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailidTransactionParty (TransactionParty)
+ rail (string, required) - `lightrail`
+ id (string, required) - the Value's id to transact with.

## LightrailCodeTransactionParty (TransactionParty)
+ rail (string, required) - `lightrail`
+ code (string, required) - the Value's code to transact with.

## LightrailContactIdTransactionParty (TransactionParty)
This refers to *all* Values associated with the contact.
+ rail (string, required) - `lightrail`
+ contactId (string, required) - the Contact's contactId.

## StripeTransactionParty (TransactionParty)
+ rail (string, required) - `stripe`
+ token (string, required) - the Stripe token.

## InternalTransactionParty (TransactionParty)
Represents an existing storage for value outside of Lightrail.  This Value can be debited for up to its total value.  The Lightrail system cannot protect against double billing for this value store so manual precautions must be taken.

This is intended as a stop gap solution while transitioning from a legacy system.

+ rail (string, required) - `internal`
+ id (string, required) - the ID of the internal value.
+ balance (number, required) - the amount of internal value.
+ beforeLightrail (boolean, optional) - if true this value is applied before Lightrail Values, otherwise it will be applied after.
