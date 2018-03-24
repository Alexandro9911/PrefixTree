
import java.util.*;


public class Node {

    TreeMap<Character, Node> children = new TreeMap<>();


    /**
     * @return Collection of children
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
     * @return quantity of children
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
        } else
            return false;
    }

    /**
     * @param ch char
     * @return all strings with this char
     */

    public List<String> findAll(char ch) {
        List<String> answ = new ArrayList<>();
        String str = "";
        Node currNode = new Node();
        currNode = this.getch(ch);
        str += ch;
        Object[] keyArr = currNode.children.keySet().toArray();
        Object[] keyInt = currNode.children.keySet().toArray();
        int Q = keyArr.length;
        if (Q == 0) {
            answ.add(str);
            return answ;
        } else {
            for (int i = 0; i != Q; i++) {
                char[] next = keyArr[i].toString().toCharArray();
                currNode = this.getch(next[0]);
                keyInt = this.children.keySet().toArray();
                int N = keyInt.length;
                if (N == 0) {
                    str += next[i];
                } else {
                    return findAll(next[0]);
                }
            }
            return answ;
        }
    }
}
