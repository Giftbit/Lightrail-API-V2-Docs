## Program (object)
+ programId (string, required) - {{program.programId}}
+ name (string, optional) - {{program.name}}
+ currency (string, required) - {{currency}}
+ access (enum[string], required) - How the valueStores can be accessed
    + `customerId` - must be associated with a customerId.
    + `secureCode` - a code is generated or supplied and is stored securely.
    + `publicCode` - a code is generated or supplied and can be displayed.
+ discount (boolean, required) - {{valueStore.discount}}
+ preTax (boolean, required) - {{valueStore.preTax}}
+ active (boolean, optional) - {{valueStore.active}}
+ redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
+ valueRule (number, optional) - {{valueStore.valueRule}}
+ minInitialValue (number, optional) - {{program.minValue}}
+ maxInitialValue (number, optional) - {{program.maxValue}}
+ fixedInitialValues (array[number], optional) - A list of values the Value Store can be created with.
+ uses (number, optional) - If set the number of uses the Value Store will be created with.  Set `null` or omit for infinite uses.
+ tags (array[string], optional) - {{tags}}
+ createdDate (string, required) - {{program.createdDate}}
+ updatedDate (string, required) - {{program.updatedDate}}
+ metadata (object, optional) - {{program.metadata}}
