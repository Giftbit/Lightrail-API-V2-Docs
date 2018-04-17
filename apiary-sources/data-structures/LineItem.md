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
+ someNewField (string) - Blah blah blah
