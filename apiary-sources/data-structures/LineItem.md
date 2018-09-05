## LineItem (object)
+ type (string) - {{transaction.lineItem.type}}
+ productId (string) -  {{transaction.lineItem.productId}}
+ variantId (string) - {{transaction.lineItem.variantId}}
+ unitPrice (number) -  {{transaction.lineItem.unitPrice}}
+ quantity (number) -  {{transaction.lineItem.quantity}}
+ taxRate (number) - {{transaction.lineItem.taxRate}}
+ marketplaceRate (number) - {{transaction.lineItem.marketplaceRate}}
+ tags (array[string]) - {{transaction.lineItem.tags}}
+ metadata (object) - {{transaction.lineItem.metadata}}

## LineItemResponse (LineItem)
+ valuesApplied (array[LineItemPromotions])
+ lineTotal (LineTotal)

## LineItemPromotions (object)
+ id (string) - {{value.id}}
+ redemptionRule (string) - {{value.redemptionRule}}
+ ruleExplanation (string) - {{value.ruleExplanation}}
+ amount (number) - The value of the discount.
+ pretax (boolean) - {{value.pretax}}

## LineTotal (object)
+ subtotal (number) - {{transaction.lineItem.lineTotal.subtotal}}
+ taxable (number) - {{transaction.lineItem.lineTotal.taxable}}
+ tax (number) - {{transaction.lineItem.lineTotal.tax}}
+ discount (number) - {{transaction.lineItem.lineTotal.discount}}
+ payable (number) - {{transaction.lineItem.lineTotal.payable}}
