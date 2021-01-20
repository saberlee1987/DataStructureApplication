package test3;

import java.util.List;

public class Test3 {
	public static void main(String[] args) {
		Tree tree =new Tree();
		tree.insert(7);
		tree.insert(7);
		tree.insert(9);
		tree.insert(4);
		tree.insert(6);
		tree.insert(3);
		tree.insert(8);
		tree.insert(10);
		tree.insert(10);

		Tree tree2 =new Tree();
		tree2.insert(7);
		tree2.insert(7);
		tree2.insert(9);
		tree2.insert(4);
		tree2.insert(6);
		tree2.insert(3);
		tree2.insert(8);
		tree2.insert(10);
		System.out.println(tree.min());
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
		System.out.println(tree.isBinarySearchTree());
	   // tree.swapRoot();
		System.out.println(tree.isBinarySearchTree());
		System.out.println(tree.equal(tree2));
        List<Integer> list = tree.getNodesAsDistance(1);

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();
        tree.traverseLevelOrder();

	}
}
