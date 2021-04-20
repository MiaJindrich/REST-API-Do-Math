package com.firstrestapi.models;

public class Greeter {
    private String name;
    private String title;
    private String error;

    public Greeter() {
        error = "Please provide a name and a title!";
    }

    public Greeter(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getGreeting() {
        if(error == null) {
            return "Oh, hi there "+name+ ", my dear "+title+"!";
        }
        return error;
    }
}
