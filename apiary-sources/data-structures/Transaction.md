## Transaction (object)
+ id (string) - {{transaction.id}}
+ transactionType (string) - {{transaction.transactionType}}
+ currency (string) - {{currency.code}}
+ steps (array[TransactionStep]) - {{transaction.steps}}
+ remainder (number) - {{transaction.remainder}}
+ simulated (boolean) - {{transaction.simulated}}
+ pending (enum[string]) - The pending status.  Only set if the Transaction was created with `pending` set to `true`.
    + `pending` - created pending and unresolved.
    + `captured` - created pending and captured.  The Transaction is final.
    + `void` - created pending and voided.  The Transaction was unrolled and all funds released back to their sources.
+ createdDate (string) - {{transaction.createdDate}}
+ updatedDate (string) - {{contact.updatedDate}}
+ metadata (object) - {{transaction.metadata}}
