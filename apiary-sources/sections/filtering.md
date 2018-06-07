## Filtering

Resources that may contain lots of entries ([Contacts](#reference/0/contacts/list-contacts), [Values](#reference/0/values/list-values), [Programs](#reference/0/programs/list-programs)) have powerful filters for retrieving a subset of the entries.

Some properties such as `id` and `tag` can be filtered with a comma separated list in which case one of the values in the list must match.  For example `https://api.lightrail.com/v2/contacts?tags=gold,silver` searches for [Contacts](#reference/0/contacts/list-contacts) tagged `gold` **or** `silver`. 

Some properties support operators for more powerful filtering than matching an exact value.  The operator is specified after the property and a dot.  For example `https://api.lightrail.com/v2/values?currency=USD&balance.gte=1000` searches for [Values](#reference/0/values/list-values) in the `USD` `currency` with a `balance` greater than or equal to $10.  In another example `https://api.lightrail.com/v2/contacts?email.like=%@gmail.com` searches for [Contacts](#reference/0/contacts/list-contacts) whose email address is "like" `%@gmail.com` where `%` acts as a wild card (ie: ends with @gmail.com).

| operator | description |
|----------|-------------|
| lt       | Less than (&lt;). |
| lte      | Less than or equal to (&lt;=). |
| gt       | Greater than (&gt;). |
| gte      | Greater than or equal to (&gt;=). |
| eq       | Equal to (=).  This is the default where no operator is specified. |
| ne       | Not equal to (!=). |
| like     | Equal to with wildcard support.  Percent signs (%) in the value are wild.  This operator is only supported on string properties. |