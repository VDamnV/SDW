import java.util.Random;
public class lab2_1 {
    public static void main(String[] args) {
        Random random = new Random();
                System.out.println("--- Analysis of generated numbers ---");
                for (int k = 1; k <= 5; k++) {
            int randomNumber = 100 + random.nextInt(900);
                        String numberStr = String.valueOf(randomNumber);            
            boolean hasIdenticalDigits = false;
                        for (int i = 0; i < numberStr.length(); i++) {
                char currentDigit = numberStr.charAt(i);
                                if (numberStr.indexOf(currentDigit) != numberStr.lastIndexOf(currentDigit)) {
                    hasIdenticalDigits = true;
                    break;
                }
            }
                        System.out.print("Number " + numberStr + ": ");
            if (hasIdenticalDigits) {
                System.out.println("match found (there are identical digits).");
            } else {
                System.out.println("all numbers are unique.");
            }
        }
    }
}
