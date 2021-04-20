package com.firstrestapi.models;

public class DoUntil {
    private Integer input;

    public DoUntil() {
    }

    public DoUntil(Integer input) {
        this.input = input;
    }

    public Integer getInput() {
        return input;
    }

    public Integer sum(Integer n) {
        if(n!=0) {
            return n + sum(n-1);
        }
        return n;
    }

    public Integer factor(Integer n) {
        if(n==0) {
            return 1;
        }
        return n * factor(n-1);
    }
}
