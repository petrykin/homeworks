package lesson6.task6;

import java.util.Arrays;

public class SelectionSorterTest {
    public static void main(String[] args) {
        int[][] data = {
                {1, 5, 7, 6, 8, 9, 15, 18, -1, -1},
                {18, 15, 9, 8, 6, 7, 5, 1, -1, -1},
                {6, 8, 3, 123, 5, 4, 1, 2, 0, 9, 7},
        };
        for (int[] arr : data) {
            System.out.print(Arrays.toString(arr) + " => ");
            ChangedSelectionSorter.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
