## Transaction (object)
+ transactionId (string, required) - {{transaction.transactionId}}
+ transactionType (string, required) - {{transaction.transactionType}}
+ currency (string, required) - {{currency}}
+ steps (array[TransactionStep], required) - {{transaction.steps}}
+ remainder (number, required) - {{transaction.remainder}}
+ simulated (boolean, optional) - {{transaction.simulated}}
+ pending (enum[string], optional) - The pending status.  Only set if the Transaction was created with `pending` set to `true`.
    + `pending` - created pending and unresolved.
    + `capture` - created pending and captured.  The Transaction is final.
    + `void` - created pending and voided.  The Transaction was unrolled and all funds released back to their sources.
+ createdDate (string, required) - {{transaction.createdDate}}
+ updatedDate (string, required) - {{customer.updatedDate}}
+ metadata (object, optional) - {{transaction.metadata}}
