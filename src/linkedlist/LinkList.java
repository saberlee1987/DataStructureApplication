package linkedlist;

import java.util.NoSuchElementException;

public class LinkList {

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            this.first = this.last = node;
        else {
            last.setNext(node);
            last = node;
        }
        this.size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.setNext(first);
            first = node;
        }
        this.size++;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = this.first;
        while (current != null) {
            if (current.getValue() == item)
                return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void print() {
        Node first = this.first;
        while (first != null) {
            System.out.print(first.getValue() + " ");
            first = first.getNext();
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    public int removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        int itemDeleted;
        if (first == last) {
            itemDeleted = first.getValue();
            first = last = null;
        } else {
            Node second = first.getNext();
            itemDeleted = first.getValue();
            first.setNext(null);
            first = second;
        }
        this.size--;
        return itemDeleted;
    }

    public int removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        int itemDeleted;
        if (first == last) {
            itemDeleted = last.getValue();
            first = last = null;
        } else {
            Node previous = getPreviousNode(last);
            itemDeleted = last.getValue();
            last = previous;
            if (last != null)
                last.setNext(null);
        }
        this.size--;

        return itemDeleted;
    }

    private Node getPreviousNode(Node node) {
        Node current = first;
        while (current != null) {
            if (current.getNext() == node)
                return current;
            current = current.getNext();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public void reverse() {

        if (isEmpty())
            throw new NoSuchElementException();

        Node previous = first;
        Node current = first.getNext();
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        last = first;
        last.setNext(null);
        first = previous;
    }

    public int getKthFRomTheEnd(int k) {
        if (isEmpty())
            throw new IllegalArgumentException();

        Node a = first;
        Node b = first;
        for (int i = 0; i < k - 1; i++) {
            b = b.getNext();
        }
        if (b == null) {
            throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.getNext();
            b = b.getNext();
        }
        return a.getValue();
    }

    public int[] toArray() {
        int[] array = new int[size()];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }

        return array;
    }


    private class Node {
        private int value;
        private Node next;


        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
