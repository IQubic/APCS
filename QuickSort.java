import java.util.*;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.stream(args).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        quicksort(nums, 0, nums.size() - 1, -1);
        System.out.println(nums);
    }

    private static void quicksort(List<Integer> cells, int startIndex, int endIndex, int factor) {
        // Partitioning the array

        // Keep track of which elements we've examined
        int compIndex = startIndex;
        // Use the last element as the pivot
        int pivotIndex = endIndex;

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
                moveToEndOfSublist(cells, compIndex, endIndex);
                pivotIndex--;
            }
        }

        // Sort the left if needed
        if (pivotIndex - startIndex > 1) {
            quicksort(cells, startIndex, pivotIndex - 1, factor);
        }
        // Sort the right if needed
        if (endIndex - pivotIndex > 1) {
            quicksort(cells, pivotIndex + 1, endIndex, factor);
        }
    }

    private static void moveToEndOfSublist(List<Integer> cells, int elementIndex, int endOfSublist) {
        if (endOfSublist == cells.size() - 1) {
            cells.add(cells.remove(elementIndex));
        } else {
            cells.add(endOfSublist, cells.remove(elementIndex));
        }
    }
}
