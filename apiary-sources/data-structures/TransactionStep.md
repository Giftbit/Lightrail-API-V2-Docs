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
+ balanceBefore (number) - The balance of the Value before the Transaction.  `null` when the Value does not have a `balance` (and thus has a `valueRule`).
+ balanceAfter (number) - The balance of the Value after the Transaction.  `null` when the Value does not have a `balance` (and thus has a `valueRule`).
+ balanceChange (number) - The net change of the balance of the Value for the Transaction.  When the Value has a `valueRule` rather than a `balance` this number will still be set to indicate the value of the rule.

## StripeTransactionStep (TransactionStep)
+ rail (string) - `stripe`
+ amount (number) - the amount of the charge.
+ chargeId (string) - the ID of the Stripe charge, if applicable.
+ charge (object) - the Stripe Charge object, if applicable.

## InternalTransactionStep (TransactionStep)
+ rail (string) - `internal`
+ id (string) - the ID of the internal value transacted with.
+ balanceBefore (number) - The balance of the internal value before the Transaction.
+ balanceAfter (number) - The balance of the internal value after the Transaction.
+ balanceChange (number) - The net change of the balance of the internal value for the Transaction.
