package test5;

public class MaxHeap {
    public static void heapify(int[] arrays) {
        int lastParentIndex = arrays.length / 2 - 1;
        System.out.println("lastParentIndex ===> " + lastParentIndex);
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(arrays, i);
        }
    }

    private static void heapify(int[] arrays, int index) {
        int lagerIndex = index;
        int leftChildIndex = index * 2 + 1;
        if (leftChildIndex < arrays.length &&
                arrays[leftChildIndex] > arrays[lagerIndex])
            lagerIndex = leftChildIndex;

        int rightIndex = index * 2 + 2;
        if (rightIndex < arrays.length &&
                arrays[rightIndex] > arrays[lagerIndex])
            lagerIndex = rightIndex;

        if (index == lagerIndex)
            return;

        swap(index, lagerIndex, arrays);
        heapify(arrays, lagerIndex);
    }

    private static void swap(int first, int second, int[] array) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        Heap heap = new Heap(array.length);
        for (int i : array) {
            heap.insert(i);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
        return heap.max();
    }
}
