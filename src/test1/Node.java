package test1;

public class Node {
    public char value;
    public Node[] children = new Node[Trie.ALPHABET_SIZE];
    public boolean isEndOfWord;

    public Node(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;

    }
}
