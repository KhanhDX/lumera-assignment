package com.lumera.wordsearch.models;

public class Model {
    public Model() {
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public String getStartWith() {
        return startWith;
    }

    public void setStartWith(String startWith) {
        this.startWith = startWith;
    }

    public String getEndWith() {
        return endWith;
    }

    public void setEndWith(String endWith) {
        this.endWith = endWith;
    }

    public String getContainsOnly() {
        return containsOnly;
    }

    public void setContainsOnly(String containsOnly) {
        this.containsOnly = containsOnly;
    }

    private Integer maxLength;
    private Integer minLength;
    private String startWith;
    private String endWith;
    private String containsOnly;

    public Model(Integer maxLength, Integer minLength, String startWith, String endWith, String containsOnly) {
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.startWith = startWith;
        this.endWith = endWith;
        this.containsOnly = containsOnly;
    }
}
