package test4;


public class AVLTree {
    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);

    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.getValue()) {
            root.setLeftChild(insert(root.getLeftChild(), value));
        }
        if (value > root.getValue()) {
            root.setRightChild(insert(root.getRightChild(), value));
        }

        root.setHeight(Math.max(
                height(root.getLeftChild()),
                height(root.getRightChild()))
                + 1
        );
        balance(root);

        return root;
    }

    private int height(AVLNode root) {
        return (root == null) ? -1 : root.getHeight();
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.getLeftChild()) < 0) {
                System.out.println("Left Rotate " + root.getRightChild().getValue());
                root.setLeftChild(rotateLeft(root.getLeftChild()));
            }
            System.out.println("Right Rotate " + root.getValue());
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.getRightChild()) > 0) {
                System.out.println("Right Rotate " + root.getRightChild().getValue());
               root.setRightChild(rotateRight(root.getRightChild()));
            }
            System.out.println("Left Rotate " + root.getValue());
            return rotateLeft(root);
        }
        return root;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) > -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.getLeftChild()) - height(node.getRightChild());
    }

    private AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.getRightChild();

        root.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(root);

        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.getLeftChild();
        root.setLeftChild(newRoot.getLeftChild());
        newRoot.setRightChild(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.setHeight(Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild()) + 1));
    }
}
