## LineItem (object)
+ type (string, required) - {{transaction.lineItem.type}}
+ productId (string, optional) -  {{transaction.lineItem.productId}}
+ variantId (string, optional) - {{transaction.lineItem.variantId}}
+ unitPrice (number, required) -  {{transaction.lineItem.unitPrice}}
+ quantity (number, optional) -  {{transaction.lineItem.quantity}}
+ taxRate (number, optional) - {{transaction.lineItem.taxRate}}
+ tags (array[string], optional) - {{transaction.lineItem.tags}}
+ metadata (object, optional) - {{transaction.lineItem.metadata}}

## LineItemResponse (LineItem)
+ valuesApplied (array[LineItemPromotions])
+ lineTotal (LineTotal)

## LineItemPromotions (object)
+ id (string) - {{value.id}}
+ redemptionRule (string) - {{value.redemptionRule}}
+ ruleExplanation (string) - {{value.ruleExplanation}}
+ amount (number) - The value of the discount.
+ preTax (boolean) - {{value.preTax}}

## LineTotal (object)
+ price (number) - {{transaction.lineItem.lineTotal.price}}
+ taxable (number) - {{transaction.lineItem.lineTotal.taxable}}
+ tax (number) - {{transaction.lineItem.lineTotal.tax}}
+ discount (number) - {{transaction.lineItem.lineTotal.discount}}
+ payable (number) - {{transaction.lineItem.lineTotal.payable}}
