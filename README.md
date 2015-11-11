
#Important note:

This library is deprecated. Please use the [mollie-api](https://github.com/stil4m/mollie-api).

---

# iDeal API


## License

The source code is licensed under the `Apache License, Version 2.0`.

## Dependencies

* `org.apache.httpcomponents:httpclient:4.3.1`


## Maven
This library is available on my [personal maven repository](https://github.com/stil4m/maven-repository).

### Repository
```
<repository>
    <id>stil4m-releases</id>
    <name>stil4m-releases</name>
    <url>https://github.com/stil4m/maven-repository/raw/master/releases/</url>
</repository>
```

### Artifact
```
<depencency>
    <groupId>nl.stil4m</groupId>
    <artifactId>ideal-api</artifactId>
    <version>1.0.0</version>
</depencency>
```

## Setup
To use the iDeal API you should create a instance of `Ideal`.

The `Ideal` constructor requires two arguments, your partner id and an instance that is of the type `RequestExecutor`. The `RequestExecutor` performs the actual requests to the iDeal system. You can configure this instance to use another endpoint for testing purposes.

## Test mode
To enable testmode you can call the `setTestMode` method on the iDeal instance.


## Flow

1. Retrieve banks
2. Create Payment.
3. Check Payment Status.


### Retrieve banks

```
Ideal ideal = new Ideal(...)
...
List<Bank> banks = ideal.getBanks();
```

This will result in a list of banks containing a name and an id.

### Create Payment

```
Ideal ideal = new Ideal(...)
...
Order order = ideal.createPayment(123, "EUR", banks.get(0).getBankId(), "System Test", "http://www.example.org", "http://www.google.com");
```

### Check Payment Status

To check the status of a payment you must use the transaction id that was returned in the `Order` (the result of the create payment).
 
```
Ideal ideal = new Ideal(...)
...
CheckOrder result = ideal.checkPayment(order.getTransactionId());
```

## Reference

- [Mollie API reference][1]


[1]: http://www.mollie.nl/support/documentatie/betaaldiensten/ideal