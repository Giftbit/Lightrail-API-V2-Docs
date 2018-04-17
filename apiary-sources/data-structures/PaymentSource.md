## PaymentSource (object)
+ rail (string, required) - The payment rail. Must belong to `[lightrail, stripe]`. Must be used in combination with one of the following identifiers.
+ customerId (string, optional) - The customerId in Lightrail.
+ code (string, optional) - The code of a gift card or promotion.
+ valueStoreId (string, optional) - The ID of a ValueStore.
+ cardToken (string, optional) - A tokenized credit card for Stripe.  