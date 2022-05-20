package com.lumera.wordsearch.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IsogramSearch implements Search{

    private boolean isIsogram(String word){
        boolean result=true;
        for(int i=0;i<word.length();i++){
            for(int j=i+1;j<word.length();j++){
                if(word.charAt(i)==word.charAt(j)){
                    result=false;
                }
            }
        }
        return result;
    }

    @Override
    public List<String> searchByMaxLength(List<String> words, Integer maxLength) {
        return words.stream()
                .filter(w -> w.length()<=maxLength)
                .filter(this::isIsogram)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByMinLength(List<String> words, Integer minLength) {
        return words.stream()
                .filter(w -> w.length()>=minLength)
                .filter(this::isIsogram)
                .collect(Collectors.toList());
    }

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
                .filter(this::isIsogram)
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
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());    }

    @Override
    public List<String> searchByContainsOnly(List<String> words, String containsOnly) {
        String[] characters = containsOnly.split("");
        List<String> results = new ArrayList<>();

        for (String character : characters){
            results = words.stream()
                    .filter(w -> w.contains(character))
                    .collect(Collectors.toList());
        }

        return results.stream()
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }
}
