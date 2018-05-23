# Group Giftcards

## Giftcards [/values/giftcards]

A Giftcard is Value that starts as identified by a code.  The code is kept secret and used to access the Value.  A Giftcard can be used anonymously or claimed and attached to a Contact for later use.

{% include 'endpoints/values-giftcards-create.md' %}
{% include 'endpoints/values-giftcards-update.md' %}
{% include 'endpoints/values-giftcards-get.md' %}
{% include 'endpoints/values-giftcards-code-get.md' %}
{% include 'endpoints/values-giftcards-code-set.md' %}
{% include 'endpoints/values-giftcards-code-delete.md' %}
{% include 'endpoints/values-giftcards-contact-get.md' %}
{% include 'endpoints/values-giftcards-contact-claim.md' %}
{% include 'endpoints/values-giftcards-contact-delete.md' %}

### Giftcard Programs [/programs/giftcards]

Programs define the behaviour of Value that you wish to issue: in this case, gift cards. Programs are typically created through the web app, but an overview of the Programs endpoints related to gift cards is included here, and a more detailed explanation of Programs can be found below to provide context and insight into how `Values` function.

{% include 'endpoints/programs-giftcards-create.md' %}
{% include 'endpoints/programs-giftcards-get.md' %}
{% include 'endpoints/programs-giftcards-update.md' %}
{% include 'endpoints/programs-giftcards-delete.md' %}
{% include 'endpoints/programs-giftcards-issue.md' %}
