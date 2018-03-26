package PrefixTrie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AnotherTests {
    @Test
    public void sizeof() {
        PrefixTrie a = new PrefixTrie();
        Node point = a.root;
        String str = "abcd";
        a.input(str);
        a.input("aqwe");
        a.input("alexandro9911");
        char[] key = str.toCharArray();
        Node currNode = point.children.get(key[0]);
        assertEquals(3, currNode.sizeof());
    }

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
    public void childNodes() {
        PrefixTrie a = new PrefixTrie();
        Node point = a.root;
        a.input("abcd");
        a.input("qwerty");
        Collection<Node> answ = a.root.childNodes();
        int q = answ.size();
        assertEquals(2, a.root.childNodes().size());
    }

    @Test
    public void listNodes() {
        PrefixTrie a = new PrefixTrie();
        String str = "abcd";
        int stringLength = str.length();
        a.input(str);
        List<Node> answ = a.listNodes(str);
        assertEquals(stringLength, answ.size());
    }

    @Test
    public void findAll() {
        PrefixTrie a = new PrefixTrie();
        a.input("abcd");
        a.input("aqwe");
        a.input("asdf");
        a.input("ans");
        List<String> answ = new ArrayList<>();
        answ.add("abcd");
        answ.add("ans");
        answ.add("aqwe");
        answ.add("asdf");
        assertEquals(answ, a.root.getAllWords());

    }
}
