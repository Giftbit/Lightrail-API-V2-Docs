## LineItem (object)
+ type (string, required) - Must be either `product`, `shipping` or `fee`.
+ productId (string, optional) - The ID of the product. 
+ variantId (string, optional) - The variant ID of a product. (Can be used to store SKU.)
+ unitPrice (number, required) - The unit price of the item. 
+ quantity (number, optional) - The number of items. Defaults to 1 if not provided. 
+ taxRate (number, optional) - Tax rate for the item. This is needed when a transaction contains items that have different tax rates.
+ tags (array[string], optional) - A list of tags associated with the item. For example, "seasonal" or "clothing".
+ metadata (object, optional) - Any additional data you want to store for the item.

## LineItemResponse (LineItem)
+ promotions (array[LineItemPromotions])
+ lineTotal (LineTotal)

## LineItemPromotions (object)
+ valueStoreId (string) - The ID of the ValueStore.
+ rule (string) - The redemption rule.
+ ruleExplanation (string) - Description of the rule.
+ amount (number) - How value of the promotion.
+ pretax (boolean) - Whether the ValueStore applies before or after tax.

## LineTotal (object)
+ price (number) - The total cost of the items. ie `unitPrice * quantity`.
+ pretaxDiscount (number) - The discount before tax is calculated.
+ taxable (number) - The taxable amount. ie `price - pretaxDiscount`.
+ tax (number) - The taxable amount multiplied by the taxRate for the item. Uses "bankers rounding".
+ postTaxDiscount (number) - The discount after tax has been added.
+ payable (number) - The cost of the line item after tax and discounts have been applied.