
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PrefixTrie {

    Node root = new Node();

    public List<Node> listNodes(String str) {
        Node point = root;
        List<Node> nodes = new ArrayList<>();
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

    public boolean hasChild(Node node) {
        Node point = node;
        boolean has;
        if (point.child.size() == 0) has = false;
        else has = true;
        return has;
    }

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

    public boolean delete(String str) {
        boolean check = PrefixTrie.this.find(str);
        Node point = root;
        if (!check) {
            return false;
        } else {
            List<Node> nodes = listNodes(str);
            for (int m = nodes.size() - 1; m > 0; m--) {
                point = nodes.get(m);
                if (!PrefixTrie.this.hasChild(point)) {
                    point.child.clear();
                } else {
                    Node childNode = nodes.get(m);
                    point.child.replace(point.child.firstKey(), childNode);
                }
            }
            return true;
        }
    }

    public List<String> findAll(String prefix) {
        List<String> answ = new ArrayList<>();
        boolean check = PrefixTrie.this.find(prefix);
        Node point = root;
        StringBuilder builder = new StringBuilder();
        if (!check) {
            answ.add("prefix not exist");
            return answ;
        } else {
            String completedString;
            List<Node> nodes = listNodes(prefix);
            for (int m = nodes.size(); m > 0; m--) {
                point = nodes.get(m);
                List<Node> variants = nodes.subList(0, m);
                for (int i = variants.size() - 1; i > 0; i--) {

                }
            }
         /*   for (char part : prefix.toLowerCase().toCharArray()) {
                List<Node> listOfNodes = new ArrayList<>();
                listOfNodes.addAll(point.child.values());
                for (Node oneOfNodes : listOfNodes)
                    if (oneOfNodes.child.containsKey(part)) {
                        builder.append(part);
                        point = point.child.get(part);
                    }
            } */
        }
        return answ;
    }
}

