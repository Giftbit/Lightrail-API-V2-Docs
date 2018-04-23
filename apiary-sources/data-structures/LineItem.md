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
+ discounts (array[LineItemPromotions])
+ lineTotal (LineTotal)

## LineItemPromotions (object)
+ valueStoreId (string) - {{valueStore.valueStoreId}}
+ redemptionRule (string) - {{valueStore.redemptionRule}}
+ ruleExplanation (string) - {{valueStore.ruleExplanation}}
+ amount (number) - The value of the discount.
+ preTax (boolean) - {{valueStore.preTax}}

## LineTotal (object)
+ price (number) - The total cost of the items. ie `unitPrice * quantity`.
+ taxable (number) - The taxable amount. ie `price - preTaxDiscount`.
+ tax (number) - The taxable amount multiplied by the taxRate for the item. Uses "bankers rounding".
+ discount (number) - The discount
+ payable (number) - The cost of the line item after tax and discounts have been applied.