
import java.util.*;


public class Node {

    TreeMap<Character, Node> child = new TreeMap<>();

    public Collection<Node> childNodes() {
        return child.values();
    }

    public Node makeNode(Character ch) {
        return child.get(ch);
    }

    public TreeMap<Character, Node> getChild() {
        return child;
    }

    public boolean hasChildNode(Node node) {
        Node point = node;
        boolean has;
        if (point.child.size() == 0) has = false;
        else has = true;
        return has;
    }

    public List<String> getAllStrings(Node node) {
        List<String> answ = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Node currNode = node;
        if (!hasChildNode(currNode)) {
            answ.add("not found");
            return answ;
        }
        while (currNode.childNodes().size() == 1) {
            Object[] keys = currNode.child.keySet().toArray();
            Object[] nodes = currNode.childNodes().toArray();
            builder.append(keys[0]);
            currNode = currNode.child.get(nodes[0]);
        }
        answ.add(builder.toString());
        return answ;
    }
}
