## Contacts [/contacts/]

Contacts are the people or businesses who buy products or services from you.  They're identified by a unique `id`, which typically corresponds to an existing identifier in your system.

Values can be [attached](#reference/0/contacts/attach-value) to Contacts.  All (applicable) Value attached to a Contact will be used in a [checkout Transaction](#reference/0/transactions/checkout) simply by specifying the Contact checking out.

{% include 'endpoints/contacts-create.md' %}
{% include 'endpoints/contacts-get.md' %}
{% include 'endpoints/contacts-update.md' %}
{% include 'endpoints/contacts-delete.md' %}

{% include 'endpoints/contacts-values-get.md' %}
{% include 'endpoints/contacts-values-attach.md' %}
