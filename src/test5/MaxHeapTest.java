package test5;

import java.util.Scanner;

public class MaxHeapTest {

    private static boolean isMaxHeap(int[] array) {

        if (!validateParentMaxHeap(array))
            return false;

        for (int i = 1; i < array.length; i++) {
            if (!isValidNode(i, array))
                return false;
        }
        return true;
    }

    private static boolean validateParentMaxHeap(int[] array) {
        int parent = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > parent)
                return false;
        }
        return true;
    }

    private static int leftIndex(int index) {
        return index * 2 + 1;
    }

    private static int rightIndex(int index) {
        return index * 2 + 2;
    }

    private static boolean isValidNode(int nodeIndex, int[] array) {
       // System.out.println("index "+nodeIndex+" == "+ array[nodeIndex]);
        int leftChildIndex = leftIndex(nodeIndex);
        int rightChildIndex = rightIndex(nodeIndex);
       // System.out.println("leftChildIndex == "+leftChildIndex);
       // System.out.println("rightChildIndex == "+rightChildIndex);
       // System.out.println("===============================================");
        if (leftChildIndex >= array.length || rightChildIndex >= array.length)
            return true;

        if (array[nodeIndex] < array[leftChildIndex])
            return false;

        if (array[nodeIndex] < array[rightChildIndex])
            return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        if (isMaxHeap(array)) {
            System.out.println("yes");
        } else {
            System.out.println("No");
        }
    }
}
