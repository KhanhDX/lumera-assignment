package com.lumera.wordsearch.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeSearch implements Search{

    private boolean isPalindrome(String word){
        StringBuilder wordBuilder = new StringBuilder(word);
        String reverseWord = wordBuilder.reverse().toString();
        return reverseWord.equals(wordBuilder);
    }


    @Override
    public List<String> searchByMaxLength(List<String> words, Integer maxLength) {
        return words.stream()
                .filter(w -> w.length()>=maxLength)
                .filter(this::isPalindrome)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByMinLength(List<String> words, Integer minLength) {
        return words.stream()
                .filter(w -> w.length()>=minLength)
                .filter(this::isPalindrome)
                .collect(Collectors.toList());    }

    @Override
    public List<String> searchByStartsWith(List<String> words, String startsWith) {
        List<String> results = new ArrayList<>();
        for (String word: words) {
            if (startsWith.length() <= word.length()) {
                if (startsWith.equals(word.substring(0,startsWith.length()))){
                    results.add(word);
                }
            }
        }

        return results.stream()
                .filter(this::isPalindrome)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByEndsWith(List<String> words, String endsWith) {
        List<String> results = new ArrayList<>();
        for (String word: words){
            if (endsWith.length() <= word.length()) {
                if (endsWith.equals(word.substring(word.length()-endsWith.length()))){
                    results.add(word);
                }
            }
        }

        return results.stream()
                .filter(this::isPalindrome)
                .collect(Collectors.toList());    }

    @Override
    public List<String> searchByContainsOnly(List<String> words, String containsOnly) {
        String[] characters = containsOnly.split("");
        List<String> result = null;

        for (String character : characters){
            result = words.stream()
                    .filter(w -> w.contains(character))
                    .collect(Collectors.toList());
        }

        return result.stream()
                .filter(w -> isPalindrome(w))
                .collect(Collectors.toList());
    }
}
