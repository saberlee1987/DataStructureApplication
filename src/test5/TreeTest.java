package test5;

import java.util.Scanner;

public class TreeTest {

    private static int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the n : ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the  " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the your index : ");
        int index = scanner.nextInt();

        int parentIndex = parentIndex(index-1);
        System.out.println(String.format("%d %d", index, array[index - 1]));
        if (parentIndex > 0) {
            System.out.println(String.format("%d %d", parentIndex +1, array[parentIndex]));
        } else {
            System.out.println("root");
        }
    }

    public static void main(String[] args) {
        test();
    }

}
