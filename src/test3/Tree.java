package test3;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (current.getValue() == node.getValue()) {
                return;
            }
            if (value < current.getValue()) {
                if (current.getLeftChild() == null) {
                    current.setLeftChild(node);
                    break;
                }
                current = current.getLeftChild();
            } else {
                if (current.getRightChild() == null) {
                    current.setRightChild(node);
                    break;
                }
                current = current.getRightChild();
            }
        }
    }
}
