import java.util.*;

public class Merge {
    public static void main(String[] args) {

    }

    public static void merge(ArrayList<Double> left, ArrayList<Double> right) {
        // Nothing to do
        if (right.isEmpty()) {
            return;
        // Place the contents of right into left
        } else if (left.isEmpty()) {
            for (double elem : right) {
                left.add(elem);
            }
            return;
        } else {
            // keep track of where to insert things
            int leftPtr = 0;
            int rightPtr = 0;

            // For each element in right, we will find where it goes in left, and place it there
            while (rightPtr < right.size) {
                // The rest of right needs to be appended to left
                if (leftPtr > left.size()) {
                    left.add(right.get(rightPtr));
                    rightPtr++;
                // We have found where to place this element
                } else if (left.get(leftPtr) < rightElem){

                }
            }
        }
    }
}
