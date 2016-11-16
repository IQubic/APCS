import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        rotate(array, 2);
        System.out.println(Arrays.toString(array));
    }

    public static void rotate(int[] x, int offset) {
        //Shrink the array to be within the offset
        if (offset > x.length) {
            offset %= x.length;
        }

        //Declare some variables
        //Dest is always earlier in the array
        int temp = x[0];
        int dest = 0;
        for (int i = 0; i < x.length; i++) {
            //Find the new src based on the current dest
            int src = dest + offset;
            if (src > x.length - 1) {
                src -= x.length;
            }

            //Update the array
            if (i == x.length - 1) {
                x[dest] = temp;
            } else {
                x[dest] = x[src];
                dest = src;
            }
        }
    }
}
