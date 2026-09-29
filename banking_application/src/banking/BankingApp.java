package banking;

import java.math.BigDecimal;
import java.util.Scanner;

/** Runs the interactive menu and translates user input into account actions. */
public final class BankingApp {
    private final BankAccount account;
    private final Scanner scanner;

    public BankingApp(Scanner scanner) {
        this.account = new BankAccount();
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Banking Application ===");
            System.out.println("1. Deposit\n2. Withdraw\n3. Balance inquiry\n4. Exit");
            switch (readMenuChoice()) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> displayBalance();
                case 4 -> {
                    System.out.println("Thank you for using the Banking Application.");
                    running = false;
                }
                default -> System.out.println("Choose an option from 1 to 4.");
            }
        }
    }

    private int readMenuChoice() {
        System.out.print("Enter your choice: ");
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

    private BigDecimal readAmount(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try {
            return new BigDecimal(line);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private void deposit() {
        BigDecimal amount = readAmount("Enter deposit amount: ");
        if (amount == null) {
            System.out.println("Invalid input. Please enter a numeric amount.");
            return;
        }
        try {
            account.deposit(amount);
            System.out.println("Deposit successful.");
            displayBalance();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void withdraw() {
        BigDecimal amount = readAmount("Enter withdrawal amount: ");
        if (amount == null) {
            System.out.println("Invalid input. Please enter a numeric amount.");
            return;
        }
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful.");
            displayBalance();
        } catch (IllegalArgumentException | InsufficientFundsException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void displayBalance() {
        System.out.printf("Current Balance: %,.2f%n", account.getBalance());
    }
}
