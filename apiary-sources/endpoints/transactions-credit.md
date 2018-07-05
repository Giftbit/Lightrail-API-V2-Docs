### Credit [POST /transactions/credit]

Credit (add to) a payment destination.  Currently only the `lightrail` rail is supported.

+ Request (application/json)

    + Headers
    
            {{header.authorization}}
        
    + Attributes
        + id (string, required) - {{transaction.id}}  {{transaction.idPurpose}}
        + destination (TransactionParty, required) - The rail to credit.  Only `lightrail` rails that refer to a specific Value are supported.
        + amount (number, required) - The amount to credit, > 0.
        + uses (number, optional) - The number of uses to add.  Defaults to 0.
        + currency (string, required) - {{currency.code}}
        + simulate (boolean, optional) - {{transaction.simulate}}
        + pending (boolean, optional) - {{transaction.pending}}
        + metadata (object, optional) - {{transaction.metadata}}

    + Body

            {
                "id": "unique-id-123",
                "destination": {
                    "rail": "lightrail",
                    "account": "points-account-14314"
                },
                "amount": 2500,
                "currency": "XXX",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
    
+ Response 201 (application/json)

    + Attributes (Transaction)

    + Body

            {
                "id": "unique-id-123",
                "transactionType": "credit",
                "currency": "XXX",
                "steps": [
                    {
                        "rail": "lightrail",
                        "valueId": "points-account-14314",
                        "code": null,
                        "contactId": null,
                        "balanceBefore": 1500,
                        "balanceAfter": 4000,
                        "balanceChange": 2500
                    }
                ],
                "totals": {
                    "remainder": 0                
                },
                "simulated": false,
                "createdDate": "2018-04-17T23:20:08.000Z",
                "updatedDate": "2018-04-17T23:20:08.000Z",
                "metadata": {
                    "note": "Frequent buyer bonus"
                }
            }
