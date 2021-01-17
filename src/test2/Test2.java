package test2;

public class Test2 {
    public static void main(String[] args) {
        Trie trie=new Trie();
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


        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        System.out.println(trie.findWords(""));
    }
}
