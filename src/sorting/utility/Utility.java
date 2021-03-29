package sorting.utility;

import java.util.Arrays;

public class Utility {
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        System.out.println(Arrays.toString(array));
        System.out.println(array[firstIndex]+" swap by "+array[secondIndex]);
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        System.out.println("After swapping ");
        System.out.println(Arrays.toString(array));
        System.out.println("==========================================================");

    }
}
