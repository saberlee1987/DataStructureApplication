package test3;
import java.util.ArrayList;
import java.util.List;

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

    public boolean find(int value) {

        Node current = root;
        while (current != null) {
            if (value < current.getValue()) {
                current = current.getLeftChild();
            } else if (value > current.getValue()) {
                current = current.getRightChild();
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        traversePreOrder(root.getLeftChild());
        traversePreOrder(root.getRightChild());
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.getLeftChild());
        System.out.print(root.getValue() + " ");
        traverseInOrder(root.getRightChild());
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.getLeftChild());
        traversePostOrder(root.getRightChild());
        System.out.print(root.getValue() + " ");
    }


    public int height() {
        return height(root);
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.getLeftChild() == null || root.getRightChild() == null) {
            return 0;
        }

        return 1 + Math.max(height(root.getLeftChild()),
                height(root.getRightChild()));

    }

    public int min() {
        return min(root);
    }

    private boolean isLeaf(Node root) {
        return root.getLeftChild() == null || root.getRightChild() == null;
    }

    private int min(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return root.getValue();
        }
        int left = min(root.getLeftChild());
        int right = min(root.getRightChild());
        return Math.min(Integer.min(left, right), root.getValue());
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.getValue() < min || root.getValue() > max) {
            return false;
        }
        return isBinarySearchTree(root.getLeftChild(), min, root.getValue() - 1)
                && isBinarySearchTree(root.getRightChild(), root.getValue() + 1, max);

    }


    public void swapRoot() {
        Node temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    public boolean equal(Tree other) {
        if (root == null || other == null) {
            return false;
        }
        return equal(root, other.getRoot());
    }

    private boolean equal(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null) {
            return first.getValue() == second.getValue()
                    && equal(first.getLeftChild(), second.getLeftChild())
                    && equal(first.getRightChild(), second.getRightChild());
        }
        return false;
    }

    public List<Integer> getNodesAsDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodesAsDistance(root, distance, list);
        return list;
    }

    private void getNodesAsDistance(Node root, int distance, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.getValue());
            return;
        }
        getNodesAsDistance(root.getLeftChild(), distance - 1, list);
        getNodesAsDistance(root.getRightChild(), distance - 1, list);
    }

    public void  traverseLevelOrder(){
        for (int i = 0; i <= height(); i++) {
            for (Integer integer : getNodesAsDistance(i)) {
                System.out.print(integer+" ");
            }
        }
        System.out.println();
    }

}
