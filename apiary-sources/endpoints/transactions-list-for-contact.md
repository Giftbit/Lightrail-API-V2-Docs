### List Transactions for a Contact [GET /transactions{?tag=contactId:{id}}{?limit}{?transactionType}{?createdDate}{?currency}{?valueId}]

Transactions are automatically tagged with the ID of any Contact involved in the Transaction. These tags are an array of strings in the following format: `["contactId:contact-123"]`. 

Contacts can be involved in Transactions in two ways: either their contactId is supplied as a payment source (checkout transactions only), or a Value attached directly to the Contact is supplied by code or valueId as a payment source/destination. Transactions will be tagged with multiple contactIds if multiple Contacts are involved this way. 

If a Transaction is charged entirely to a credit card or to an unattached Value, the Transaction will still be tagged with the ID of any Contacts whose IDs or attached Values were supplied as payment sources. This means that you can associate Transactions with a Contact even if they have no attached Values, or their attached Values are frozen or have no remaining balance, or even if a Lightrail Contact does not yet exist and you are simply passing in a customer's ID from your external system. 

Transactions farther down the Transaction Chain will inherit the tags of the original Transaction. For example, if a customer checks out and their contactId is supplied as a payment source but they have no attached Values, the entire amount will be charged to their credit card. If that Transaction is reversed, the `reverse` Transaction will also be tagged with the contactId. 

In the edge case where a Value gets attached to a Contact after the first Transaction has happened (example: a customer checks out anonymously with a gift code, and later attaches it to their account so they can use the remaining balance without typing in the code again), the contactId will appear on Transactions farther down the chain, but the tags on the original Transaction will not be modified. 

All other [List Transactions](#reference/0/transactions/list-transactions) filter parameters can also be used in conjunction with the tag filter. 

+ Parameter
    + tag (string, optional) - The ID of the Contact to get Transactions for. Tag will be in the format `contactId:contact-123`. 

+ Request (application/json)
    + Headers

            {{header.authorization}}

+ Response 200 (application/json)
    + Headers

            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"

    + Attributes (array[Transaction])

    + Body
            // TODO - THIS
            {REQUEST_REPLACEMENT:listTransactions1.response.body}
