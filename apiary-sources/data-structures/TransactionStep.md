## TransactionStep (object)
A step taken as part of the transaction.
+ rail (string) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailTransactionStep (TransactionStep)
+ rail (string) - `lightrail`
+ id (string) - The id of the Value transacted with.
+ currency (string) - The currency of the Value transacted with.
+ contactId (string) - The ID of the Contact associated with the Value.
+ code (string) - {{value.code}}.
+ amount (number) - The amount contributed to the Transaction.  This number will be the same as `balance.change` in Values with a balance.
+ balance (Delta) - The balance before, after and net change of Value that carries a balance.  `null` when the Value does not have a balance (and thus has a valueRule).
+ uses (Delta) - The number of uses remaining before, after and net change of a Value that limits the nummber of uses.  `null` when the Value does not limit number of uses. 

## StripeTransactionStep (TransactionStep)
+ rail (string) - `stripe`
+ amount (number) - the amount of the charge.
+ chargeId (string) - the ID of the Stripe charge, if applicable.
+ charge (object) - the Stripe Charge object, if applicable.

## InternalTransactionStep (TransactionStep)
+ rail (string) - `internal`
+ id (string) - the ID of the internal value transacted with.
+ balance (Delta) - The balance before, after and net change of the internal value.

## Delta (object)
+ before (number) - the balance/uses before the transaction.
+ after (number) - the balance/uses after the transaction.
+ change (number) - the balance/uses change in the transaction.
