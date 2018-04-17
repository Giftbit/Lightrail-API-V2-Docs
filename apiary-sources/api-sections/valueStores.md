## ValueStores [/valueStores/]

### Value Store Types

From investigating transactions with multiple payment sources (gift cards, accounts, promotions, etc) that operate on shopping carts the following properties were identified in order for payment resolution.

```
ValueStore:
- accessed by:
    - unique code
    - generic code
    - customer 
- type of value: 
    - dollar or points value (points is just a different currency). 
    - percent off
- appliesTo:  
    - item 
    - cart
- pretax: 
    - true
    - false
- uses:
    - 1 to unlimted
- type: Usable by biz. Might only affect ordering of pretax=false ValueStores.   
    - GIFT_CARD
    - ACCOUNT (maybe loyalty point becomes a thing)
    - PROMOTION (maybe VOUCHER becomes a thing)
```   

The following table, looks at the primary types of ValueStore in the system and provides sensible defaults for these properties.

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
    <td>Promotion</td>
    <td>unique code<br> 
        generic code<br> 
        customer</td> 
    <td>$ value<br> 
        % off (100% off can represent units)</td>
    <td>1+ or unlimited</td>
    <td>true<br>
        false</td>
    <td>cart<br> 
        items</td> 
    <td>can be limited</td>
    <td></td>
  </tr>
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
  <tr>
    <td>Voucher (functionally this is just a promotion)</td>
    <td></td> 
    <td></td>
    <td></td>
    <td></td>
    <td></td> 
    <td></td>
    <td>This might be how customers view a promotion that is sent C to C</td>
  </tr>
</table>

---
{% include 'endpoints/valueStores-accounts-create.md' %}

{% include 'endpoints/valueStores-giftCards-create.md' %}

{% include 'endpoints/valueStores-promotions-create.md' %}
