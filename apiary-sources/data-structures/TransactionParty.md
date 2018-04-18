## TransactionParty (object)
+ rail (string, required) - The payment rail. Must belong to [`lightrail`, `stripe`, `internal`]. Must be used in combination with one of the following identifiers.
+ customerId (string, optional) - `lightrail`: the Customer's customerId.
+ code (string, optional) - `lightrail`: the code of a gift card or promotion.
+ valueStoreId (string, optional) - `lightrail`: The ID of a ValueStore.
+ token (string, optional) - `stripe`: a tokenized credit card for Stripe.  
+ id (string, optional) - `internal`: the ID of the value.
+ value (number, optional) - `internal`: the amount of value.
+ appliedFirst (boolean, optional) - `internal`: if true this value store is applied before Lightrail ValueStores, otherwise it will be applied after.
