## Transaction (object)
+ id (string) - {{transaction.id}}
+ transactionType (string) - {{transaction.transactionType}}
+ currency (string) - {{currency.code}}
+ steps (array[TransactionStep]) - {{transaction.steps}}
+ totals (TransactionTotals) - Totals calculated for checkout transactions.
+ lineItems (array[LineItemResponse]) - Data on each LineItem in a checkout transaction.
+ paymentSources (array[TransactionParty]) - Sources used in a checkout Transaction.
+ simulated (boolean) - {{transaction.simulated}}
+ createdDate (string) - {{transaction.createdDate}}
+ metadata (object) - {{transaction.metadata}}

## TransactionTotals (object)
+ discount (number) - The amount of discounts applies.
+ marketplace (TransactionTotalsMarketplace) - Marketplace totals calculated if any marketplace behaviour has been configured (by setting the LineItem `marketplaceRate`).
+ payable (number) - The amount payable.
+ remainder (number) - The remainder of balance that could not be debited or charged.
+ subtotal (number) - The sum of all products, services and fees before tax or discounts.
+ tax (number) - The amount of tax to be collected.

## TransactionTotalsMarketplace (object)

sellerDiscount (number) - The amount of discount the seller is responsible for providing (comes from Values with `discountSellerLiability` > 0).
sellerGross (number) - The amount payable to the seller before discounts.
sellerNet (number) - The amount payable to the seller after discounts.
