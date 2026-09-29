package banking;

import java.math.BigDecimal;
import java.math.RoundingMode;

/** Represents one account and enforces the rules for balance changes. */
public final class BankAccount {
    private BigDecimal balance;

    public BankAccount() {
        this(BigDecimal.ZERO);
    }

    public BankAccount(BigDecimal openingBalance) {
        if (openingBalance == null || openingBalance.signum() < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
        balance = openingBalance.setScale(2, RoundingMode.UNNECESSARY);
    }

    public void deposit(BigDecimal amount) {
        requirePositive(amount, "Deposit");
        balance = balance.add(amount.setScale(2, RoundingMode.UNNECESSARY));
    }

    public void withdraw(BigDecimal amount) throws InsufficientFundsException {
        requirePositive(amount, "Withdrawal");
        BigDecimal normalized = amount.setScale(2, RoundingMode.UNNECESSARY);
        if (normalized.compareTo(balance) > 0) {
            throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
        }
        balance = balance.subtract(normalized);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private static void requirePositive(BigDecimal amount, String operation) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException(operation + " amount must be greater than zero.");
        }
        try {
            amount.setScale(2, RoundingMode.UNNECESSARY);
        } catch (ArithmeticException exception) {
            throw new IllegalArgumentException("Amount must have no more than two decimal places.");
        }
    }
}
