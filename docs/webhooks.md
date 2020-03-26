# Webhooks

<p class= "intro">Get notified when events occur in your Lightrail account.</p>

<br/>

Webhooks can be used to notify your application when an event occurs in your Lightrail account; this enables you to react to events and trigger additional workflows.    

#### What Is a Webhook

A Webhook consists of a list of events it's subscribed to along with a URL where it will deliver matching events. Lightrail delivers events via a simple HTTP request and includes a signature that allows you to verify that it was Lightrail who sent you the notification.

#### When to Use Webhooks

Use webhooks when you want to trigger a reaction or an additional workflow. Webhooks are particularly useful when events occur from actions that weren't performed directly by your application. In such cases, webhooks help keep data in your application consistent with your Lightrail account. 

Examples of such events are:
<ul>
    <li>A new promotion is created within your Lightrail account from one of your team members using the Lightrail web app.</li>
    <li>Pending transactions that are never captured will automatically void via a void transaction.</li>
    <li>A credit card charge in Stripe that originally succeeded is later marked as fradulent (see example below).</li>
</ul>

##### Responding to Changes From Stripe
With Lightrail's integration with Stripe, charges may be successful at the time the checkout transaction is created but can later get marked as fraudulent in Stripe. In the event a charge is marked as fraudulent, Lightrail automatically reverses the checkout transaction and freezes all associated Values in Lightrail, preventing them from being used until unfrozen. In your system, you likely have the notion of an order which corresponds to the checkout transaction in Lightrail. Using Lightrail webhooks, you can listen for reverse transactions an appropriately mark the corresponding orders in your system as reversed. This helps keep data consistency across Stripe, Lightrail, and your application.

#### Creating a Webhook
Webhooks can be created from the [webhooks](https://www.lightrail.com/app/#/account/webhook) section of your Lightrail account. 