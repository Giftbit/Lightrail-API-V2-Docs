# Object Model

<p class= "intro"> Lightrail's API and web app enables you to create and manage all types of customer value: promotions, gift cards, referral credits, refund credits, and loyalty points. Within Lightrail, these are stored as what we call a Value.</p>

### Values

Values are the core financial object in Lightrail. Values can have a `balance` or a `balanceRule`, which can be used to represent percentage discounts or more sophisticated promotions. See our [Balance Rule documentation](#use-cases/redemption-rules-and-balance-rules) for more information. 

Values have a `usesRemaining` property indicating how many times they can be used. Many promotions are single-use, whereas a gift card can be used indefinitely until its balance is empty. 

Values can also have `redemptionRules`, which enable sophisticated promotions. For example, you may want a promotion to apply to a particular product SKU or the promotion to apply only if the subtotal is above a certain amount. See our [Redemption Rule documentation](#use-cases/redemption-rules-and-balance-rules) for more information.

### Programs

#### Creating and Organizing Values

Programs act as a template for creating new Values. So, for the different types of Values you create within Lightrail, it is recommended to create them from different Programs. Programs provide a template for all the Values that are created within that Program. Programs also enable organization and aggregated statistics on Values. Programs make it easy to see how a particular promotion you're running is performing. Programs are created through the web app or API. 

### Contacts

Contacts represent your customers. Contacts can have Values attached to them, which enables you to easily create a customer wallet for them in your app or service. By attaching Values to a Contact, all customer value (promotions, gift cards, loyalty points, etc.) that the customer may have is centralized in one place. Attached Values make multi-tender payments easy for you to build and also create a frictionless payment experience for your customer. You need to provide the Contact identifier as a payment source in the Checkout Transaction. Doing so causes any applicable Values they have to be considered for the transaction.

 
### Object Model Diagram

<img style="width: 500px" src="https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/master/docs/assets/object-model.png" alt="Object Model Diagram" />
