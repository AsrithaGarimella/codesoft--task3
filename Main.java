import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0.0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class to represent the ATM machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Successfully deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

// Main class to test the ATM functionality
public class Main {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance
        BankAccount account = new BankAccount(500.00);
        System.out.println("Intially you have $500RS in Your Bank Account");
        // Creating an ATM and linking it with the bank account
        ATM atm = new ATM(account);

        // Displaying the ATM menu
        atm.showMenu();
    }
}