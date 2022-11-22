package com.company;

import com.google.gson.annotations.SerializedName;

import java.util.*;


public class Root  {

    ArrayList<Movie> movies =  new ArrayList<>();
    Map<String ,String > hashMovie = new HashMap<>();


    public ArrayList<Movie> getMovie() {
        return movies;
    }

//    public void searchActor(String search){ Пытался сделать через hasmap не получилось
//
//        for (Movie movie: movies) {
//            hashMovie.put(movie.cast.toString(),movie.getName());
//        }
//        System.out.println(hashMovie.get(search));
//        System.out.println(hashMovie);
//    }


    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void sortByName(){
        movies.sort(Comparator.comparing(Movie::getName));
    }
    public void reverseSortName(){
        movies.sort(Comparator.comparing(Movie::getName).reversed());
    }
    public void reverseSortYear(){
        movies.sort(Comparator.comparing(Movie::getYear).reversed());
    }
    public void sortByYear(){
        movies.sort(Comparator.comparing(Movie::getYear));
    }
    public void sortByDirect(){
       movies.sort(new MovieDirectorComparator());
    }
    public void reverseSortByDirector(){
        movies.sort(new MovieDirectorComparator().reversed());
    }

    public void searchElement(String s){

        for(Movie inName:movies){
            if(inName!=null)
                if(inName.toString().toLowerCase().contains(s.toLowerCase())) {
                    System.out.println(inName.getName());}
        }
    }

    void showList(){
        for (Movie s : movies) {
            System.out.printf("%41s|%7s|%10s|%17s|%10s\n", s.getName(), s.getYear(), s.getDescription(), s.getDirector().getFullName(), s.getCast().toString());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "movie=" + movies +
                '}';
    }
}
