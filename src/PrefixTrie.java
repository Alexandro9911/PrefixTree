
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
                finalString = firstPart + partStr;
                answ.add(finalString);
            }
        }
        return answ;
    }

    /**
     * @param ch char
     * @return List of all possible strings, which starts from char ch
     */

    public List<String> findAllStrings(char ch) {  // НЕ РОБИТ
        List<String> answ = new ArrayList<>();
        String finalString = new String();
        String partString = new String();
        String firstString = new String();
        Object[] keyArr;
        firstString += ch;

        Node currNode = root.getch(ch);

        keyArr = currNode.child.keySet().toArray();

        if (keyArr.length == 0) {
            System.out.println("last"); //  далее выводы на консоль для проверки правильности кода
            finalString = firstString + partString;
            answ.add(finalString);
            return answ;
        } else {
            System.out.println("length Arr = " + keyArr.length);
            for (int i = 0; i < keyArr.length; i++) {
                System.out.println("loop");
                partString += keyArr[i];
                System.out.println("currString = " + firstString + partString);
                char[] c = partString.toCharArray();
                System.out.println("c[i]= " + c[i]);
                System.out.println("i=" + i);
                currNode = currNode.getch(c[i]);
                keyArr = currNode.child.keySet().toArray();
                System.out.println("length Arr = " + keyArr.length);
                answ = findAllStrings(c[i]);
                return answ;
            }
        }
        return answ;
    }
}