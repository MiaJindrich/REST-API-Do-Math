package com.firstrestapi.models;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayHandler {
    private String what;
    private List<Integer> numbers;

    public ArrayHandler() {
    }

    public ArrayHandler(String action, List<Integer> numbers) {
        this.what = action;
        this.numbers = numbers;
    }

    public Integer sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public Integer multiply(List<Integer> numbers) {
        return numbers.stream().reduce(1, Math::multiplyExact);
    }

    public List<Integer> doubleValues(List<Integer> numbers) {
        return numbers.stream().map(a -> a*2).collect(Collectors.toList());
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
