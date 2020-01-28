## LineItem (object)
+ type (string) - {{transaction.lineItem.type}}
+ unitPrice (number, required) -  {{transaction.lineItem.unitPrice}}
+ productId (string) -  {{transaction.lineItem.productId}}
+ variantId (string) - {{transaction.lineItem.variantId}}
+ quantity (number) -  {{transaction.lineItem.quantity}}
+ taxRate (number) - {{transaction.lineItem.taxRate}}
+ marketplaceRate (number) - {{transaction.lineItem.marketplaceRate}}
+ tags (array[string]) - {{transaction.lineItem.tags}}
+ metadata (object) - {{transaction.lineItem.metadata}}

## LineItemResponse (LineItem)
+ lineTotal (LineTotal)

## LineTotal (object)
+ subtotal (number) - {{transaction.lineItem.lineTotal.subtotal}}
+ taxable (number) - {{transaction.lineItem.lineTotal.taxable}}
+ tax (number) - {{transaction.lineItem.lineTotal.tax}}
+ discount (number) - {{transaction.lineItem.lineTotal.discount}}
+ sellerDiscount (number) - {{transaction.lineItem.lineTotal.sellerDiscount}}
+ remainder (number) - {{transaction.lineItem.lineTotal.remainder}}
+ payable (number) - {{transaction.lineItem.lineTotal.payable}}
