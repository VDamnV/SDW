import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- File Line Reversal Program ---");
        
        System.out.print("Enter the path to the input Java file (e.g., input.java): ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the path to the output file (e.g., output.txt): ");
        String outputFilePath = scanner.nextLine();

        System.out.println("\n[INFO] Starting file processing...");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            System.out.println("[INFO] File " + inputFilePath + " successfully opened for reading.");
            System.out.println("[INFO] File " + outputFilePath + " successfully opened for writing.\n");

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();
                
                writer.write(reversedLine);
                writer.newLine();

                System.out.println("[PROCESSING] Line " + lineNumber + " read and reversed.");
                System.out.println("   Original : " + line);
                System.out.println("   Result   : " + reversedLine);
                
                lineNumber++;
            }

            System.out.println("\n[INFO] Reading and writing completed successfully. Lines processed: " + (lineNumber - 1));

        } catch (IOException e) {
            System.out.println("[ERROR] An error occurred while working with files: " + e.getMessage());
        } finally {
            System.out.println("[INFO] Streams closed. Program terminated.");
            scanner.close();
        }
    }
}
