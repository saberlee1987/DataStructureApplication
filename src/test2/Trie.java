package test2;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private Node root = new Node(' ');

    public Node getRoot() {
        return root;
    }

    public void insert(String word) {
        Node current = root;
        if (word != null) {
            for (char ch : word.toCharArray()) {
                if (!current.hasChild(ch)) {
                    current.addChildren(ch);
                }
                current = current.getNode(ch);
            }
            current.setEndOfWord(true);
        }
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }
            current = current.getNode(ch);
        }
        return current.isEndOfWord();
    }

    public void traverse(Node root) {
        System.out.print(root.getValue() + " ");
        for (Node child : root.getChildren()) {
            traverse(child);
        }
    }

    public void remove(String word) {
        if (word != null)
            remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.setEndOfWord(false);
            return;
        }
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null) {
            return;
        }
        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord()) {
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix) {
        Node lastNode = findLastNodeOf(prefix);
        List<String> words = new ArrayList<>();
        if (lastNode != null) {
            findWords(lastNode, prefix, words);
        }
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if (root.isEndOfWord()) {
            words.add(prefix);
        }
        for (Node child : root.getChildren()) {
            findWords(child, prefix + child.getValue(), words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) {
            return null;
        }
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }
        return current;
    }
}