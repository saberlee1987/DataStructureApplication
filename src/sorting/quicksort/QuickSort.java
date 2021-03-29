package sorting.quicksort;

import sorting.Sort;
import sorting.constants.SortEnum;
import sorting.utility.Utility;

public class QuickSort implements Sort {
    @Override
    public void sort(int[] array, SortEnum sortEnum) {
        sort(array, 0, array.length - 1, sortEnum);
    }

    private void sort(int[] array, int start, int end, SortEnum sortEnum) {
        if (start >= end)
            return;
        int boundary = partition(array, start, end, sortEnum);
        sort(array, start, boundary - 1, sortEnum);
        sort(array, boundary + 1, end, sortEnum);
    }

    private int partition(int[] array, int start, int end, SortEnum sortEnum) {
        int pivot = array[end];
        int boundary = start - 1;
        for (int i = start; i <= end; i++) {
            if (sortEnum == SortEnum.ASC) {
                if (array[i] <= pivot)
                    Utility.swap(array, i, ++boundary);
            } else {
                if (array[i] >= pivot)
                    Utility.swap(array, i, ++boundary);
            }
        }
        return boundary;
    }
}
