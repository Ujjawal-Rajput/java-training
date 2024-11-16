import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    protected String accountNumber;
    protected String userName;
    protected String accountType;
    protected double balance;

    // Constructor for initializing account details
    public BankAccount(String accountNumber, String userName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance!");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("User Name: " + userName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }
    
    public String fetchAccountNumber(){
        return accountNumber;
    }
}

class UserAccount extends BankAccount {

    // Constructor for UserAccount
    public UserAccount(String accountNumber, String userName, String accountType, double balance) {
        super(accountNumber, userName, accountType, balance);
    }
}

class Admin {
    private ArrayList<UserAccount> userAccounts;

    // Constructor for Admin
    public Admin() {
        userAccounts = new ArrayList<>();
    }

    // Add a new user account
    public void addUserAccount(UserAccount account) {
        userAccounts.add(account);
    }

    public void deleteAllUsers() {
        userAccounts.clear();
    }

    // Display details of all users
    public void displayAllAccounts() {
        if (userAccounts.size() == 0) {
            System.out.println("No accounts to display.");
            return;
        }

        System.out.println("----- All User Accounts -----");
        for (UserAccount account : userAccounts) {
            account.displayAccountDetails();
            System.out.println("--------------------------");
        }
    }
    
    public UserAccount findUser(String accountNumber){
        for (UserAccount account : userAccounts) {
            if (account.fetchAccountNumber().equals(accountNumber)) return account;
        }
        return null;
    }
    
}




public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();

        while (true) {
            System.out.println("================RD-BANK======================================================================");
            System.out.println("Welcome to the Bank System");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            if (choice == 1) {
                System.out.println("Admin Menu:");
                System.out.print("Enter admin password : ");
                String password = scanner.nextLine();
                if (!password.equals("iamadmin")) continue;

                System.out.println("1. View all user accounts");
                System.out.println("2. Delete all users");
                // System.out.println("3. Delete a user");
                int adminChoice = scanner.nextInt();

                if (adminChoice == 1) {
                    admin.displayAllAccounts();
                }
                else if (adminChoice == 2) {
                    admin.deleteAllUsers();
                }
                else continue;

            } else if (choice == 2) {
                System.out.println("1. New user ?");
                System.out.println("2. Old user ?");
                int uchoice = scanner.nextInt();
                scanner.nextLine();
                
                UserAccount user = null;
                if (uchoice == 1) {
                    System.out.println("Enter your name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter account number:");
                    String accNum = scanner.nextLine();
                    System.out.println("Enter account type (Saving/Current):");
                    String accType = scanner.nextLine();
                    System.out.println("Enter initial balance:");
                    double balance = scanner.nextDouble();
    
                    // Create user account and add it to the admin's list
                    user = new UserAccount(accNum, name, accType, balance);
                    admin.addUserAccount(user);
                }
                else if (uchoice == 2){
                    System.out.println("Enter your account number:");
                    String accNumber = scanner.nextLine();

                    // Find existing user and set in user
                    UserAccount u = admin.findUser(accNumber);
                    if (u != null){
                        user = u;
                    }
                    else {
                        System.out.println("Not found !");
                        continue;
                    }
                }
                else continue;
                
                
                
                System.out.println("================= USER ==================");

                System.out.println("Welcome " + user.userName);
                System.out.println("User Menu:");
                while (true) {
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Display Account Details");
                    System.out.println("4. Exit");

                    int userChoice = scanner.nextInt();

                    if (userChoice == 1) {
                        System.out.println("Enter amount to deposit:");
                        double amount = scanner.nextDouble();
                        user.deposit(amount);
                    } else if (userChoice == 2) {
                        System.out.println("Enter amount to withdraw:");
                        double amount = scanner.nextDouble();
                        user.withdraw(amount);
                    } else if (userChoice == 3) {
                        user.displayAccountDetails();
                    } else if (userChoice == 4) {
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}




