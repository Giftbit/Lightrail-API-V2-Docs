# Lightrail Mental Model

This document describes the primary objects and how they relate to one another in Lightrail.  This is the shared language used in the web app, documents and REST API.

## Meta

The GitHub model of collaboration (offline documents, inline commenting, forking and pull requests) works great for code.  It might also work well for other problems where deep thought is required.  Comment on individual pieces or fork and create an alternate proposal.

This document can become something we save and refer to internally, or something we throw away after we agree on the model, depending on what seems most useful at the time.

## Objects

### Value Template

A Value Template describes how value behaves.  They define:
- currency
- value
- value rule
- pretax (/ post tax)
- redemption rule
- combinability
- number of uses

### Issuance

An Issuance issues Value Stores from a Value Template.  They define:
- access
    - attached to existing customer
    - generated unique codes
    - predefined global code
    - automatic (applied to all checkouts automatically)
- allow anonymous usage (codes only)
- allow claiming (codes only)
- start date
- end date

### Value Store

An instance created from an issuance.  Has all the properties specified by both the template and the issuance.

### Transaction

A transaction moves money in and out of payment rails.  This includes Lightrail Value Stores, Stripe and Square.

There are multiple transaction types:
- order
- credit
- debit
- transfer

All transaction types can be queried together.

### Customer

Our customer's customer.  Has:
- first name
- last name
- email