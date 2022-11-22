package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        var cats = Cat.makeCats(10);
        Scanner in = new Scanner(System.in);
        Printer.print(cats);
        cats.sort(((p1,p2)->p1.getBreed().toString().compareTo(p2.getBreed().toString())));
        Printer.print(cats);
        cats.sort(Comparator.comparing(Cat::getName).thenComparingInt(Cat::getAge));
        Printer.print(cats);
        String input = in.next();
        cats.removeIf(cat -> cat.byColor(input));
        Printer.print(cats);
        cats.removeIf(cat -> cat.byLength(5));
        Printer.print(cats);
//        cats.sort(Comparator.comparing(Cat::getName));
//        Printer.print(cats);
//        cats.sort(Comparator.comparing(Cat::getAge));
        // А сюда добавьте код, который будет сортировать коллекцию котов
        // используйте лямбда-выражения и ссылки на методы
        //cats.sort(?);
        //Printer.print(cats);
    }


}
