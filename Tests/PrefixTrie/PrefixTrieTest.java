package PrefixTrie;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrefixTrieTest {

    @Test
    public void input() {
        PrefixTrie a = new PrefixTrie();
        assertEquals(true, a.input("test1"));
        assertEquals(false, a.input("test1"));
        assertEquals(true, a.input("testnumber3"));
        assertEquals(true, a.input("testnumbertest"));
        List<String> answ = new ArrayList<>();
        answ.add("test1");
        answ.add("testnumber3");
        answ.add("testnumbertest");
        assertEquals(answ, a.findAllStrings("te"));
    }

    @Test
    public void find() {
        PrefixTrie a = new PrefixTrie();
        String testStr1 = "test";
        String testStr2 = "tqwerty";
        String testStr3 = "nagibator";
        a.input(testStr1);
        a.input(testStr2);
        assertEquals(true, a.find(testStr1));
        assertEquals(true, a.find(testStr2));
        assertEquals(false, a.find(testStr3));
        assertEquals(false, a.find("tes"));
    }

    @Test
    public void delete() {
        PrefixTrie a = new PrefixTrie();
        a.input("abcd");
        a.input("abfg");
        a.input("abqw");
        a.input("qwerty");
        List<String> answ = new ArrayList<>();
        answ.add("abqw");
        answ.add("abfg");
        assertEquals(true, a.delete("abcd"));
        assertEquals(false, a.find("abcd"));
        assertEquals(answ, a.findAllStrings("a"));
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
        answ.add("abqw");
        answ.add("abcd");
        answ.add("abfg");
        assertEquals(true, a.find("abcd"));
        assertEquals(answ, a.findAllStrings("ab"));
        assertEquals(answ2, a.findAllStrings("az"));
    }
}