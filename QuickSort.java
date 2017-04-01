import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.stream(args).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Quicksort(nums, 0, nums.size() - 1, -1);
        System.out.println(nums);
    }

    private static void Quicksort(List<Integer> cells, int startIndex, int endIndex, int factor) {
        // Partitioning the array

        // Use the last element as the pivot
        int pivotIndex = endIndex;
        // Keep track of how many elements we've examined
        int compIndex = 0;

        while (compIndex < pivotIndex) {
            // compCell comes before the pivot
            // so no movement is needed
            // compIndex is updated so we get a new element to compare to
            if (factor * cells.get(compIndex).compareTo(cells.get(pivotIndex)) < 0) {
                compIndex++;

            // compCell goes after the pivot
            // Moving compCell to the end of the list
            // Moves the pivot forward 1 element,
            // and brings a new element into the compIndex
            } else {
                cells.add(endIndex + 1, cells.remove(compIndex));
                pivotIndex--;
            }
        }

        System.out.println(startIndex + " " + pivotIndex + " " + endIndex);
        System.out.println(cells);

        // Sort the left if needed
        if (pivotIndex - startIndex > 1) {
            Quicksort(cells, startIndex, pivotIndex - 1, factor);
        }
        // Sort the right if needed
        if (endIndex - pivotIndex > 1) {
            Quicksort(cells, pivotIndex + 1, endIndex, factor);
        }
    }
}
