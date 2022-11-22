package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String file = "movie.json";
        JsonReader jsonReader = new JsonReader();
        Root root = jsonReader.FromJson(file);

        root.sortByName();
        root.showList();

        root.sortByYear();
        root.showList();

        root.reverseSortName();
        root.showList();

        root.reverseSortYear();
        root.showList();


        root.sortByDirect();
        root.showList();

        root.reverseSortByDirector();
        root.showList();

        System.out.println("Поиск фильма по названию");
        String input1 = System.console().readLine();
        root.searchElement(input1);
        System.out.println("Критерий поиска \"имя актера\"");
        String input2 = System.console().readLine();
        root.searchElement(input2);
        System.out.println("Критерий поиска \"имя режиссера\"");
        String input3 = System.console().readLine();
        root.searchElement(input3);

        System.out.println("Критерий поиска \"год выпуска фильма\"");
        String input4 = System.console().readLine();
        root.searchElement(input4);
        System.out.println("Списка фильмов и роль того или иного актера в этом фильме. Критерий поиска \"имя актера\" ");
        String input5 = System.console().readLine();
        root.searchElement(input5);




    }
    }
