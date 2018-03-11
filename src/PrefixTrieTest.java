import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefixTrieTest {
    @Test
    public void input() {
        PrefixTrie a = new PrefixTrie();
        a.input("test");
        assertEquals(a.input("test"), a.find("test"));
    }

    @Test
    public void delete() {
        PrefixTrie a = new PrefixTrie();
        a.input("abcd");
        a.input("abfg");
        a.input("abqw");
        a.input("qwerty");
        assertEquals(true, a.delete("abcd"));
        assertEquals(false, a.find("abcd"));
        assertEquals(true, a.find("abfg"));
        assertEquals(true, a.find("abqw"));
    }

    @Test
    public void find() {
        PrefixTrie a = new PrefixTrie();
        String testStr1 = "test";
        String testStr2 = "qwerty";
        String testStr3 = "nagibator";
        a.input(testStr1);
        a.input(testStr2);
        assertEquals(true, a.find(testStr1));
        assertEquals(true, a.find(testStr2));
        assertEquals(false, a.find(testStr3));
    }

    @Test
    public void hasChild() {
        PrefixTrie a = new PrefixTrie();
        a.input("abcd");
        a.input("abwq");
        String testString1 = "abcd";
        String testString2 = "abqw";
        Node withChild = a.listNodes(testString1).get(1);
        Node withOutChild = a.listNodes(testString1).get(3);
        assertEquals(true, a.hasChild(withChild));
        assertEquals(false, a.hasChild(withOutChild));
    }

    @Test
    public void listNodes() {
        PrefixTrie a = new PrefixTrie();
        String str = "abcd";
        a.input(str);
        List<Node> answ = a.listNodes(str);
        assertEquals(answ, a.listNodes(str));
    }

    @Test
    public void findAll() {
        PrefixTrie a = new PrefixTrie();
        a.input("qwerty");
        a.input("abcd");
        a.input("abqw");
        a.input("abfg");
        List<String> answ = new ArrayList<>();
        answ.add("abcd");
        answ.add("abqw");
        answ.add("abfg");
        assertEquals(true, a.find("abcd"));
        assertEquals(answ, a.findAll("a"));
    }
}

