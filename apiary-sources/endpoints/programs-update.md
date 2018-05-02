### Update a Program [PATCH /programs/{programId}]

Update a Program by programId.  Update fields that are sent and leave unspecified values unchanged.

Value Stores that have already been created will not be changed.

+ Parameter
    + programId (string) - the programId of the Program to modify.

+ Request (application/merge-patch+json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + programId (string, optional) - {{program.programId}}  If present must match the programId in the path.
        + active (boolean, optional) - {{valueStore.active}}
        + minInitialValue (number, optional) - {{program.minInitialValue}}
        + maxInitialValue (number, optional) - {{program.maxInitialValue}}
        + fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
        + tags (array[string], optional) - {{tags}}
        + metadata (number, optional) - {{program.metadata}}
        
    + Body
    
            {
                "tags": ["internal"]
            }
    
+ Response 200 (application/json)
    + Attributes (Program)

    + Body
    
            {
                "programId": "unique-id-123",
                "name": "Giftcard programm",
                "currency": "CAD",
                "access": "generatedCode",
                "discount": "false",
                "preTax": "false",
                "active": "true",
                "redemptionRule": null,
                "valueRule": null,
                "minInitialValue": null,
                "maxInitialValue": null,
                "fixedInitialValues": [
                    500,
                    1500,
                    2500
                ],
                "uses": null,
                "tags": ["internal"],
                "metadata": null,
                "createdDate": "2018-04-17T23:20:08.404Z",
                "updatedDate": "2018-04-17T23:20:08.404Z"
            }
