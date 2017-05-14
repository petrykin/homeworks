package lesson6.task6;

public class ChangedSelectionSorter {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int k = i;
            int x = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < x) {
                    k = j;
                    x = array[j];
                }
            }
            array[k] = array[i];
            if (array[i] != x) {
                array[i] = x;
            }
        }
    }
}
