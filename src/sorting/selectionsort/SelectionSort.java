package sorting.selectionsort;

import sorting.Sort;
import sorting.constants.SortEnum;
import sorting.utility.Utility;

import java.util.Arrays;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] array, SortEnum sortEnum) {
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (sortEnum == SortEnum.ASC) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                } else {
                    if (array[j] > array[minIndex]) {
                        minIndex = j;
                    }
                }
            }
            Utility.swap(array, i, minIndex);
        }
    }
}
