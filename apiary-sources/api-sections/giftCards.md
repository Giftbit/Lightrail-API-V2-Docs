# Group Gift Cards

## Gift Cards [/values/giftCards]

A Gift Card is a [Value](#reference/advanced/values) that is initially identified by a [code](#reference/codes). The code is kept secret and used to access the Value. A Gift Card can be used anonymously or assigned and attached to a [Contact](#reference/0/contacts) for later use.
- **Managing Gift Cards:** Gift Cards are typically created based on Lightrail's default Gift Card Program, which sets sensible defaults for gift card behaviour. You can also use custom [Gift Card Programs](#reference/promotions/gift-card-programs) to set parameters for particular use cases. 
- **Redeeming Gift Cards:** Gift Cards are redeemed by your customers in [checkout](#reference/transactions/transactions/checkout). 

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
