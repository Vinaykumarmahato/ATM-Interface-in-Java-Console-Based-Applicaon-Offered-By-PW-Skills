import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Transaction {
    private String type;
    private double amount;


    
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    

    @Override
    
    public String toString() {
        return type + " $" + amount;

        
    }

    
}

class Account {
    
    private String accountNumber;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;
    

    public Account(String accountNumber, String pin, double initialBalance) {
        
        this.accountNumber = accountNumber;
        
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        
    }

    
    public void deposit(double amount) {
        
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            
        }
    }

    public void withdraw(double amount) {
        
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount));
            
        }
        
    }

    public double getBalance() {
        
        return balance;
    }

    public String getAccountNumber() {
        
        return accountNumber;
    }

    public String getPin() {
        
        return pin;
    }

    public List<Transaction> getTransactionHistory() {
        
        return transactionHistory;
    }
}

public class ATMInterfaceInJavaConsoleBasedApplicaonOfferedByPWSkills {
    
    private static Map<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        
        initializeAccounts();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");
        
        System.out.print("Enter your account number: ");
        
        String accountNumber = scanner.nextLine();
        

        System.out.print("Enter your PIN: ");
        
        String pin = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        

        if (account != null && pin.equals(account.getPin())) {
            
            System.out.println("Login successful.");
            
            boolean exit = false;

            while (!exit) {
                
                System.out.println("\nSelect an option:");
                
                System.out.println("1. Check Balance");
                
                System.out.println("2. Deposit Funds");
                
                System.out.println("3. Withdraw Funds");
                
                System.out.println("4. View Transaction History");
                
                System.out.println("5. Exit");
                
                System.out.print("Enter your choice: ");
                

                int choice = scanner.nextInt();
                
                scanner.nextLine();

                switch (choice) {
                        
                    case 1: System.out.println("Your balance: $" + account.getBalance());
                        
                        break;
                        
                    case 2: System.out.print("Enter the amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        
                        break;
                        
                    case 3: System.out.print("Enter the amount to withdraw: $");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                        
                        break;
                        
                    case 4: viewTransactionHistory(account);
                        
                        break;
                        
                    case 5: System.out.println("Thank you for using the ATM. Goodbye!");
                        exit = true;
                        
                        break;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            
        } 
        
        else 
        
        {
            System.out.println("Login failed. Incorrect account number or PIN.");
        }
    }

    private static void initializeAccounts() {
        
        accounts.put("1234567890", new Account("1234567890", "1234", 1000.0));
        accounts.put("9876543210", new Account("9876543210", "5678", 1500.0));
    }

    private static void viewTransactionHistory(Account account) {
        
        System.out.println("Transaction History for Account " + account.getAccountNumber() + ":");
        List<Transaction> history = account.getTransactionHistory();

        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } 
        
        else
        
        {
            for (Transaction transaction : history) {
                System.out.println(transaction);
            }
            
        }
    }
}
