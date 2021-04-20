package com.firstrestapi.models;

public class Doubling {
    private Integer input;
    private Integer result;
    private String error;

    public Doubling() {
        this.error = "Please provide an input!";
    }

    public Doubling(Integer input) {
        this.input = input;
        this.result = input*2;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
