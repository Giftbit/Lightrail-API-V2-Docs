## Values [/values]

A Value (naturally) represents value in the Lightrail system.  This includes a gift card, a promotion, a coupon, store credit, etc.  Values can be created one at a time but are most often [issued](#reference/0/issuing-value/issue-values) from a [Program](#reference/0/programs).  Issuing Value from a Program makes it part of that Program which keeps different ways of using Value organized.
 
Most Values will be accessed by a code, or attached to a [Contact](#reference/0/contacts).  All Values attached to a Contact can be used in a [checkout Transaction](#reference/0/transactions/checkout) by only specifying the Contact.

{% include 'compiled/endpoints/values-create.md' %}
{% include 'compiled/endpoints/values-get.md' %}
{% include 'compiled/endpoints/values-update.md' %}
{% include 'compiled/endpoints/values-delete.md' %}
{% include 'compiled/endpoints/values-changeCode.md' %}
