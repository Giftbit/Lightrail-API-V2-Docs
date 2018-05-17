## TransactionStep (object)
A step taken as part of the transaction.
+ rail (string, required) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailTransactionStep (TransactionStep)
+ rail (string, required) - `lightrail`
+ id (string, required) - the id of the Value transacted with.
+ currency (string, required) - the currency of the Value transacted with.
+ customerId (string, optional) - the customerId of the Customer associated with the Value.
+ code (string, optional) - {{value.code}}.
+ balanceBefore (number, required) - the balance of the Value before the transaction.
+ balanceAfter (number, required) - the balance of the Value after the transaction.
+ balanceChange (number, required) - the net balance change of the Value for the transaction.

## StripeTransactionStep (TransactionStep)
+ rail (string, required) - `stripe`
+ amount (number, required) - the amount of the charge.
+ chargeId (string, optional) - the ID of the Stripe charge, if applicable.
+ charge (object, optional) - the Stripe Charge object, if applicable.

## InternalTransactionStep (TransactionStep)
+ rail (string, required) - `internal`
+ id (string, required) - the ID of the internal value transacted with.
+ balanceBefore (number, required) - the balance of the internal value before the transaction.
+ balanceAfter (number, required) - the balance of the internal value after the transaction.
+ balanceChange (number, required) - the net balance change of the internal value for the transaction.
