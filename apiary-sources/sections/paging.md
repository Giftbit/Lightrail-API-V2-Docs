## Paging

Resources that may contain lots of entries ([Contacts](#reference/0/contacts/list-contacts), [Values](#reference/0/values/list-values), [Programs](#reference/0/programs/list-programs)) may not return all results in a single response.  Instead they return a number of results limited by the `limit` query parameter.

Retrieving results after the first page means following links in the [Link header](https://tools.ietf.org/html/rfc5988).  Here's an example Link header...

```text
(all line-breaks are inserted here for clarity and don't exist in production)

Link:
  <https://api/lightrail.com/v2/contacts?limit=100>;
    rel="first",
  <https://api/lightrail.com/v2/contacts?limit=100&before=eyJpZCI6ImplZmYgaXMgYXdlc29tZSJ9>;
    rel="prev",
  <https://api/lightrail.com/v2/contacts?limit=100&next=eyJpZCI6ImplbiBpcyBhd2Vzb21lIHRvbyJ9>;
    rel="next",
  <https://api/lightrail.com/v2/contacts?limit=100&last=true>;
    rel="last"
```

This example has links to the first page, the previous page, the next page, and the last page.  When already at the first page there will only be links to the next and last.  When already at the last page there will only be links to the first and prev.  If there are no results to page though or only one page there will not be any links.

It's important to follow the links in the Link header and not construct the URLs on your own.
