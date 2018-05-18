## TransactionStep (object)
A step taken as part of the transaction.
+ rail (string, required) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailTransactionStep (TransactionStep)
+ rail (string, required) - `lightrail`
+ id (string, required) - The id of the Value transacted with.
+ currency (string, required) - The currency of the Value transacted with.
+ contact (string, optional) - The ID of the Contact associated with the Value.
+ code (string, optional) - {{value.code}}.
+ amount (number, required) - The amount contributed to the Transaction.  This number will be the same as `balance.change` in Values with a balance.
+ balance (Delta, optional) - The balance before, after and net change of Value that carries a balance.  `null` when the Value does not have a balance (and thus has a valueRule).
+ uses (Delta, optional) - The number of uses remaining before, after and net change of a Value that limits the nummber of uses.  `null` when the Value does not limit number of uses. 

## StripeTransactionStep (TransactionStep)
+ rail (string, required) - `stripe`
+ amount (number, required) - the amount of the charge.
+ chargeId (string, optional) - the ID of the Stripe charge, if applicable.
+ charge (object, optional) - the Stripe Charge object, if applicable.

## InternalTransactionStep (TransactionStep)
+ rail (string, required) - `internal`
+ id (string, required) - the ID of the internal value transacted with.
+ balance (Delta, optional) - The balance before, after and net change of the internal value.

## Delta (object)
+ before (number, required) - the balance/uses before the transaction.
+ after (number, required) - the balance/uses after the transaction.
+ change (number, required) - the balance/uses change in the transaction.
