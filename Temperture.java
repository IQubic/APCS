import java.util.Arrays;

public class Temperture {
    public static void main(String[] args) {
        double[][] temps = {{70.3, 85.2, 60.0},
                            {74.7, 91.0, 65.1},
                            {71.4, 85.1, 60.9},
                            {65.3, 90.0, 50.3},
                            {66.0, 91.0, 55.4},
                            {72.0, 98.3, 60.2},
                            {55.2, 89.1, 62.5}};
        System.out.println("Tempurtures for the week:");
        System.out.println("[");
        for (double[] row : temps) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("]");

        System.out.println("Maximum: " + deepFindMax(temps));
    }

    public static double deepFindMax(double[][] input) {
        double max = input[0][0];
        for (double[] rows : input) {
            for (double num : rows) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    public static double[] rowAverages(double[][] input) {
        double[] output = new double[input.length];
    }
}
