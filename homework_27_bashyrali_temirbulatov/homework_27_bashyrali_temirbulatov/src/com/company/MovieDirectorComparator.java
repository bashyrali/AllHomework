package com.company;

import java.util.Comparator;
import java.util.function.Function;

public class MovieDirectorComparator implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.director.fullName.compareTo(o2.director.fullName);
    }
}
