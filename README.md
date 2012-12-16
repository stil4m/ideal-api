# iDeal API

## Setup
To use the iDeal API you should create a instance of `Ideal`.

The `Ideal` constructor requires at least one argument that is of type `RequestExecutor`. You can use a `DefaultRequestExecutor` instance.


## Flow

1. Retrieve banks
2. Create Payment.
3. Check Payment Status.


### Retrieve banks
To retrieve the banks, you can `execute` a `BanksRequest` on the `Ideal` instance.

```
Ideal ideal = new Ideal(...)
BanksResponse banksResponse = ideal.execute(new BanksRequest());
```

This will result in a list of banks containing a name and a id.

### Create Payment

To create a payment, you can `execute` a `FetchModeRequest` on the `Ideal` instance.


```
Ideal ideal = new Ideal(...)
FetchModeRequest request = new FetchModeRequest(partnerId, amount, bankId, description, reportUrl, returnUrl) {
FetchModeResponse fetchModeResponse = ideal.execute(request);
```
The table below will provide more infomation about the parameters that are used in the `FetchModeRequest`.

<table>
  <tr>
    <th>Argument</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>partnerId</td>
    <td>The partnerId is a ID provided by iDeal that identifies the API consumer.</td>
  </tr>
  <tr>
    <td>amount</td>
    <td>The amount in Euro cents.</td>
  </tr>
  <tr>
    <td>bankId</td>
    <td>The reference to the bank that should process the payment. The allowed banks can be requested with a `BanksRequest`.</td>
  </tr>
  <tr>
    <td>description</td>
    <td>The description that will be noted on the bank transaction.</td>
  </tr>
  <tr>
    <td>reportUrl</td>
    <td>A url that will be called with a HTTP GET request when the status of the payment changes from `Open` to another state. This new state can be obtained by performing a `CheckRequest`. Ideal does not add the state as a argument to the HTTP GET request. The only argument is the `transactionId`.</td>
  </tr>
  <tr>
    <td>returnUrl</td>
    <td>This url will be used to redirect the clients browser after the customer fullfills the payment at the bank.</td>
  </tr>
</table>



### Check Payment Status

`//TODO`

## Testing
To interact with iDeal in a test mode, you can set `testMode` to `true` on every request.

## Reference

- [Mollie API reference][1]


[1]: http://www.mollie.nl/support/documentatie/betaaldiensten/ideal