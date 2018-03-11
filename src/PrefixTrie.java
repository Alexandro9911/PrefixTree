
import java.util.ArrayList;
import java.util.List;


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
     *
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
     *
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
     *
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
     *
     * @param str string which you want to delete
     * @return Successful or not
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

    /**
     *
     * @param str its a first symbol of strings
     * @return all strings which have first letter str
     */

    public List<String> findAll(String str) { // не готово еще
        boolean check = PrefixTrie.this.find(str);
        List<String> answ = new ArrayList<>();
        Node currentNode = root;
        if (!check) throw new IllegalArgumentException();
        else {
            StringBuilder builder = new StringBuilder();
            List<Node> nodes = listNodes(str);
            builder.append(nodes.get(0).child.firstKey());
            currentNode = nodes.get(0);
            Object[] keyArr = currentNode.child.keySet().toArray();
            builder.append(keyArr[0]);
            if (hasChild(currentNode) && currentNode.child.values().size() == 1) {

            }
            answ.add(builder.toString());
            return answ;
        }
    }
}

