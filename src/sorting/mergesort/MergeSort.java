package sorting.mergesort;

import sorting.Sort;
import sorting.constants.SortEnum;
import java.util.Arrays;

public class MergeSort implements Sort {
    @Override
    public void sort(int[] array, SortEnum sortEnum) {
        if (array.length < 2)
            return;

        int middle = array.length / 2;

        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        sort(left, sortEnum);
        sort(right, sortEnum);
        merge(left, right, array, sortEnum);
        System.out.println(Arrays.toString(array));
        System.out.println("=========================================================================");
    }

    private void merge(int[] left, int[] right, int[] array, SortEnum sortEnum) {
        int i = 0;
        int j = 0;
        int k = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        if (i < left.length && j < right.length) {
            if (sortEnum == SortEnum.ASC) {
                if (left[i] < right[i]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            } else {
                if (left[i] > right[i]) {
                    array[k++] = left[i++];
                } else {
                    array[k++] = right[j++];
                }
            }
        }

        while (i < left.length)
            array[k++] = left[i++];

        while (j < right.length)
            array[k++] = right[j++];

    }
}
