package sorting.radixsort;

public class RadixSortTest {

    public static void main(String[] args) {
        int[] a = {329, 457, 657, 839, 436, 720, 355};
        printArray(a);
        sort(a, 3);
        System.out.println("sorted array is : ");
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    private static void sort(int[] numbers, int numberOfDigits) {
        for (int i = 1; i <= numberOfDigits; i++) {
            int[] temp = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                temp[j] = getDigitFromPosition(i, numbers[j]);
            }
            for (int k = 0; k < temp.length; k++) {
                for (int h = 1; h < temp.length; h++) {
                    if (temp[h] < temp[h - 1]) {
                        swap(temp, h, h - 1);
                        swap(numbers, h, h - 1);
                    }
                }
            }
            printArray(numbers);
        }
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static int getDigitFromPosition(int pos, int number) {
        int numberPosition = 0;
        while (pos > 0 && number > 0) {
            numberPosition = number % 10;
            pos--;
            number /= 10;
        }
        return numberPosition;
    }

}
