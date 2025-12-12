import java.util.Scanner;

// ---------------------- BASE CLASS ACCOUNT ----------------------
class Account {
    String customerName;
    int accNumber;
    String accType;
    double balance;

    // Constructor to initialize account details
    Account(String name, int number, String type, double bal) {
        customerName = name;
        accNumber = number;
        accType = type;
        balance = bal;
    }

    // Deposit money into account
    void deposit(double amount) {
        if (amount <= 0)
            System.out.println("Invalid amount!");
        else {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully.");
        }
    }

    // Display all account details
    void displayBalance() {
        System.out.println("\n------ Account Details ------");
        System.out.println("Name: " + customerName);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Type: " + accType);
        System.out.println("Balance: ₹" + balance);
    }

    // Withdraw money (basic version — overridden in Current Account)
    void withdraw(double amount) {
        if (amount > balance)
            System.out.println("❌ Insufficient balance!");
        else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " successfully.");
        }
    }
}

// ---------------------- SAVINGS ACCOUNT CLASS ----------------------
class Sav_acct extends Account {
    final double rate = 0.05; // 5% interest rate

    // Constructor calls parent constructor
    Sav_acct(String name, int number, double bal) {
        super(name, number, "Savings", bal);
    }

    // Calculate compound interest
    void computeInterest(int years) {
        // CI = P ( (1 + r/n)^(nt) - 1 )
        double ci = balance * Math.pow((1 + rate / 12), 12 * years) - balance;

        balance += ci;  // Add interest to balance

        System.out.println("Interest of ₹" + String.format("%.2f", ci) + " added.");
    }
}

// ---------------------- CURRENT ACCOUNT CLASS ----------------------
class Cur_acct extends Account {
    final double minBalance = 1000.0;         // Minimum required balance
    final double serviceCharge = 100.0;       // Penalty charge

    Cur_acct(String name, int number, double bal) {
        super(name, number, "Current", bal);
    }

    // Deduct service charge if balance drops below minimum
    void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("⚠️ Balance below minimum! Service charge of ₹" + serviceCharge + " imposed.");
        }
    }

    // Withdraw function with additional minimum balance check
    @Override
    void withdraw(double amount) {
        if (amount > balance)
            System.out.println("❌ Insufficient balance!");
        else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " successfully.");
            checkMinimumBalance();   // Check after withdrawal
        }
    }
}

// ---------------------- MAIN CLASS ----------------------
public class BankDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account acc = null;  // Parent class reference

        // --------- Selecting Account Type ---------
        System.out.println("Select Account Type:\n1. Savings Account\n2. Current Account");
        int type = sc.nextInt();
        sc.nextLine();  // consume newline

        // --------- Input user details ---------
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int num = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        // Create appropriate account object
        if (type == 1)
            acc = new Sav_acct(name, num, bal);
        else
            acc = new Cur_acct(name, num, bal);

        int choice;
        boolean firstTime = true;

        // --------- Menu Loop ---------
        do {
            // Print menu only once at the start
            if (firstTime) {
                System.out.println("\n----- Menu -----");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                if (acc instanceof Sav_acct)
                    System.out.println("4. Compute Interest");
                System.out.println("0. Exit");
                firstTime = false;
            }

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            // --------- Menu Switch Case ---------
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    acc.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    acc.withdraw(sc.nextDouble());
                    break;

                case 3:
                    acc.displayBalance();
                    break;

                case 4:
                    // Only for savings account
                    if (acc instanceof Sav_acct) {
                        System.out.print("Enter number of years: ");
                        ((Sav_acct) acc).computeInterest(sc.nextInt());
                    } else {
                        System.out.println("❌ Option not available for Current Account.");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for banking with us!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);   // loop ends when user selects exit

        sc.close();
