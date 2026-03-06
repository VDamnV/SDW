import java.util.Scanner;
public class lab2_2 {
    public static void main(String[] args) {
        String originalText = "The rays of the September sun flooded the great halls of the old château of the Dukes of Charmerace,\n" +
                              "lighting up with their mellow glow the spoils of so many ages and many lands,\n" +
                              "jumbled together with the execrable taste which so often afflicts those whose only standard of value is money.";
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- TEXT TO BE PROCESSED ---");
        System.out.println(originalText);
        System.out.println("------------------------\n");
        System.out.print("Enter a character (0 - delete character, 1 - insert character): ");
        int flag = scanner.nextInt();
        System.out.print("Enter the symbol to be processed: ");
        char targetChar = scanner.next().charAt(0);
        int k = 0;
        if (flag == 1) {
            System.out.print("Enter position k (number of characters after which to insert a new one): ");
            k = scanner.nextInt();
        }
        String[] lines = originalText.split("\\n");
        StringBuilder processedText = new StringBuilder();
        for (String line : lines) {
            if (flag == 0) {
                String modifiedLine = line.replace(String.valueOf(targetChar), "");
                processedText.append(modifiedLine).append("\n");
            } else if (flag == 1) {
                StringBuilder sb = new StringBuilder(line);
                if (k <= line.length() && k >= 0) {
                    sb.insert(k, targetChar);
                } else {
                    sb.append(targetChar);
                }
                processedText.append(sb.toString()).append("\n");
            }
        }
        System.out.println("\n--- INPUT PARAMETERS ---");
        System.out.println("Sign of action: " + flag + (flag == 0 ? " (Removal)" : " (Insert)"));
        System.out.println("Target symbol: '" + targetChar + "'");
        if (flag == 1) {
            System.out.println("Insertion position (k): " + k);
        }
        System.out.println("\n--- TEXT AFTER PROCESSING ---");
        System.out.print(processedText.toString());
        scanner.close();
    }
}
