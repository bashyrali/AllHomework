package com.company;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Movie  {
    public String name;
    public int year;
    public String description;
    public Director director;
    public List<Cast> cast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }


    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + cast;
    }


}
