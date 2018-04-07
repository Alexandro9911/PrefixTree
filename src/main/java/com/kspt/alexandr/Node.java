package com.kspt.alexandr;

import java.util.*;

final class Node {

    Map<Character, Node> children = new HashMap<>();
    Boolean last = false;

    /**
     * @param c char
     * @return make Node with char c as a current Node
     */
    Node getch(char c) {
        return children.get(c);
    }

    /**
     * @param c char
     * @return successful or not
     */
    boolean deleteNode(char c) {
        if (children.get(c).children.keySet().size() == 0) {
            children.remove(c);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return all words of this node
     */
    List<String> getAllWords() {
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
