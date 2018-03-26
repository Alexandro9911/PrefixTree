package PrefixTrie;

import java.util.*;

public final class PrefixTrie {

    Node root = new Node();

    /**
     * @param str string
     * @return list with Node's of each string-letter
     */
    public List<Node> listNodes(String str) {
        Node point = root;
        List<Node> nodes = new ArrayList<>();
        if (str.length() == 0) throw new IllegalArgumentException();
        for (char part : str.toLowerCase().toCharArray()) {
            if (!point.children.containsKey(part)) {
                break;
            } else {
                point = point.children.get(part);
                nodes.add(point);
            }
        }
        return nodes;
    }

    /**
     * @param str string to input
     * @return Successful or not
     */
    public boolean input(String str) {
        Node point = root;
        if (str.toCharArray().length == 0 || PrefixTrie.this.find(str)) {
            return false;
        }
        for (Character partKey : str.toLowerCase().toCharArray()) {

            if (!point.children.containsKey(partKey)) {
                point.children.put(partKey, new Node());
            }
            point = point.children.get(partKey);
        }
        point.last = true;
        return true;
    }

    /**
     * @param str string to find
     * @return contains tree this string or not
     */
    public boolean find(String str) {
        Node point = root;
        if (str.length() == 0) {
            return false;
        }
        for (char part : str.toLowerCase().toCharArray()) {
            if (!point.children.containsKey(part)) {
                return false;
            } else {
                point = point.children.get(part);
            }
        }
        return point.last;
    }

    /**
     * @param str string to delete
     * @return successful or not
     */
    public boolean delete(String str) {
        boolean check = PrefixTrie.this.find(str);
        Node point = root;
        if (!check) {
            return false;
        } else {
            List<Node> nodes = listNodes(str);
            for (int m = nodes.size() - 1; m > 0; m--) {
                point = nodes.get(m);
                if (point.childNodes().size() == 0) {
                    point.children.clear();
                } else {
                    Node childNode = nodes.get(m);
                    point.children.replace(point.children.firstKey(), childNode);
                }
            }
            return true;
        }
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
            if (currNode.getch(ch) == null) {
                return answ;
            }
            firstPart = firstPart + ch;
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
