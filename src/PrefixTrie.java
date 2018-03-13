
import java.util.*;


public final class PrefixTrie {

    Node root = new Node();

    /**
     * @param str it is a string in tree
     * @return list of nodes of each char of parameter str
     */
    public ArrayList<Node> listNodes(String str) {
        Node point = root;
        ArrayList<Node> nodes = new ArrayList<>();
        if (str.length() == 0) throw new IllegalArgumentException();
        for (char part : str.toLowerCase().toCharArray()) {
            if (!point.child.containsKey(part)) {
                break;
            } else {
                point = point.child.get(part);
                nodes.add(point);
            }
        }
        return nodes;
    }

    /**
     * @param node -- node
     * @return has this node children or not
     */
    public boolean hasChild(Node node) {
        Node point = node;
        boolean has;
        if (point.child.size() == 0) has = false;
        else has = true;
        return has;
    }

    /**
     * @param str string which you want to enter in tree
     * @return Successful or not
     */
    public boolean input(String str) {
        Node point = root;
        for (Character PartKey : str.toLowerCase().toCharArray()) {
            if (!point.child.containsKey(PartKey)) {
                point.child.put(PartKey, new Node());
            }
            point = point.child.get(PartKey);
        }
        return true;
    }

    /**
     * @param str your string which you want to find
     * @return exist this string in tree or not
     */
    public boolean find(String str) {
        Node point = root;
        for (char part : str.toLowerCase().toCharArray()) {
            if (!point.child.containsKey(part)) {
                return false;
            } else {
                point = point.child.get(part);
            }
        }
        return true;
    }

    /**
     * @param s string which you want to delete
     * @return success or not
     */

    public boolean delete(String s) {
        Deque<Node> stack = new LinkedList<>();
        char[] straight = s.toCharArray();
        Node finder = root;
        for (char c : straight)
            if (finder.getch(c) != null) {
                stack.addFirst(finder);
                finder = finder.getch(c);
            } else return false;
        StringBuilder builder = new StringBuilder(s);
        builder = builder.reverse();
        char[] reverse = builder.toString().toCharArray();
        for (char c : reverse) {
            Node del = stack.removeFirst();
            if (!del.deleteLastNode(c))
                return true;
        }
        return true;
    }

    /**
     * @param str prefix
     * @return all strings which starts from prefix "str"
     */
    public List<String> findAll(String str) {
        char[] prefix = str.toCharArray();
        Node currNode = root;
        boolean check = PrefixTrie.this.find(str);
        List<String> answ = new ArrayList<>();
        String firstPart = new String();
        String partStr = new String();
        String finalString = new String();

        Object[] keyArr = currNode.child.keySet().toArray();
        Object[] nodArr = currNode.childNodes().toArray();

        if (!check) throw new IllegalArgumentException();
        else {
            for (char ch : prefix) {
                if (currNode.getch(ch) == null) {
                    break;
                }
                firstPart = firstPart + ch;
                currNode = currNode.child.get(ch);

                if (!hasChild(currNode)) {
                    finalString = firstPart + partStr;
                    answ.add(finalString);
                    return answ;
                }
            }
            while (hasChild(currNode)) {
                while (hasChild(currNode) && currNode.childNodes().size() == 1) {
                    Object[] part = currNode.child.keySet().toArray();
                    char[] next = part[0].toString().toCharArray();
                    currNode = currNode.getch(next[0]);
                    partStr += part[0];

                }
                if (hasChild(currNode) && currNode.childNodes().size() > 1) {
                    keyArr = currNode.child.keySet().toArray();
                    nodArr = currNode.childNodes().toArray();
                    for (Object key : nodArr) {
                        char[] ch = key.toString().toCharArray();
                        currNode = currNode.getch(ch[0]);
                        partStr += ch;
                        if (hasChild(currNode) && currNode.childNodes().size() == 1)
                            while (currNode.childNodes().size() == 1) {
                                Object[] part = currNode.child.keySet().toArray();
                                char[] next = part[0].toString().toCharArray();
                                currNode = currNode.getch(next[0]);
                                partStr += part[0];
                            }
                    }
                }
                finalString = firstPart + partStr;
                answ.add(finalString);
            }
        }
        return answ;
    }
}