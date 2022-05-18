package com.lumera.wordsearch.Actions;

import java.util.List;
import java.util.function.Predicate;
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

    boolean flag;

    @Override
    public List<String> searchByStartsWith(List<String> words, String startsWith) {
        flag = false;
        Predicate<String> filterStartCharacter = v -> {
            words.forEach(word ->{
                for (int i=0; i < startsWith.length() - 1; i++){
                    if (word.charAt(i)==startsWith.charAt(i)){
                        flag =  true;
                    }
                }
            });
            return flag;
        };

        return words.stream()
                .filter(filterStartCharacter)
                .filter(w -> isIsogram(w))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> searchByEndsWith(List<String> words, String endsWith) {
        return null;
    }

    @Override
    public List<String> searchByContainsOnly(List<String> words, String containsOnly) {
        return null;
    }
}
