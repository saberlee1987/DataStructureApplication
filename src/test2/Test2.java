package test2;

public class Test2 {
    public static void main(String[] args) {
        Tree tree =new Tree();
       // trie.insert("CAT");
        //trie.insert("CAN");
        //System.out.println("DONE");
        //trie.insert("CANADA");
        //System.out.println(trie.contains(null));
       // trie.traverse(trie.getRoot());
       // System.out.println("");

//        trie.insert("care");
//        trie.insert("car");
//        System.out.println(trie.contains("car"));
//        trie.remove("car");
//        trie.remove("book");
//        trie.remove("");
//        trie.remove(null);
//        System.out.println(trie.contains("car"));
//        System.out.println(trie.contains("care"));


        tree.insert("car");
        tree.insert("card");
        tree.insert("care");
        tree.insert("careful");
        tree.insert("egg");
        System.out.println(tree.findWords("cargo"));
    }
}
