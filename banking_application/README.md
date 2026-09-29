# Banking Application

A menu-driven Java console program demonstrating basic account operations, encapsulation, amount validation, and exception handling.

## Features

- Deposit positive amounts and show the updated balance.
- Withdraw only when the account has sufficient funds.
- Check the current balance.
- Reject malformed, zero, negative, and over-precision amounts.

## Compile and run

Requires JDK 17 or newer. From this directory, run:

```powershell
javac -d out src\banking\*.java
java -cp out banking.Main
```

No external libraries are required.

## Source files

The Java sources are under [`src/banking`](src/banking/). Eclipse Console screenshots are in [`../screenshots/banking_application`](../screenshots/banking_application/).
