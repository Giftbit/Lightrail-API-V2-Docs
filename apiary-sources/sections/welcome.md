# Lightrail Documentation

Welcome to Lightrail V2. Lightrail makes it easy to create gift cards, manage customer account credit, run promotional discount programs, and collect payment all in one unified checkout solution.

## Authentication
Authentication is done via an authorization header. You can retrieve your Lightrail API key [here](https://www.lightrail.com).

In requests to Lightrail you must incldue the following header:
```
Authorization: Bearer <API_KEY>
```

## Errors

Lightrail uses the following HTTP status codes to indicate an error:

| code | meaning |
|------|---------|
| 400  | The request could not be understood.  eg: JSON body could not be parsed. |
| 401  | Authentication missing. |
| 403  | The operation is not allowed for the given authentication. |
| 404  | The resource was not found.  eg: There is no Contact for the given ID. |
| 409  | The operation could not be performed because of the state of the system.  eg: There is not enough balance for a Transaction to complete. |
| 422  | The request was understood but has a logical problem.  eg: Attempting to credit a negative amount. |
| 429  | Too many requests in a given amount of time. |
| 500  | Internal server error.  Please contact support with details of your request and we'll look into it. |

Lightrail errors contain a JSON body with the following properties:

| property    | required | purpose |
|-------------|----------|---------|
| message     | yes      | English explanation of the error.  This is for display purposes only as the explanation may change between system updates for clarity. |
| statusCode  | yes      | The HTTP status code. |
| messageCode | no       | A constant corresponding to the message.  This can be used to take action in response to the error. |

An example:

```json
{
    "message": "Insufficient value for the transaction.",
    "statusCode": 409,
    "messageCode": "InsufficientValue"
}
```

## Support
[Contact us](mailto:hello@lightrail.com) any time if you have any questions.  We're here to help.
