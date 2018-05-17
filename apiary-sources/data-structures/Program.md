## Program (object)
+ programId (string, required) - {{program.programId}}
+ name (string, optional) - {{program.name}}
+ access (enum[string], required) - How the Values can be accessed.
    + `contact` - must be associated with a Contact.
    + `secureCode` - a code is generated or supplied and is stored securely.
    + `publicCode` - a code is generated or supplied and can be displayed.
+ discount (boolean, required) - {{value.discount}}
+ preTax (boolean, required) - {{value.preTax}}
+ active (boolean, optional) - {{value.active}}
+ redemptionRule (Rule, optional) - {{value.redemptionRule}}
+ valueRule (number, optional) - {{value.valueRule}}
+ minInitialBalance (number, optional) - {{program.minBalance}}
+ maxInitialBalance (number, optional) - {{program.maxBalance}}
+ fixedInitialValues (array[number], optional) - A list of values the Value can be created with.
+ uses (number, optional) - If set the number of uses the Value will be created with.  Set `null` or omit for infinite uses.
+ tags (array[string], optional) - {{tags}}
+ createdDate (string, required) - {{program.createdDate}}
+ updatedDate (string, required) - {{program.updatedDate}}
+ metadata (object, optional) - {{program.metadata}}
