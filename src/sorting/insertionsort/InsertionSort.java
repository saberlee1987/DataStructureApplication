package sorting.insertionsort;

import sorting.Sort;
import sorting.constants.SortEnum;

import java.util.Arrays;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] array, SortEnum sortEnum) {
        int current = 0;
        int j = 0;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            j = i - 1;
            if (sortEnum == SortEnum.ASC) {
                while (j >= 0 && array[j] > current) {
                    array[j + 1] = array[j];
                    j--;
                }
            } else {
                while (j >= 0 && array[j] < current) {
                    array[j + 1] = array[j];
                    j--;
                }
            }
            array[j + 1] = current;
            System.out.println(Arrays.toString(array));
        }
    }
}
