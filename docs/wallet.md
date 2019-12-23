# Wallet

<p class="intro">Lightrail enables the concept of a Wallet. A Wallet is a framework for thinking about all Customer Value that is attached to a given user.</p> 

<table class="no-border">
    <tr>
        <td>
            <img alt="wallet" style="width: 200px" src="https://raw.githubusercontent.com/Giftbit/Lightrail-API-V2-Docs/developement/docs/assets/wallet.png" />
        </td>
        <td>
            <p>Examples of Customer Value that could be in a Wallet are:</p>
            <ul>
                <li>Upon signing up your service, a user receives a one-time discounts of 20% off their first purchase</li>
                <li>They were given a giftcard for their birthday and redeem the code to their profile/Wallet</li>
                <li>They referred a friend and earned $50 in store credit</li>
                <li>They endorse social posts by tagging friends earn loyalty point</li>
            </ul>
        </td>
    </tr>
</table>

<br/>

Lightrail enables the ability to easily attach Value to your customers. This can be done from Webapp, REST API, or during a checkout transaction step. 

#### Manually Attach

For example, in the Webapp you can search for Contact and select “Attach Value”. This can be a newly created on-demand Value or an existing Value. A good example of this would be a user contacting Customer Support to report an issue they were having with purchasing a product. A Customer Support representative could look up the user, and immediately attach a Value (say 15% off their next purchase) to their account from a “Customer Support Issues Program”. 

#### Programatically Attach

As mentioned above you can also attach Value, or trigger, a Direct-to-wallet promotion programatically when a user takes a certain action. Let’s say that you’re offering a promotion for returning/logged in users when they make a purchase of $100 or more. In your shopping cart you would need to listen for an event like this and trigger (via API call) a Direct-to-wallet promotion to be attached to the user. You would then need to notify your user using your existing channels, whether that be in-app after they’ve checked out or via email, etc.
