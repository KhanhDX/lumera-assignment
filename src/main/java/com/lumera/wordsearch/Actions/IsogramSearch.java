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
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByMinLength(List<String> words, Integer minLength) {
        return words.stream()
                .filter(w -> w.length()>=minLength)
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByStartsWith(List<String> words, String startsWith) {
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (startsWith.length() <= word.length()) {
                if (startsWith.equals(word.substring(0,startsWith.length()))){
                    result.add(word);
                }
            }
        }

        return result.stream()
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByEndsWith(List<String> words, String endsWith) {
        List<String> result = new ArrayList<>();
        for (String word: words){
            if (endsWith.length() <= word.length()) {
                if (endsWith.equals(word.substring(word.length()-endsWith.length()))){
                    result.add(word);
                }
            }
        }

        return result.stream()
                .filter(w -> isIsogram(w))
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
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }
}
