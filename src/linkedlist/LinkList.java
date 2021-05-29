package linkedlist;

public class LinkList {

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

    private Node first;
    private Node last;

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            this.first = this.last = node;
        else {
            last.setNext(node);
            last = node;
        }
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.setNext(first);
            first = node;
        }
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
}
