package sorting.bubblesort;

import sorting.Sort;
import sorting.constants.SortEnum;
import sorting.utility.Utility;
public class BubbleSort implements Sort {

    public void sort(int[] array, SortEnum sortEnum) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (sortEnum == SortEnum.ASC) {
                    if (array[j] < array[j - 1]) {
                       Utility.swap(array, j, j - 1);
                       isSorted = false;
                    }
                } else {
                    if (array[j] > array[j - 1]) {
                        Utility.swap(array, j, j - 1);
                        isSorted = false;
                    }
                }
            }
            if (isSorted) {
                System.out.println("isSorted ...........");
                return;
            }
        }
    }
}
