package test5;


public class Heap {
    private int[] items;
    private int size;
    public Heap(int length){
        this.items= new int[length];
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("items is empty");
        }
        int root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largeChildIndex = largerChildIndex(index);
            swap(index, largeChildIndex);
            index = largeChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftChildIndex(index);
        }

        return leftChild(index) > rightChild(index) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        boolean isValid = items[index] >= leftChildIndex(index);
        if (hasRightChild(index)) {
            isValid &= items[index] >= rightChildIndex(index);
        }
        return isValid;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("items is full");
        }
        items[size++] = value;
        bubbleUp();
    }

    private boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public int[] getItems() {
        return items;
    }
}
