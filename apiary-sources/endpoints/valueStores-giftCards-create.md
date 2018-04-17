### Create Gift Card [POST /valueStores/giftCards]

<table style="width:100%">
  <tr>
    <td>Gift Card</td>
    <td>unique code<br> 
        customer</td> 
    <td>$ value</td>
    <td>unlimited</td>
    <td>false</td>
    <td>cart</td> 
    <td>not limited</td>
    <td>GC is sent: interaction between 2 customers</td>
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
                        "code": "MY-OWN-CODE"
                    }
                ]
            }
    
+ Response 200

    + Body
    
            {
                "valueStoreId": "vs-1",
                "currency": "USD",
                "value": 2500, 
                "type": "GIFT_CARD",
                "accessedBy": [
                    {
                        "code": "MY-OWN-CODE"        
                    }
                ]
            }