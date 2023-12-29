package com.example.project162.Domain;

public class Location {
    private int Id;
    private String Loc;

    public Location() {
    }

    // Add a constructor that takes a String parameter for the location name
    public Location(String loc) {
        Loc = loc;
    }

    @Override
    public String toString() {
        return Loc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }
}