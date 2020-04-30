## LightrailTransactionStep (object)
+ rail (string) - The payment rail: `lightrail`.
+ valueId (string) - The id of the Value transacted with.
+ currency (string) - The currency of the Value transacted with.
+ contactId (string) - The ID of the Contact associated with the Value.
+ code (string) - {{value.code}}
+ balanceBefore (number) - The `balance` of the Value before the Transaction.  `null` when the Value does not have a `balance` (and thus has a `balanceRule`).
+ balanceAfter (number) - The `balance` of the Value after the Transaction.  `null` when the Value does not have a `balance` (and thus has a `balanceRule`).
+ balanceChange (number) - The net change of the `balance` of the Value for the Transaction.  When the Value has a `balanceRule` rather than a `balance` this number will still be set to indicate the value of the rule.
+ usesRemainingBefore (number) - The `usesRemaining` of the Value before the Transaction.  `null` when the Value does not have a `usesRemaining`.
+ usesRemainingAfter (number) - The `usesRemaining` of the Value after the Transaction.  `null` when the Value does not have a `usesRemaining`.
+ usesRemainingChange (number) - The net change of the `usesRemaining` of the Value for the Transaction.

## StripeTransactionStep (object)
+ rail (string) - The payment rail: `stripe`.
+ amount (number) - the amount of the charge.
+ chargeId (string) - the ID of the Stripe charge.
+ charge (object) - the Stripe Charge object, if applicable.

## InternalTransactionStep (object)
+ rail (string) - The payment rail: `internal`.
+ internalId (string) - the ID of the internal value transacted with.
+ balanceBefore (number) - The balance of the internal value before the Transaction.
+ balanceAfter (number) - The balance of the internal value after the Transaction.
+ balanceChange (number) - The net change of the balance of the internal value for the Transaction.
