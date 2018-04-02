package PrefixTrie;

import java.util.*;

public final class PrefixTrie {

    Node root = new Node();

    /**
     * @param str string
     * @return list with Node's of each string-letter
     */
    public Deque<Node> listNodes(String str) {
        Deque<Node> nodes = new LinkedList<>();
        if (str.length() == 0) throw new IllegalArgumentException();
        Node currNode = root;
        for (char ch : str.toLowerCase().toCharArray())
            if (currNode.getch(ch) != null) {
                nodes.addFirst(currNode);
                currNode = currNode.getch(ch);
            }
        return nodes;
    }

    /**
     * @param str string to input
     * @return Successful or not
     */
    public boolean input(String str) {
        Node currNode = root;
        int counter = 0;
        for (Character partKey : str.toLowerCase().toCharArray()) {
            counter++;
            if (!currNode.children.containsKey(partKey)) {
                currNode.children.put(partKey, new Node());
            }
            currNode = currNode.children.get(partKey);
            if (currNode.last && counter == str.length()) return false;
        }
        currNode.last = true;
        return true;
    }

    /**
     * @param str string to find
     * @return contains tree this string or not
     */
    public boolean find(String str) {
        Node currNode = root;
        if (str.length() == 0) return false;
        for (char part : str.toLowerCase().toCharArray()) {
            if (!currNode.children.containsKey(part)) return false;
            currNode = currNode.children.get(part);
        }
        return currNode.last;
    }

    /**
     * @param str string to delete
     * @return successful or not
     */
    public boolean delete(String str) {
        Deque<Node> nodes = listNodes(str);
        char[] ch = str.toLowerCase().toCharArray();
        for (int i = str.length() - 1; i != 0; i--) {
            Node deleter = nodes.removeFirst();
            if (deleter.children.get(ch[i]).last)
                deleter.children.get(ch[i]).last = false;
            deleter.deleteNode(ch[i]);
        }
        return true;
    }

    /**
     * @param str prefix
     * @return all strings with this prefix
     */
    public List<String> findAllStrings(String str) {
        char[] prefix = str.toCharArray();
        Node currNode = root;
        List<String> answ = new ArrayList<>();
        String firstPart = "";
        String finalString = "";
        for (char ch : prefix) {
            if (currNode.getch(ch) == null) return answ;
            firstPart += ch;
            currNode = currNode.children.get(ch);
        }
        List<String> secondPart = currNode.getAllWords();
        for (String part : secondPart) {
            finalString = firstPart + part;
            answ.add(finalString);
        }
        return answ;
    }
}
