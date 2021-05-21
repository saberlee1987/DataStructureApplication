package test5;

import java.util.Arrays;

public class SumPathTriangle {

    public static void main(String[] args) {
        int[][] data = {
                {  7  },
                { 3, 8},
                { 8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        System.out.println("original Array : ");
        printArray(data);
        System.out.println(maximumTrianglePathSum(data));
    }

    private static void printArray(int[][] data) {
        for (int[] ints : data) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=========================================");
    }

    private static int maximumTrianglePathSum(int[][] data){

        for (int r = data.length - 1; r > 0; r--) {
            for (int c = 0; c < data[r].length - 1; c++) {
                data[r - 1][c] += Math.max(data[r][c], data[r][c + 1]);
            }
            printArray(data);
        }
        return data[0][0];
    }
}
