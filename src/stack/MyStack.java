package stack;

import java.util.Arrays;

public class MyStack {
    private int[] items = new int[5];
    private int count;

    public void push(int item) {
        if (count == items.length) {
            items = Arrays.copyOf(items, (items.length + 1) * 2);
        }
        this.items[count++] = item;
    }

    public int pop(){
        if (count == 0)
            throw new IllegalStateException("error");

        int value = items[--count];
        items= Arrays.copyOfRange(items,0,count);
        return value;
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException("error");

        return items[count -1];
    }

    @Override
    public String toString() {
        int[] array =Arrays.copyOf(this.items,count);
        return Arrays.toString(array);
    }
}
