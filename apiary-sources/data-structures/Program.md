## Program (object)
+ id (string, required) - {{program.id}}
+ name (string, optional) - {{program.name}}
+ type (enum[string], required) - {{program.type}}
+ currency (string, required) - {{currency.code}}
+ access (enum[string], required) - How the values can be accessed.
    + `contact` - must be associated with a contact.
    + `secureCode` - a code is generated or supplied and is stored securely.
    + `publicCode` - a code is generated or supplied and can be displayed.
+ discount (boolean, required) - {{value.discount}}
+ preTax (boolean, required) - {{value.preTax}}
+ active (boolean, optional) - {{value.active}}
+ redemptionRule (Rule, optional) - {{value.redemptionRule}}
+ valueRule (Rule, optional) - {{value.valueRule}}
+ minInitialBalance (number, optional) - {{program.minBalance}}
+ maxInitialBalance (number, optional) - {{program.maxBalance}}
+ fixedInitialBalances (array[number], optional) - {{program.fixedInitialBalances}}
+ uses (number, optional) - {{program.uses}}
+ tags (array[string], optional) - {{tags}}
+ startDate (string, optional) - {{program.startDate}}
+ endDate (string, optional) - {{program.endDate}}
+ createdDate (string, required) - {{program.createdDate}}
+ updatedDate (string, required) - {{program.updatedDate}}
+ metadata (object, optional) - {{program.metadata}}
