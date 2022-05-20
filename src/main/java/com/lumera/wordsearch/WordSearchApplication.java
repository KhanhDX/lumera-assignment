package com.lumera.wordsearch;

import com.lumera.wordsearch.Actions.IsogramSearch;
import com.lumera.wordsearch.Actions.PalindromeSearch;
import com.lumera.wordsearch.Actions.Search;
import com.lumera.wordsearch.Actions.SemordnilapSearch;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
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

    public static void processToSearch(List<String> words, Scanner sc, Search search) {
        while (true) {
            try {
                System.out.print("***** MAX LENGTH   : ");
                String maxLengthStr = sc.next();
                Integer maxLength = Integer.parseInt(maxLengthStr);
                System.out.println();

                System.out.print("***** MIN LENGTH   : ");
                sc.nextLine();
                String minLengthStr = sc.nextLine();
                Integer minLength = Integer.parseInt(minLengthStr);
                System.out.println();

                System.out.print("***** START WITH   : ");
                String startWith = sc.nextLine();
                System.out.println();

                System.out.print("***** END WITH     : ");
                String endWith = sc.nextLine();
                System.out.println();

                System.out.print("***** CONTAINS ONLY: ");
                String containsonly = sc.nextLine();
                System.out.println();


                if (!checkIfAnyNull(startWith, endWith, maxLength, minLength, containsonly)) {
                    List<String> r1 = searchWords(search,
                            words,
                            startWith,
                            endWith,
                            maxLength,
                            minLength,
                            containsonly);
                    System.out.println(r1);
                    break;
                } else {
                    System.out.println("***** INVALID INPUT, PLEASE TRY AGAIN");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("***** INVALID INPUT, PLEASE TRY AGAIN");
                continue;
            }
        }
    }

    public static List<String> searchWords(Search search,
                                           List<String> words,
                                           String startWith,
                                           String endWith,
                                           Integer maxLength,
                                           Integer minLength,
                                           String containsonly){
        List<String> r1 = search.searchByStartsWith(words,startWith);
        List<String> r2 = search.searchByEndsWith(r1,endWith);
        r1 = search.searchByMaxLength(r2,maxLength);
        r2 = search.searchByMinLength(r1,minLength);
        r1 = search.searchByContainsOnly(r2,containsonly);
        return r1;
    }

    private static boolean checkIfAnyNull(String startWith,
                                          String endWith,
                                          Integer maxLength,
                                          Integer minLength,
                                          String containsonly){
        return (Objects.isNull(startWith) ||
                "".equals(startWith) ||
                Objects.isNull(endWith) ||
                "".equals(endWith) ||
                Objects.isNull(maxLength) ||
                Objects.isNull(minLength) ||
                "".equals(containsonly) ||
                Objects.isNull(containsonly)) ? true : false;

    }
}
