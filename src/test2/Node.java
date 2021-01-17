package test2;

import java.util.Hashtable;
import java.util.Map;

public class Node {
    private char value;
    private Map<Character, Node> children = new Hashtable<>();
    private boolean isEndOfWord;

    public Node(char value) {
        this.value = value;
    }

    public boolean hasChild(char ch) {
        return children.containsKey(ch);
    }

    public void addChildren(char ch) {
        this.children.put(ch, new Node(ch));
    }

    public Node getNode(char ch) {
        return children.get(ch);
    }

    public Node getChild(char ch) {
        return children.get(ch);
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    @Override
    public String toString() {
       return "value=" + value;

    }

    public Node[] getChildren() {
        return children.values().toArray(new Node[0]);
    }

    public char getValue() {
        return value;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }
    public void removeChild(char ch){
        children.remove(ch);
    }
}
