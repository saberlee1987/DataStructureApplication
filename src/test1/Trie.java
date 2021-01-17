package test1;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        int index = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                index = ch - 'A';
            } else {
                index = ch - 'a';
            }
            if (current.children[index] == null) {
                current.children[index] = new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndOfWord=true;
    }
}
