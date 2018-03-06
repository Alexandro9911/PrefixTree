
import java.util.ArrayList;
import java.util.List;


public class PrefixTrie {

    Node root = new Node();


    public boolean hasChild(Node node) {
        Node point = node;
        boolean has;
        if (point.child.size() == 0) has = false;
        else has = true;
        return has;
    }

    public void input(String str) { //  1 добавление строк в дерево
        Node point = root;
        for (Character PartKey : str.toLowerCase().toCharArray()) {
            if (!point.child.containsKey(PartKey)) {
                point.child.put(PartKey, new Node());
            }
            point = point.child.get(PartKey);
        }
    }

    public boolean find(String str) { // 2 поиск строки в дереве
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

    public String delete(String str) {
        boolean check = PrefixTrie.this.find(str); // 3 проверяем существует ли вообще такая строка которую надо удалить
        Node point = root;
        if (!check) {
            return "string not exist";
        } else {
            ArrayList<Node> nodes = new ArrayList<>();
            for (char part : str.toLowerCase().toCharArray()) { // создаем список адресов префикслв строки которую надо удалить
                if (!point.child.containsKey(part)) {
                    return "string not exist";
                } else {
                    point = point.child.get(part);
                    nodes.add(point);
                }
            }
            for (int m = nodes.size() - 1; m > 0; m--) { // последовательно удаляем все символы с конца
                point = nodes.get(m);
                if (!PrefixTrie.this.hasChild(point)) {
                    point.child.clear();
                } else {
                    Node childNode = nodes.get(m);
                    point.child.replace(point.child.firstKey(), childNode);
                }
            }
            return "string was successful deleted";
        }
    }

    public List<String> findAll(String prefix) { // 4  поиск всех строк с заданным префиксом
        List<String> answ = new ArrayList<>();
        boolean check = PrefixTrie.this.find(prefix);
        Node point = root;
        StringBuilder builder = new StringBuilder();
        String completedString;
        if (!check) {
            answ.add("prefix not exist");
            return answ;
        } else {
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
