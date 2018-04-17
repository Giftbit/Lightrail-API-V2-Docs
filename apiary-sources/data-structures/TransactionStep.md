## TransactionStep (object)
A step taken as part of the transaction.
+ rail (string, required) - Indicates the payment rail. Must be either `lightrail`, `stripe` or `internal`.

## LightrailTransactionStep (TransactionStep)
+ rail (string, required) - `lightrail`
+ valueStoreId (string, required) - the valueStoreId of the ValueStore transacted with.
+ valueStoreType (string, required) - the valueStoreType of the ValueStore transacted with.
+ currency (string, required) - the currency of the ValueStore transacted with.
+ customerId (string, optional) - the customerId of the Customer associated with the ValueStore.
+ codeLastFour (string, optional) - the last 4 digits of the code the ValueStore was accessed with.
+ valueBefore (number, required) - the value of the ValueStore before the transaction.
+ valueAfter (number, required) - the value of the ValueStore after the transaction.
+ valueChange (number, required) - the net change of the ValueStore for the transaction.

## StripeTransactionStep (TransactionStep)
+ rail (string, required) - `stripe`
+ amount (number, required) - the amount of the charge.
+ chargeId (string, optional) - the ID of the Stripe charge, if applicable.
+ charge (object, optional) - the Stripe Charge object, if applicable.

## InternalTransactionStep (TransactionStep)
+ rail (string, required) - `internal`
+ id (string, required) - the ID of the internal value store transacted with.
+ valueBefore (number, required) - the value of the ValueStore before the transaction.
+ valueAfter (number, required) - the value of the ValueStore after the transaction.
+ valueChange (number, required) - the net change of the ValueStore for the transaction.
