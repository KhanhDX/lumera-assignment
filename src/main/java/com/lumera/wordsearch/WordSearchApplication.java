package com.lumera.wordsearch;

import com.lumera.wordsearch.Actions.IsogramSearch;
import com.lumera.wordsearch.Actions.Search;

import static com.lumera.wordsearch.WordlistKt.readWordList;

/**
 * Entry point of application.
 */
public class WordSearchApplication {
    public static void main(String[] args) {
        var words = readWordList("wordlist.txt");
        // ToDo: implement more

        Search isogramSearch = new IsogramSearch();

        System.out.println("***** SELECT TYPE OF WORD YOU WANT TO SEARCH *****");
        System.out.println("***** 1. ISOGRAM");
        System.out.println("***** 2. PALINDROME");
        System.out.println("***** 3. SEMORDNILAP");
        System.out.println("***** PLEASE INPUT YOUR CHOICE: ");

        System.out.println(isogramSearch.searchByStartsWith(words, "abc"));
    }
}
