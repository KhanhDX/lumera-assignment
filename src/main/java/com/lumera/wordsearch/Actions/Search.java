package com.lumera.wordsearch.Actions;

import java.util.List;

public interface Search {
    List<String> searchByMaxLength(List<String> words, Integer maxLength);
    List<String>  searchByMinLength(List<String> words, Integer minLength);
    List<String>  searchByStartsWith(List<String> words, String startsWith);
    List<String>  searchByEndsWith(List<String> words, String endsWith);
    List<String>  searchByContainsOnly(List<String> words, String containsOnly);
}
