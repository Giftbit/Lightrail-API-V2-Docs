## Contacts [/contacts/]

Contacts are the people or businesses who buy products or services from you.  They're identified by a unique `id`, which typically corresponds to an existing identifier in your system.

Values can be [attached](#reference/0/contacts/attach-a-contact-to-a-value) to Contacts.  All (applicable) Value attached to a Contact will be used in a [checkout Transaction](#reference/0/transactions/checkout) simply by specifying the Contact checking out.

{% include 'generated/endpoints/contacts-create.md' %}
{% include 'generated/endpoints/contacts-get.md' %}
{% include 'generated/endpoints/contacts-update.md' %}
{% include 'generated/endpoints/contacts-delete.md' %}

{% include 'generated/endpoints/contacts-values-attach.md' %}
{% include 'generated/endpoints/contacts-values-detach.md' %}
{% include 'generated/endpoints/contacts-values-get.md' %}
