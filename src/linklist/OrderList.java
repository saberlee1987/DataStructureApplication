package linklist;

public class OrderList {
    private Node head;

    public int add(int item) {
        Node newNode = new Node(item);
        Node current = null;
        if (this.head == null) {
            this.head = newNode;
            return this.head.getData();
        } else if (head.getData() >= newNode.getData()) {
            newNode.setNext(head);
            newNode.getNext().setPrevious(newNode);
            head = newNode;
            return head.getData();
        } else {
            current = head;
            while (current.getNext() != null &&
                    current.getNext().getData() < newNode.getData()) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());

            if (current.getNext() != null) {
                newNode.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
            newNode.setPrevious(current);
            return current.getData();
        }

    }

    public int remove(int item) {
        Node current = this.head;
        boolean found = false;
        while (current != null) {
            if (current.getData() == item) {
                found = true;
                if (current.getNext() != null && current.getPrevious() != null) {
                    Node previous = current.getPrevious();
                    Node next = current.getNext();
                    next.setPrevious(previous);
                    previous.setNext(next);
                } else {
                    current = current.getNext();
                    if (current != null)
                        current.setPrevious(null);
                    head = current;
                }
            }

            if (found)
                break;
            current = current.getNext();
        }

        if (!found)
            throw new IllegalArgumentException(String.format("item %d does not exist", item));

        return item;
    }

    public void show() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
