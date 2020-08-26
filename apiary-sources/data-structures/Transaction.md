## Transaction (object)
+ id (string) - {{transaction.id}}
+ transactionType (string) - {{transaction.transactionType}}
+ currency (string) - {{currency.code}}
+ tax (Tax, optional) - Tax calculation details for checkout transactions. Will be `null` for other transaction types.
+ steps (array[LightrailTransactionStep, StripeTransactionStep, InternalTransactionStep]) - {{transaction.steps}}
+ totals (TransactionTotals) - Totals calculated for checkout transactions. Will be `null` for other transaction types.
+ lineItems (array[LineItemResponse]) - Data on each LineItem in a checkout transaction. Will be `null` for other transaction types.
+ paymentSources (array[LightrailTransactionParty, StripeTransactionParty, InternalTransactionParty]) - An array of payment sources used in a checkout transaction (will be `null` for other transaction types). Sources may be from different payment rails (`lightrail` | `stripe` | `internal`), which will have different attributes.
+ simulated (boolean) - {{transaction.simulated}}
+ pending (boolean) - {{transaction.pendingResponse}}
+ pendingVoidDate (string) - {{transaction.pendingVoidDate}}
+ metadata (object) - {{transaction.metadata}}
+ createdDate (string) - {{transaction.createdDate}}
+ createdBy (string) - {{transaction.createdBy}}

## TransactionTotals (object)
+ subtotal (number) - The sum of all products, services and fees before tax or discounts.
+ tax (number) - The amount of tax to be collected.
+ discount (number) - The total amount of discounts applied.
+ discountLightrail (number) - The amount discounted from Lightrail payment sources. 
+ payable (number) - The amount payable by the customer. Calculated as `payable = subtotal + tax - discount`.
+ paidLightrail (number) - The amount paid from Lightrail payment sources.
+ paidStripe (number) - The amount paid from Stripe payment sources.
+ paidInternal (number) - The amount paid from Internal payment sources.
+ remainder (number) - {{transaction.remainderResponse}}
+ forgiven (number) - The amount forgiven (will not be charged).  This happens when `forgiveSubMinAmount=true` and the amount is below the minimum a payment rail will process.
+ marketplace (TransactionTotalsMarketplace) - Marketplace totals calculated if any marketplace behaviour has been configured (by setting the LineItem `marketplaceRate`).

## TransactionTotalsMarketplace (object)
+ sellerDiscount (number) - The amount of discount the seller is responsible for providing (comes from Values with `discountSellerLiability` > 0).
+ sellerGross (number) - The amount payable to the seller before discounts.
+ sellerNet (number) - The amount payable to the seller after discounts.
