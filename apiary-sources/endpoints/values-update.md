### Update a Value [PATCH /values/{id}]

+ Parameter
    + id (string) - the ID of the Value to modify.

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + canceled (boolean, optional) - {{value.canceled}}
        + preTax (boolean, optional) - {{value.preTax}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + tags (array[string], optional) - {{tags}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "frozen": true
            }
    
+ Response 200 (application/json)
    + Attributes (Value)

    + Body
    
            {
                "id": "vs-1",
                "programId": "springpromo",
                "currency": "USD",
                "balance": 2500, 
                "active": true,
                "frozen": true,
                "canceled": false,
                "preTax": false,
                "redemptionRule": null,
                "valueRule": null,
                "uses": null,
                "startDate": null,
                "endDate": null,
                "tags": [],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:58:19.036Z"
            }

### Update Values [PATCH /values{?id}{?programId}{?currency}{?contactId}{?balance}{?uses}{?discount}{?active}{?frozen}{?canceled}{?preTax}{?startDate}{?endDate}{?createdDate}{?updatedDate}{?tags}]]

Bulk update all Values that match the given query parameters.
        
+ Parameter
    + id (string, optional) - {{filter.id}}  {{filter.list}}
    + programId (string, optional) - {{filter.programId}}  {{filter.list}}
    + currency (string, optional) - {{filter.currency}}  {{filter.list}}
    + contactId (string, optional) - {{filter.contactId}}  {{filter.list}}
    + balance (number, optional) - {{filter.balance}}  {{filter.ops.number}}
    + uses (number, optional) - {{filter.uses}}  {{filter.ops.number}}
    + discount (boolean, optional) - {{filter.discount}}
    + active (boolean, optional) - {{filter.active}}
    + frozen (boolean, optional) - {{filter.frozen}}
    + canceled (boolean, optional) - {{filter.canceled}}
    + preTax (boolean, optional) - {{filter.preTax}}
    + startDate (string, optional) - {{filter.startDate}}  {{filter.ops.date}}
    + endDate (string, optional) - {{filter.endDate}}  {{filter.ops.date}}
    + createdDate (string, optional) - {{filter.createdDate}}  {{filter.ops.date}}
    + updatedDate (string, optional) - {{filter.updatedDate}}  {{filter.ops.date}}
    + tags (string, optional) - {{filter.tags}}  {{filter.list}}

+ Request (application/merge-patch+json)

    {{patch.merge}}

    + Headers
    
            {{header.authorization}}

    + Attributes
        + active (boolean, optional) - {{value.active}}
        + frozen (boolean, optional) - {{value.frozen}}
        + canceled (boolean, optional) - {{value.canceled}}
        + preTax (boolean, optional) - {{value.preTax}}
        + redemptionRule (Rule, optional) - {{value.redemptionRule}}
        + valueRule (Rule, optional) - {{value.valueRule}}
        + startDate (string, optional) - {{value.startDate}}
        + endDate (string, optional) - {{value.endDate}}
        + metadata (object, optional) - {{value.metadata}}
        
    + Body
    
            {
                "frozen": true
            }
    
+ Response 200 (application/json)
    + Headers
        
    + Attributes
        + count (number) - The number of Values updated.

    + Body

            {
                "count": 23
            }
