package com.example.soulsborne_project;

public class Soulsborne {
    private final String name;
    private final int year;
    private final String difficulty;
    private final String rating;
    private final String runtime;

    public Soulsborne(String name, int year, String difficulty, String rating, String runtime) {
        this.name = name;
        this.year = year;
        this.difficulty = difficulty;
        this.rating = rating;
        this.runtime = runtime;
    }

    /* Methods the return the data to the ViewHolder */
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getDifficulty() { return difficulty; }
    public String getRating() { return rating; }
    public String getRuntime() { return runtime; }
}
