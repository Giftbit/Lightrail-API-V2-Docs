### Create an Account [POST /valueStores/accounts]

<table style="width:100%">
  <tr>
    <th>type</th>
    <th>accessed by</th> 
    <th>type of value</th>
    <th>uses</th>
    <th>preTax</th>
    <th>appliesTo</th>
    <th>exclusivity</th>
    <th>assumptions</th>
  </tr>
  <tr>
    <td>Account</td>
    <td>customer</td> 
    <td>$ value</td>
    <td>unlimited</td>
    <td>false</td>
    <td>cart</td> 
    <td>not limited</td>
    <td>maybe one account per customer per currency?</td>
  </tr>
  <tr>
    <td>Loyalty Point (probably just an account in a different currency)</td>
    <td>customer</td> 
    <td>$ value</td>
    <td>unlimited</td>
    <td>false</td>
    <td>cart</td> 
    <td>not limited</td>
    <td>-accrues on purchase<br>-converted to account $ or redeemable for units<br>-Conversion rate?<br>-Linked to membership tiers: get more points per purchase at higher tiers</td>
  </tr>
</table>

+ Request (application/json)
    + Headers
    
            {{header.authorization}}

    + Attributes
        + valueStoreId (string, required) - {{valueStore.valueStoreId}}\
        + currency (string, required) - {{currency}}
        + value (number, required) - {{valueStore.value}}
        + expires (string, optional) - {{valueStore.expires}}
        + active (boolean, optional) - {{valueStore.active}}
        
    + Body 
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500,
                "accessedBy": [
                    {
                        "customerId": "cus_123"
                    }
                ]
            }
    
+ Response 200

    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500, 
                "type": "ACCOUNT",
                "preTax": false,
                "appliesTo": "cart",
                "expires": "never",
                "active": true,
                "accessedBy": [
                    {
                        "customerId": "cus_123"        
                    },
                    {
                        "customerId": "cus_456"        
                    }
                ]
            }