package PrefixTrie;

import java.util.*;

public final class PrefixTrie {

    Node root = new Node();

    /**
     * @param str it is a string in tree
     * @return list of nodes of each char of parameter str
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
     * @param str string which you want to enter in tree
     * @return Successful or not
     */
    public boolean input(String str) {
        Node point = root;
        if (str.toCharArray().length == 0 || PrefixTrie.this.find(str)) {
            return false;
        }
        for (Character PartKey : str.toLowerCase().toCharArray()) {
            if (!point.children.containsKey(PartKey)) {
                point.children.put(PartKey, new Node());
            }
            point = point.children.get(PartKey);
        }
        return true;
    }

    /**
     * @param str your string which you want to find
     * @return exist this string in tree or not
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
        return true;
    }

    /**
     * @param str string which you want to delete
     * @return success or not
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
     * @return all strings which starts from prefix "str"
     */
    public List<String> findAllStrings(String str) {
        char[] prefix = str.toCharArray();
        Node currNode = root;
        boolean check = PrefixTrie.this.find(str);
        List<String> answ = new ArrayList<>();
        String firstPart = "";
        String partStr = "";
        String finalString = "";
        if (!check) throw new IllegalArgumentException();
        else {
            for (char ch : prefix) {
                if (currNode.getch(ch) == null) {
                    break;
                }
                firstPart = firstPart + ch;
                currNode = currNode.children.get(ch);
                if (currNode.childNodes().size() == 0) {
                    finalString = firstPart + partStr;
                    answ.add(finalString);
                    return answ;
                }
                currNode.findAll(prefix[prefix.length - 1]);
            }
            finalString = firstPart + partStr;
            answ.add(finalString);
        }
        return answ;
    }
}
