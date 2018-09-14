## Issuance (object)
+ id (string, required) - {{issuance.id}}  {{issuance.idPurpose}}
+ programId (string) - {{issuance.programId}}
+ count (number) - {{issuance.count}}
+ codeGeneration (CodeGeneration) - {{issuance.generateCode}}
+ code (string) - {{issuance.code}}
+ isGenericCode (boolean) - {{issuance.isGenericCode}}
+ balance (number) - {{issuance.balance}}
+ uses (number) - (Deprecated. Use `usesRemaining` instead.)  
+ usesRemaining (number) - {{issuance.uses}}  
+ startDate (string) - {{issuance.startDate}}
+ endDate (string) - {{issuance.endDate}}
+ redemptionRule (Rule) - {{issuance.redemptionRule}}
+ valueRule (Rule) - (Deprecated. Use `balanceRule` instead.)
+ balanceRule (Rule) - {{issuance.balanceRule}}
+ tags (array[string]) - {{tags}} These are applied to each Value.
+ metadata (object) - {{issuance.metadata}}
+ createdDate (string) - {{createdDate}}
+ updatedDate (string) - {{updatedDate}}
