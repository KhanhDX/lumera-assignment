package com.lumera.wordsearch;

import com.lumera.wordsearch.Actions.IsogramSearch;
import com.lumera.wordsearch.Actions.PalindromeSearch;
import com.lumera.wordsearch.Actions.Search;
import com.lumera.wordsearch.Actions.SemordnilapSearch;
import com.lumera.wordsearch.models.Isogram;
import com.lumera.wordsearch.models.Model;
import com.lumera.wordsearch.models.Palindrome;
import com.lumera.wordsearch.models.Semordnilap;
import org.junit.Test;

import static com.lumera.wordsearch.WordlistKt.readWordList;
import static org.junit.Assert.assertEquals;

public class SomethingTest {
    @Test
    public void isogram_validTest() {
        Model isogram = new Isogram();
        isogram.setMaxLength(6);
        isogram.setMinLength(1);
        isogram.setStartWith("dr");
        isogram.setEndWith("w");
        isogram.setContainsOnly("a");

        Search isogramSearch = new IsogramSearch();
        assertEquals( "draw",
                WordSearchApplication.searchWords(
                isogramSearch,
                        readWordList("wordlist.txt"),
                isogram.getStartWith(),
                isogram.getEndWith(),
                isogram.getMaxLength(),
                isogram.getMinLength(),
                isogram.getContainsOnly()).get(0));
    }

    @Test
    public void palindrome_validTest() {
        Model palindrome = new Palindrome();
        palindrome.setMaxLength(6);
        palindrome.setMinLength(2);
        palindrome.setStartWith("dr");
        palindrome.setEndWith("w");
        palindrome.setContainsOnly("a");

        Search search = new PalindromeSearch();
        assertEquals( "draw",
                WordSearchApplication.searchWords(
                        search,
                        readWordList("wordlist.txt"),
                        palindrome.getStartWith(),
                        palindrome.getEndWith(),
                        palindrome.getMaxLength(),
                        palindrome.getMinLength(),
                        palindrome.getContainsOnly()).get(0));
    }

    @Test
    public void semordnilap_validTest() {
        Model semordnilap = new Semordnilap();
        semordnilap.setMaxLength(6);
        semordnilap.setMinLength(1);
        semordnilap.setStartWith("dr");
        semordnilap.setEndWith("w");
        semordnilap.setContainsOnly("a");

        Search search = new SemordnilapSearch();
        assertEquals( "draw",
                WordSearchApplication.searchWords(
                        search,
                        readWordList("wordlist.txt"),
                        semordnilap.getStartWith(),
                        semordnilap.getEndWith(),
                        semordnilap.getMaxLength(),
                        semordnilap.getMinLength(),
                        semordnilap.getContainsOnly()).get(0));
    }
}
