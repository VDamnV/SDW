import java.util.Random;

public class lab1 {
    public static void main(String[] args) {
     System.out.println("Розробник: Волков Д.В.");
        System.out.println("-----------------------------------");

        int rows = 3; // Кількість рядків
        int cols = 2; // Кількість стовпців
        int[][] A = new int[rows][cols];
        Random rand = new Random();

        // 1. Заповнення матриці випадковими числами
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Генерація чисел від 0 до 99
                A[i][j] = rand.nextInt(100); 
            }
        }

        // 2. Виведення матриці A до обробки
        System.out.println("Матриця A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

        // 3. Пошук рядка з максимальною сумою елементів
        int maxSum = Integer.MIN_VALUE;
        int maxRowIndex = 0;

        for (int i = 0; i < rows; i++) {
            int currentSum = 0;
            for (int j = 0; j < cols; j++) {
                currentSum += A[i][j];
            }
            
            // Якщо знайдена сума більша за попередню максимальну
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxRowIndex = i;
            }
        }

        // 4. Створення масиву B та занесення в нього обраного рядка
        int[] B = new int[cols];
        for (int j = 0; j < cols; j++) {
            B[j] = A[maxRowIndex][j];
        }

        // 5. Виведення результатів
        System.out.println("\nРядок з максимальною сумою (Сума = " + maxSum + "):");
        System.out.print("Масив B: [ ");
        for (int val : B) {
            System.out.print(val + " ");
        }
        System.out.println("]");
    }

}
