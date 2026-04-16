import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class SquareMatrix {
    private int dimension;
    private LinkedList<Integer> elements;

    public SquareMatrix(int dimension) {
        this.dimension = dimension;
        this.elements = new LinkedList<>();
    }

    public void fillRandom() {
        Random rand = new Random();
        int totalElements = dimension * dimension;
        for (int i = 0; i < totalElements; i++) {
            elements.add(rand.nextInt(10));
        }
    }

    public SquareMatrix add(SquareMatrix other) {
        SquareMatrix result = new SquareMatrix(this.dimension);
        for (int i = 0; i < this.elements.size(); i++) {
            result.elements.add(this.elements.get(i) + other.elements.get(i));
        }
        return result;
    }

    public SquareMatrix multiply(SquareMatrix other) {
        SquareMatrix result = new SquareMatrix(this.dimension);
        
        Integer[] a = this.elements.toArray(new Integer[0]);
        Integer[] b = other.elements.toArray(new Integer[0]);

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                int sum = 0;
                for (int k = 0; k < dimension; k++) {
                    sum += a[i * dimension + k] * b[k * dimension + j];
                }
                result.elements.add(sum);
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < dimension; i++) {
            System.out.print("| ");
            for (int j = 0; j < dimension; j++) {
                System.out.printf("%3d ", elements.get(i * dimension + j));
            }
            System.out.println("|");
        }
    }
}

public class lab6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LinkedList Collections Processing (Matrices) ===");
        System.out.print("Enter the dimension of the square matrix (N): ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the number of matrices in the lists: ");
        int count = scanner.nextInt();

        LinkedList<SquareMatrix> listA = new LinkedList<>();
        LinkedList<SquareMatrix> listB = new LinkedList<>();
        
        LinkedList<SquareMatrix> listSum = new LinkedList<>();
        LinkedList<SquareMatrix> listProduct = new LinkedList<>();

        System.out.println("\n[LOG] Generating matrix lists...");
        for (int i = 0; i < count; i++) {
            SquareMatrix matA = new SquareMatrix(n);
            matA.fillRandom();
            listA.add(matA);

            SquareMatrix matB = new SquareMatrix(n);
            matB.fillRandom();
            listB.add(matB);

            listSum.add(matA.add(matB));
            listProduct.add(matA.multiply(matB));
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Matrix Pair #" + (i + 1) + " ---");
            System.out.println("Matrix A:");
            listA.get(i).print();
            
            System.out.println("Matrix B:");
            listB.get(i).print();
            
            System.out.println("Addition Result (A + B):");
            listSum.get(i).print();
            
            System.out.println("Multiplication Result (A * B):");
            listProduct.get(i).print();
        }

        scanner.close();
    }
}