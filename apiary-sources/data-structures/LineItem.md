## LineItem (object)
+ type (string, required) - Must be either `product`, `shipping`, or `tax`.
+ productId (string, optional) - If the type is `product` productId must be provided.
+ unitCost (number, required) - The unit cost of the item. 
+ quantity (number, optional) - The number of items. Defaults to 1 if not provided. 
+ taxRate (number, optional) - Tax rate for the item. This is needed when a transaction contains items that have different tax rates.
+ description (string, optional) - Description for the item.

## LineItemResponse (LineItem)
+ someNewField (string) - Blah blah blah
