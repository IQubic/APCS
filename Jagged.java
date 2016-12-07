import java.util.Arrays;

public class Jagged {
    public static void main(String[] args) {
        int[] rows = {1, 3, 5, 2, 4};
        int[][] jagged = createJagged(rows);

        for (int[] row : jagged) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] createJagged(int[] rows) {
        int[][] jagged = new int[rows.length][];
        int count = 0;
        for (int curRow = 0; curRow < rows.length; curRow++) {
            jagged[curRow] = new int[rows[curRow]];
            for (int col = 0; col < jagged[curRow].length; col++) {
                jagged[curRow][col] = count;
                count++;
            }
        }
        return jagged;
    }
}
