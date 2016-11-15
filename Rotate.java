import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        rotate(array, 2);
        System.out.println(Arrays.toString(array));
    }

    public static void rotate(int[] x, int offset) {
        offset %= x.length;
        int temp = x[0];
        int src = 0;
        for (int i = 0; i < x.length; i++) {
            int dest = i - offset;
            if (dest < 0) {
                dest += x.length;
            }

            if (i == x.length - 1) {
                x[dest] = temp;
            } else {
                x[dest] = x[src];
                src = dest;
            }
        }
    }
}
