# Group Promotions

## Promotions [/values/promotions]

A Promotion is Value that is given away to incentivise a purchase.  It may be accessed via a code, attached to a Contact or even applied on checkout automatically.  It can be balance-based such as $5 or valueRule-based such a 50% off.  A Promotion will typically have a redemption rule that defines when the Promotion applies. 

{% include 'endpoints/values-promotions-create.md' %}
{% include 'endpoints/values-promotions-get.md' %}
{% include 'endpoints/values-promotions-update.md' %}
{% include 'endpoints/values-promotions-delete.md' %}
{% include 'endpoints/values-promotions-claim.md' %}
{% include 'endpoints/values-promotions-changeCode.md' %}

## Promotion Programs [/programs/promotions]

Programs define the behaviour of Value that you wish to issue: in this case, promotions. Programs are typically created through the web app, but an overview of the Programs endpoints related to promotions is included here, and a more detailed explanation of Programs can be found below to provide context and insight into how `Values` function.

{% include 'endpoints/programs-promotions-create.md' %}
{% include 'endpoints/programs-promotions-get.md' %}
{% include 'endpoints/programs-promotions-update.md' %}
{% include 'endpoints/programs-promotions-delete.md' %}
{% include 'endpoints/programs-promotions-issue.md' %}
