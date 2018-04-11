## LineItem (object)
+ type (string) - Must belong to "product", "shipping", or "tax".
+ unitCost (number) - The unit cost of the item. 
+ quantity (number, optional) - The number of items. Defaults to 1 if not provided. 
+ taxRate (number, optional) - Tax rate for the item. This is needed when a transaction contains items that have different tax rates.