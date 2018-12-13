## Transaction (object)
+ id (string) - {{transaction.id}}
+ transactionType (string) - {{transaction.transactionType}}
+ currency (string) - {{currency.code}}
+ tax (Tax, optional) 
+ steps (array[TransactionStep]) - {{transaction.steps}}
+ totals (TransactionTotals) - Totals calculated for checkout transactions.
+ lineItems (array[LineItemResponse]) - Data on each LineItem in a checkout transaction.
+ paymentSources (array[TransactionParty]) - Sources used in a checkout Transaction.
+ simulated (boolean) - {{transaction.simulated}}
+ pending (boolean) - {{transaction.pendingResponse}}
+ pendingVoidDate (string) - {{transaction.pendingVoidDate}}
+ createdDate (string) - {{transaction.createdDate}}
+ metadata (object) - {{transaction.metadata}}

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
+ marketplace (TransactionTotalsMarketplace) - Marketplace totals calculated if any marketplace behaviour has been configured (by setting the LineItem `marketplaceRate`).

## TransactionTotalsMarketplace (object)
+ sellerDiscount (number) - The amount of discount the seller is responsible for providing (comes from Values with `discountSellerLiability` > 0).
+ sellerGross (number) - The amount payable to the seller before discounts.
+ sellerNet (number) - The amount payable to the seller after discounts.
