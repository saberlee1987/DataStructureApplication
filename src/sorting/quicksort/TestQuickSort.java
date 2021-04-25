package sorting.quicksort;

import java.util.Arrays;

public class TestQuickSort {

    private static void quicksort(int[] a, int s, int e) {
        if(s>=e)
            return;

        partition(a,s,e);


    }
    private static int partition(int[] a, int s, int e) {
        int x = a[e];
        System.out.println(x);
        int i = s-1;
        for(int j = s;j<e;++j){
            if(a[j]<=x){
                ++i;
                int temp = a[i];
                a[i]= a[j];
                a[j]=temp;
            }
        }
        ++i;
        int temp = a[i];
        a[i]= a[e];
        a[e]=temp;

        System.out.println(Arrays.toString(a));
        return i;
    }

    public static void main(String[] args) {
        int[] array = {2,8,7,1,3,5,6,4};
        quicksort(array,0,array.length-1);
    }
}
