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

### Create Payment

`//TODO`

### Check Payment Status

`//TODO`

## Testing
To interact with iDeal in a test mode, you can set `testMode` to `true` on every request.
