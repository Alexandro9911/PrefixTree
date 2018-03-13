
import java.util.*;


public class Node {

    HashMap<Character, Node> child = new HashMap<>();

    public Collection<Node> childNodes() {
        return child.values();
    }

    Node getch(char c) {
        return child.get(c);
    }


    public int sizeof() {
        return child.size();
    }

    boolean deleteLastNode(char c) {
        if (child.get(c).sizeof() == 0) {
            child.remove(c);
            return true;
        } else
            return false;
    }
}
