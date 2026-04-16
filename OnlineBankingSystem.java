package onlinebankingsystem;
import java.util.Scanner;
class BankAccount {
    private String username = "admin";
    private String password = "1234";
    private double balance = 1000;

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
        printReceipt("Deposit", amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            printReceipt("Withdraw", amount);
        }
    }

    public void checkBalance() {
        System.out.println("Balance: ₹" + balance);
    }

    public void printReceipt(String type, double amount) {
        System.out.println("\n--- Receipt ---");
        System.out.println("Type: " + type);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Balance: ₹" + balance);
        System.out.println("----------------\n");
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount();

        System.out.println("=== BANK LOGIN ===");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!acc.login(user, pass)) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Login Successful!\n");

        int choice;
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    acc.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}