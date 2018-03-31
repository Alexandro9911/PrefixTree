package PrefixTrie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    @Test
    public void deleteLastNode() {
        PrefixTrie a = new PrefixTrie();
        Node currNode = a.root;
        char[] key = "qwerty".toCharArray();
        a.input("abcd");
        a.input("q");
        assertEquals(true, currNode.deleteLastNode(key[0]));
    }

    @Test
    public void listNodes() {
        PrefixTrie a = new PrefixTrie();
        String str = "abcd";
        int stringLength = str.length();
        a.input(str);
        Deque<Node> answ = a.listNodes(str);
        assertEquals(stringLength, answ.size());
    }

    @Test
    public void findAll() {
        PrefixTrie a = new PrefixTrie();
        a.input("abcd");
        a.input("aqwe");
        a.input("asdf");
        a.input("answ");
        List<String> answ = new ArrayList<>();
        answ.add("aqwe");
        answ.add("abcd");
        answ.add("asdf");
        answ.add("answ");
        assertEquals(answ, a.root.getAllWords());
    }
}
