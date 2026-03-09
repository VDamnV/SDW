import java.util.InputMismatchException;
import java.util.Scanner;

class Patient {
    private int id;
    private String surname;
    private String address;
    private String phone;
    private int medCardNumber;
    private String diagnosis;

    public Patient(int id, String surname, String address, String phone, int medCardNumber, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.medCardNumber = medCardNumber;
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() { return diagnosis; }
    public int getMedCardNumber() { return medCardNumber; }

    public void printRow() {
        System.out.printf("| %-4d | %-12s | %-15s | %-14s | %-8d | %-12s |\n", 
                          id, surname, address, phone, medCardNumber, diagnosis);
    }
    
    public static void printHeader() {
        String separator = new String(new char[83]).replace("\0", "-");
        System.out.println(separator);
        System.out.printf("| %-4s | %-12s | %-15s | %-14s | %-8s | %-12s |\n", 
                          "ID", "Last name", "Address", "phone number", "№ Card", "Diagnosis");
        System.out.println(separator);
    }
}

public class lab3 {
    public static void main(String[] args) {
        Patient[] patients = {
            new Patient(1, "Ivanenko", "Kyiv", "050-111-22-33", 1001, "Influenza"),
            new Patient(2, "Petrenko", "Cherkasy", "067-222-33-44", 1050, "Tonsillitis"),
            new Patient(3, "Melnik", "Lviv", "063-333-44-55", 1020, "Influenza"),
            new Patient(4, "Kovalenko", "Odessa", "099-444-55-66", 2005, "Bronchitis"),
            new Patient(5, "Shevchenko", "Dnipro", "097-555-66-77", 1080, "Tonsillitis")
        };

        System.out.println("--- PATIENT DATABASE ---");
        Patient.printHeader();
        for (Patient p : patients) {
            p.printRow();
        }
        System.out.println(new String(new char[83]).replace("\0", "-") + "\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a diagnosis to search: ");
        String searchDiagnosis = scanner.nextLine();
        boolean foundDiag = false;
        
        System.out.println("\nSearch results by diagnosis '" + searchDiagnosis + "':");
        Patient.printHeader();
        for (Patient p : patients) {
            if (p.getDiagnosis().equalsIgnoreCase(searchDiagnosis)) {
                p.printRow();
                foundDiag = true;
            }
        }
        System.out.println(new String(new char[83]).replace("\0", "-"));
        if (!foundDiag) {
            System.out.println("!!! No patients with this diagnosis were found.\n");
        } else {
            System.out.println();
        }

        int minCard = 0, maxCard = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter the range of medical card numbers to search:");
                System.out.print("Minimum number (integer): ");
                minCard = scanner.nextInt();
                System.out.print("Maximum number (integer): ");
                maxCard = scanner.nextInt();
                
                if (minCard < 0 || maxCard < 0 || minCard > maxCard) {
                    System.out.println("ERROR: Invalid range. Values must be positive, and the minimum must be <= the maximum. Please try again.\n");
                    continue;
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("INPUT ERROR: Incorrect data format. Please enter an integer. Try again.\n");
                scanner.nextLine();
            }
        }

        boolean foundCard = false;
        System.out.println("\nSearch results by card numbers from " + minCard + " to " + maxCard + ":");
        Patient.printHeader();
        for (Patient p : patients) {
            if (p.getMedCardNumber() >= minCard && p.getMedCardNumber() <= maxCard) {
                p.printRow();
                foundCard = true;
            }
        }
        System.out.println(new String(new char[83]).replace("\0", "-"));
        if (!foundCard) {
            System.out.println("!!! No patients were found in this range of card numbers.");
        }
        
        scanner.close();
    }
}
