# Group Promotions

## Promotions [/values/promotions]

A Promotion is [Value](#reference/advanced/values) that is given away to incentivise a purchase. It may be accessed via a code, attached to a [Contact](#reference/0/contacts) or even applied on checkout automatically. It can be `balance`-based such as $5 or `valueRule`-based such as 50% off. A Promotion will typically have a `redemptionRule` that defines when the Promotion applies. 
- **Managing Promotions:** Promotions are typically created and managed based on [Promotion Programs](#reference/promotions/promotion-programs) that define the default parameters for the promotion and how it behaves. 
- **Redeeming Promotions:** Promotions are redeemed by your customers in [checkout](#reference/transactions/transactions/checkout). 

{% include 'endpoints/values-promotions-create.md' %}
{% include 'endpoints/values-promotions-get.md' %}
{% include 'endpoints/values-promotions-update.md' %}
{% include 'endpoints/values-promotions-delete.md' %}
{% include 'endpoints/values-promotions-claim.md' %}
{% include 'endpoints/values-promotions-changeCode.md' %}

## Promotion Programs [/programs/promotions]

Programs define the behaviour of promotional value that you issue. Programs are typically created through the [web app](https://www.lightrail.com/app/#), but an explanation of Programs can be found [below](#reference/advanced/programs) to provide context and insight into how [Values](#reference/advanced/values) function. The following endpoints can be used to manage Promotion Programs. 

{% include 'endpoints/programs-promotions-create.md' %}
{% include 'endpoints/programs-promotions-get.md' %}
{% include 'endpoints/programs-promotions-update.md' %}
{% include 'endpoints/programs-promotions-delete.md' %}
{% include 'endpoints/programs-promotions-issue.md' %}
