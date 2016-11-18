import java.util.*;

public class MagicSquare {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter an odd number:");
        int size = console.nextInt();
        int[][] magicSquare = createOddMagicSquare(size);
        printArray(magicSquare);
    }

    public static int[][] createOddMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        curRow = size / 2;
        curCol = 0;
        for (int i = 0; i < Math.pow(size, 2); i++) {
            
        }
    }

    public static void printArray(int[][] x) {
        for (int[] row : x){
            System.out.println(Arrays.toString(row));
        }
    }
}

