### Get a Contact [GET /contacts/{id}]

+ Parameter
    + id (string) - the ID of the Contact to get.

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

+ Response 200 (application/json)
    + Attributes (Contact)

    + Body

            {"id":"id_JeffreyLebowski_run14","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-10T22:00:45.000Z","updatedDate":"2018-07-10T22:00:45.000Z"}

### List Contacts [GET /contacts{?limit}{?id}{?tags}{?firstName}{?lastName}{?email}]
        
+ Parameter
    + limit (number, optional) - {{pagination.limit}}
    + id (string, optional) - {{filter.id}}  {{filter.ops.in}}
    + tags (string, optional) - {{filter.tags}}  {{filter.ops.in}}
    + firstName (string, optional) - {{filter.firstName}}  {{filter.ops.string}}
    + lastName (string, optional) - {{filter.lastName}}  {{filter.ops.string}}
    + email (string, optional) - {{filter.email}}  {{filter.ops.string}}

+ Request (application/json)
    + Headers
    
            {{header.authorization}}
    
+ Response 200 (application/json)
    + Headers
        
            Limit: 100
            MaxLimit: 1000
            Link: <URL>; rel="first", <URL>; rel="prev", <URL>; rel="next", <URL>; rel="last"

    + Attributes (array[Contact])

    + Body

            [{"id":"id_JeffreyLebowski_run1","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-05T23:35:06.000Z","updatedDate":"2018-07-05T23:35:06.000Z"},{"id":"id_JeffreyLebowski_run10","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T21:12:12.000Z","updatedDate":"2018-07-10T21:12:12.000Z"},{"id":"id_JeffreyLebowski_run13","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T21:58:32.000Z","updatedDate":"2018-07-10T21:58:33.000Z"},{"id":"id_JeffreyLebowski_run14","firstName":"Jeffrey","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino"},"createdDate":"2018-07-10T22:00:45.000Z","updatedDate":"2018-07-10T22:00:45.000Z"},{"id":"id_JeffreyLebowski_run2","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:28:52.000Z","updatedDate":"2018-07-10T18:28:53.000Z"},{"id":"id_JeffreyLebowski_run3","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:30:17.000Z","updatedDate":"2018-07-10T18:30:17.000Z"},{"id":"id_JeffreyLebowski_run4","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:31:35.000Z","updatedDate":"2018-07-10T18:31:36.000Z"},{"id":"id_JeffreyLebowski_run5","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:33:13.000Z","updatedDate":"2018-07-10T18:33:14.000Z"},{"id":"id_JeffreyLebowski_run6","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:33:51.000Z","updatedDate":"2018-07-10T18:33:51.000Z"},{"id":"id_JeffreyLebowski_run7","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:47:24.000Z","updatedDate":"2018-07-10T18:47:24.000Z"},{"id":"id_JeffreyLebowski_run8","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T18:48:26.000Z","updatedDate":"2018-07-10T18:48:26.000Z"},{"id":"id_JeffreyLebowski_run9","firstName":"The Dude","lastName":"Lebowski","email":"thedude@example.com","metadata":{"alias":"El Duderino","note":"Into the whole 'brevity thing'"},"createdDate":"2018-07-10T20:47:17.000Z","updatedDate":"2018-07-10T20:47:18.000Z"}]