package PrefixTrie;

import java.util.*;

public class Node {

    TreeMap<Character, Node> children = new TreeMap<>();
    Boolean last = false;

    /**
     * @return Collection with children
     */

    public Collection<Node> childNodes() {
        return children.values();
    }

    /**
     * @param c char
     * @return make Node with char c as a current Node
     */

    Node getch(char c) {
        return children.get(c);
    }

    /**
     * @return how many children has this node
     */

    public int sizeof() {
        if (children.size() == 0) {
            return 0;
        }
        return children.size();
    }

    /**
     * @param c char
     * @return successful or not
     */

    boolean deleteLastNode(char c) {
        if (children.get(c).sizeof() == 0) {
            children.remove(c);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return all words of this node
     */

    public List<String> getAllWords() {
        List<String> answ = new ArrayList<>();
        for (Map.Entry<Character, Node> child : children.entrySet()) {
            Character character = child.getKey();
            Node node = child.getValue();
            List<String> part = new ArrayList<>();
            final List<String> partialAnsw = node.getAllWords();
            for (String ans : partialAnsw) {
                part.add(character + ans);
            }
            answ.addAll(part);
            if (partialAnsw.size() == 0) {
                answ.add(character.toString());
            }
        }
        return answ;
    }
}
