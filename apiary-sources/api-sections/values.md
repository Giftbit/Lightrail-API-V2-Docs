## Values [/values]

A Value (naturally) represents value in the Lightrail system.  This includes a gift card, a promotion, a coupon, store credit, etc.  Values can be created one at a time but are most often [issued](#reference/0/issues) from a Program.  Issuing Value from a Program makes it part of that Program which keeps different ways of using Value organized.
 
Most Values will be accessed by a code, or attached to a [Contact](#reference/0/contacts).

{% include 'endpoints/values-create.md' %}
{% include 'endpoints/values-get.md' %}
{% include 'endpoints/values-update.md' %}
{% include 'endpoints/values-delete.md' %}
{% include 'endpoints/values-changeCode.md' %}
