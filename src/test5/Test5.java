package test5;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] numbers = {5,3,10,1,4,2};
        Heap heap = new Heap();
        for (int number : numbers) {
            heap.insert(number);
        }
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= heap.remove();
        }
        System.out.println(Arrays.toString(numbers));
//        heap.insert(15);
//        heap.insert(22);
//        heap.insert(13);
//        heap.insert(24);
//        heap.insert(4);
//        heap.insert(1);
//        heap.insert(8);
//        heap.remove();
        System.out.println("Done");
    }
}
