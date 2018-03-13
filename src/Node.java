
import java.util.*;


public class Node {

    HashMap<Character, Node> child = new HashMap<>();

    public Collection<Node> childNodes() {
        return child.values();
    }

    Node getch(char c) {
        return child.get(c);
    }

    public HashMap<Character, Node> getChild() {
        return child;
    }

    public boolean hasChildNode(Node node) {
        Node point = node;
        boolean has;
        if (point.child.size() == 0) has = false;
        else has = true;
        return has;
    }

    public int sizeof() {
        return child.size();
    }

    boolean deleteNode(char c) {
        if (child.get(c).sizeof() == 0) {
            child.remove(c);
            return true;
        } else
            return false;
    }
}
