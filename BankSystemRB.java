import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

class BankAccount {
    protected String accountNumber;
    protected String userName;
    protected String accountType;
    protected double balance;

    public BankAccount(String accountNumber, String userName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }

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




public class BankSystemRB {
    public static void main(String[] args) {
        ResourceBundle rb;
        Locale locale;
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin();


        System.out.println("choose your language");
        System.out.println("Enter 1 for english");
        System.out.println("Enter 2 for hindi");
        // System.out.println("Enter 3 for japanese");

        int lchoice = scanner.nextInt();
        if (lchoice==1){
            locale = new Locale("en","US");
        }
        else if (lchoice==2){
            locale = new Locale("hi","IN");
        }
        // else if (lchoice==3){
        //     locale = new Locale("jp","jp");
        // }
        else{
            System.out.println("Invalid input");
            locale = new Locale("en","US");
        }


        rb = ResourceBundle.getBundle("ResourceBundle",locale);

        while (true) {
            System.out.println("================RD-BANK======================================================================");
            System.out.println(rb.getString("WELCOME_BANK"));
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Admin Menu:");
                System.out.print(rb.getString("ADMIN_PASS"));
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
                    // System.out.println("Enter your name:");
                    System.out.println(rb.getString("GET_NAME"));
                    String name = scanner.nextLine();
                    System.out.println(rb.getString("GET_ACC"));
                    String accNum = scanner.nextLine();
                    System.out.println("Enter account type (Saving/Current):");
                    String accType = scanner.nextLine();
                    System.out.println("Enter initial balance:");
                    double balance = scanner.nextDouble();
    
                    user = new UserAccount(accNum, name, accType, balance);
                    admin.addUserAccount(user);
                }
                else if (uchoice == 2){
                    System.out.println(rb.getString("GET_ACC"));
                    String accNumber = scanner.nextLine();

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
                        System.out.println(rb.getString("AMOUNT"));
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




