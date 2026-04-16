import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Searchable {
    void searchOperations(String criteria);
}

class Account implements Searchable {
    private String accountNumber;
    private double balance;
    private List<Operation> operations;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.operations = new ArrayList<>();
        System.out.println("[LOG] New account created: " + accountNumber);
    }

    public class Operation {
        private String type;
        private double amount;

        public Operation(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public String getType() {
            return type;
        }

        public void printDetails() {
            System.out.printf("  - Type: %-12s | Amount: %8.2f UAH\n", type, amount);
        }
    }

    public void addOperation(String type, double amount) {
        Operation op = new Operation(type, amount);
        operations.add(op);
        
        if (type.equalsIgnoreCase("deposit")) {
            balance += amount;
        } else {
            balance -= amount;
        }
        System.out.println("[LOG] Operation added: " + type + " for the amount of " + amount + " UAH.");
    }

    public void printStatement() {
        System.out.println("\n--- ACCOUNT STATEMENT: " + accountNumber + " ---");
        System.out.printf("Current balance: %.2f UAH\n", balance);
        System.out.println("Operation history:");
        if (operations.isEmpty()) {
            System.out.println("  [!] No operations yet.");
        } else {
            for (Operation op : operations) {
                op.printDetails();
            }
        }
        System.out.println("----------------------------------------\n");
    }

    @Override
    public void searchOperations(String searchType) {
        System.out.println("[SEARCH] Looking for operations by type: '" + searchType + "'...");
        boolean found = false;
        
        for (Operation op : operations) {
            if (op.getType().equalsIgnoreCase(searchType)) {
                op.printDetails();
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("  [!] No operations of this type found.");
        }
        System.out.println("[LOG] Search completed.");
    }
}

public class lab5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Account Management System ===");
        System.out.print("Enter your account number: ");
        String accNum = scanner.nextLine();

        Account myAccount = new Account(accNum);

        boolean keepAdding = true;
        while (keepAdding) {
            System.out.print("\nChoose an operation (1 - deposit, 2 - withdrawal, 3 - payment, 0 - exit): ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                keepAdding = false;
                System.out.println("[LOG] User finished entering operations.");
                continue;
            }

            String type = "";
            switch (choice) {
                case 1: type = "deposit"; break;
                case 2: type = "withdrawal"; break;
                case 3: type = "payment"; break;
                default: 
                    System.out.println("[ERROR] Unknown operation type. Please try again.");
                    continue;
            }

            System.out.print("Enter the operation amount: ");
            double amount = scanner.nextDouble();
            
            myAccount.addOperation(type, amount);
        }

        myAccount.printStatement();

        System.out.print("Enter operation type to search (deposit/withdrawal/payment): ");
        String searchCriteria = scanner.next();
        
        myAccount.searchOperations(searchCriteria);

        scanner.close();
    }
}
