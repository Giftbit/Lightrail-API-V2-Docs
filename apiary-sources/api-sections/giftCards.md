# Group Gift Cards

## Gift Cards [/values/giftCards]

A Gift Card is Value that starts as identified by a code.  The code is kept secret and used to access the Value.  A Gift Card can be used anonymously or claimed and attached to a Contact for later use.

{% include 'endpoints/values-giftCards-create.md' %}
{% include 'endpoints/values-giftCards-get.md' %}
{% include 'endpoints/values-giftCards-update.md' %}
{% include 'endpoints/values-giftCards-claim.md' %}
{% include 'endpoints/values-giftCards-changeCode.md' %}

### Gift Card Programs [/programs/giftCards]

Programs define the behaviour of Value that you wish to issue: in this case, gift cards. Programs are typically created through the web app, but an explanation of Programs can be found [below](#reference/advanced/programs) to provide context and insight into how `Values` function. The following endpoints can be used to manage Gift Card Programs. 

{% include 'endpoints/programs-giftCards-create.md' %}
{% include 'endpoints/programs-giftCards-get.md' %}
{% include 'endpoints/programs-giftCards-update.md' %}
{% include 'endpoints/programs-giftCards-delete.md' %}
{% include 'endpoints/programs-giftCards-issue.md' %}
