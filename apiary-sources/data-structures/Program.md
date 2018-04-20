## Program (object)
+ programId (string, required) - {{program.programId}}
+ name (string, optional) - {{program.name}}
+ currency (string, required) - {{currency}}
+ access (enum[string], required) - How the valueStores can be accessed
    + `customerId` - must be associated with a customerId.
    + `generatedCode` - automatic code generated.
    + `setCode` - a code must be manually set.
+ isSavings (boolean, optional) - {{valueStore.isSavings}}
+ preTax (boolean, optional) - {{valueStore.pretax}}
+ active (boolean, optional) - {{valueStore.active}}
+ redemptionRule (Rule, optional) - {{valueStore.redemptionRule}}
+ valueRule (number, optional) - {{valueStore.valueRule}}
+ minValue (number, optional) - {{program.minValue}}
+ maxValue (number, optional) - {{program.maxValue}}
+ fixedValues (array[number], option) - A list of values the Value Store can be created with.
+ createdDate (string, required) - {{program.createdDate}}
+ updatedDate (string, required) - {{program.updatedDate}}
+ metadata (object, optional) - {{program.metadata}}
