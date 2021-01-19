package test3;

public class Test3 {
    public static void main(String[] args) {
        Tree tree =new Tree();
        System.out.println(tree.min());
        tree.insert(7);
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(10);
        tree.insert(10);
        System.out.println(tree.find(10));
        System.out.println(tree.find(11));
        tree.traversePreOrder();
        System.out.println("");
        tree.traverseInOrder();
        System.out.println("");
        tree.traversePostOrder();
        System.out.println("");
        System.out.println(tree.height());
        System.out.println("");
        System.out.println(tree.min());
    }
}
