package com.lumera.wordsearch;

import com.lumera.wordsearch.Actions.IsogramSearch;
import com.lumera.wordsearch.Actions.PalindromeSearch;
import com.lumera.wordsearch.Actions.Search;
import com.lumera.wordsearch.Actions.SemordnilapSearch;

import java.util.List;
import java.util.Scanner;

import static com.lumera.wordsearch.WordlistKt.readWordList;

/**
 * Entry point of application.
 */
public class WordSearchApplication {
    public static void main(String[] args) {
        var words = readWordList("wordlist.txt");
        // ToDo: implement more

        Scanner sc = new Scanner(System.in);
        Search isogram = new IsogramSearch();
        Search palindrome = new PalindromeSearch();
        Search semordnilap = new SemordnilapSearch();


        System.out.println("***** SELECT TYPE OF WORD YOU WANT TO SEARCH *****");
        System.out.println("***** 1. ISOGRAM");
        System.out.println("***** 2. PALINDROME");
        System.out.println("***** 3. SEMORDNILAP");

        Short choice = -1;

        while (choice!=0) {
            System.out.print("***** PLEASE INPUT YOUR CHOICE: ");
            choice = sc.nextShort();

            switch (choice) {
                case 0:
                    System.out.println("***** EXIT *****");
                    break;
                case 1: {
                    processToSearch(words, sc, isogram);
                    continue;
                }
                case 2: {
                    processToSearch(words, sc, palindrome);
                    continue;
                }
                case 3: {
                    processToSearch(words, sc, semordnilap);
                    continue;
                }
                default: {
                    System.out.println("***** INCORRECT INPUT, PLEASE TRY AGAIN !!!");
                    continue;
                }
            }
        }
    }

    private static void processToSearch(List<String> words, Scanner sc, Search search) {
        System.out.print("***** MAX LENGTH   : ");
        Integer maxLength = sc.nextInt();
        System.out.println();

        System.out.print("***** MIN LENGTH   : ");
        Integer minLength = sc.nextInt();
        System.out.println();

        System.out.print("***** START WITH   : ");
        sc.nextLine();
        String startWith = sc.nextLine();
        System.out.println();

        System.out.print("***** END WITH     : ");
        String endWith = sc.nextLine();
        System.out.println();

        System.out.print("***** CONTAINS ONLY: ");
        String containsonly = sc.nextLine();
        System.out.println();

        List<String> r1 = search.searchByStartsWith(words,startWith);
        List<String> r2 = search.searchByEndsWith(r1,endWith);
        r1 = search.searchByMaxLength(r2,maxLength);
        r2 = search.searchByMinLength(r1,minLength);
        r1 = search.searchByContainsOnly(r2,containsonly);

        System.out.println(r1);
    }
}
