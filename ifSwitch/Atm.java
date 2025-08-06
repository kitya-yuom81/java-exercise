
package ifSwitch;

import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.0;
        int choice;

        System.out.println("🔐 Welcome to Simple ATM 🔐");



        // Keep showing menu until user chooses to exit
        while (true) {
            System.out.println("\n======================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Check balance
                    System.out.println("💰 Your current balance is: $" + balance);
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("✅ Deposited successfully. New balance: $" + balance);
                    } else {
                        System.out.println("❌ Invalid amount. Must be greater than 0.");
                    }
                    break;

                case 3:
                    // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println("❌ Invalid amount. Must be greater than 0.");
                    } else if (withdraw > balance) {
                        System.out.println("❌ Insufficient balance.");
                    } else {
                        balance -= withdraw;
                        System.out.println("✅ Withdrawal successful. Remaining balance: $" + balance);
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("👋 Thank you for using Simple ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Please choose 1–4.");
            }
        }
    }
}

