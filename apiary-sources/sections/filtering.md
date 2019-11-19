## Filtering

Resources that may contain lots of entries ([Contacts](#reference/0/contacts/list-contacts), [Values](#reference/0/values/list-values), [Programs](#reference/0/programs/list-programs), [Transactions](#reference/0/transactions)) have filters for retrieving a subset of the entries.

Some query filter properties support operators for more powerful filtering.  The operator is specified after the property and a dot (eg: `balance.ne` for balance not equal to).

| operator | description |
|----------|-------------|
| lt       | Less than (&lt;). |
| lte      | Less than or equal to (&lt;=). |
| gt       | Greater than (&gt;). |
| gte      | Greater than or equal to (&gt;=). |
| eq       | Equal to (==).  This is the default where no operator is specified. |
| ne       | Not equal to (!=). |
| in       | Equals one of the members of a comma-separated list.  Literal commas must be escaped (\\,). |
| like     | Equal to with wildcard support.  Percent signs (%) in the value are wild.  This operator is only supported on string properties. |
| isNull   | Equal to null (true) or not equal to null (false). |
| orNull   | Allows other filters acting on the same property to also include results if the property is equal to null (true), or, not equal to null (false). |

**Examples**

1. List [Contacts](#reference/0/contacts/list-contacts) where `email` equals "mia.wallace@example.com" or "mia_wallace@example.com":
`https://api.lightrail.com/v2/contacts?email.in=mia.wallace@example.com,mia_wallace@example.com`

2. List [Values](#reference/0/values/list-values) where `currency` equals "USD" and `balance` greater than or equal to $10:
`https://api.lightrail.com/v2/values?currency=USD&balance.gte=1000`  

3. List [Contacts](#reference/0/contacts/list-contacts) where `email` address is "like" `%@gmail.com` where `%` acts as a wild card (ie: ends with @gmail.com).
`https://api.lightrail.com/v2/contacts?email.like=%@gmail.com` 

4. List [Programs](#reference/0/programs/list-programs) where `endDate` is greater than date or `null` (ie: filtering for non-expired).
`https://api.lightrail.com/v2/programs?endDate.gt=2019-11-08T12:00:00.000Z&endDate.orNull=true` 
