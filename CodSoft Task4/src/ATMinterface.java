import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds or invalid amount for withdrawal.");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
                break;

            case 3:
                System.out.println("Current balance: " + bankAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM object and connect it to the user's bank account
        ATM atm = new ATM(userAccount);

        // Main ATM loop
        while (true) {
            // Display ATM menu
            atm.displayMenu();

            // Get user input for menu option
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int option = scanner.nextInt();

            // Process user's chosen option
            atm.processOption(option);
        }
    }
}
