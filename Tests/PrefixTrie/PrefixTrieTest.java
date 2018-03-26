package PrefixTrie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefixTrieTest {

    @Test
    public void input() {
        PrefixTrie a = new PrefixTrie();
        a.input("test");
        assertEquals(true, a.find("test"));
        assertEquals(false, a.input("test"));
        assertEquals(false, a.input(""));
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
        assertEquals(false, a.find("te"));

    }

    @Test
    public void findAllStrings() {
        PrefixTrie a = new PrefixTrie();
        a.input("qwerty");
        a.input("abcd");
        a.input("abqw");
        a.input("abfg");
        List<String> answ = new ArrayList<>();
        List<String> answ2 = new ArrayList<>();
        answ.add("abcd");
        answ.add("abfg");
        answ.add("abqw");
        assertEquals(true, a.find("abcd"));
        assertEquals(answ, a.findAllStrings("ab"));
        assertEquals(answ2, a.findAllStrings("az"));
    }

}