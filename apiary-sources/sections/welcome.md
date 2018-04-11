# Lightrail Documentation
Welcome to Lightrail V2. Lightrail is a platform for managing value.

Contact us anytime at hello@lightrail.com — we are here to help you solidify your use-case and implementation.         

## Getting Started
[Sign up](https://www.lightrail.com/app/#/register) for a Lightrail account. 

### API Keys and Authorization
Create your API key in the [Integrations](https://www.lightrail.com/app/#/account/api) section of your account. 

To make an API call Lightrail requires the HTTP header `Authorization: Bearer {{API_KEY}}`.

#### Base URL
The base URL for the Lightrail API is `https://api.lightrail.com/v1/`.

#### First Call
To test your authorization use our `ping` endpoint.

```curl https://api.lightrail.com/v1/ping --header "Authorization: Bearer <apiKey>"```

### Testing 
When you first sign into your account you will be in test mode. Test mode is used for development allowing you to build in and test functionality. It comes with sample data to give you a sense of what your Lightrail account will look like. 

## Support
We have [client libraries](https://www.lightrail.com/docs/#client-libraries/client-libraries) in many languages to speed up your integration. 
We also have a sample [Drop-In Gift Card application]((https://github.com/Giftbit/stripe-integration-sample-webapp)) containing examples in JavaScript and PHP with Java and Ruby coming soon.   

Please [contact us](mailto:hello@lightrail.com) any time, we're here to help.
