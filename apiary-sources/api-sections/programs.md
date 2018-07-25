## Programs [/programs]

Programs organize [Values](#reference/0/values) and Values can be [issued](#reference/0/issuing-value) from Programs.  Programs are typically created through the web app.

Programs are most commonly used to define and organize promotion campaigns. For example, the Value issued for a new user promotion that gives them a 5% discount on their first purchase should behave differently from the Value for a "TEN-DOLLAR-TUESDAYS" promotion. These different promotions will also need to be tracked and analyzed separately, all of which can happen in the web app.

{% include 'generated/endpoints/programs-create.md' %}
{% include 'generated/endpoints/programs-get.md' %}
{% include 'generated/endpoints/programs-update.md' %}
{% include 'generated/endpoints/programs-delete.md' %}

[Value](#reference/0/values) is usually created by issuing it from a [Program](#reference/0/programs) in the web app. Each block of Values issued at once is tracked as an Issuance. Issuances are tracked for downloading secured codes after creation.

{% include 'generated/endpoints/programs-issuances-create.md' %}
{% include 'generated/endpoints/programs-issuances-get.md' %}
