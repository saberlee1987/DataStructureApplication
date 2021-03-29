package sorting;

import sorting.bubblesort.BubbleSort;
import sorting.constants.SortEnum;
import sorting.mergesort.MergeSort;
import sorting.selectionsort.SelectionSort;

public class SortTest {
    public static void main(String[] args) {
//        Sort sort = new BubbleSort();
//        Sort sort = new SelectionSort();
        Sort sort = new MergeSort();
        int[] array = {105, 102, 115, 83, 96, 111, 98};
        int[] array2 = {1, 2, 3, 4, 5, 6, 8, 7};
        sort.sort(array, SortEnum.DCS);
        sort.sort(array2,SortEnum.ASC);
    }
}
