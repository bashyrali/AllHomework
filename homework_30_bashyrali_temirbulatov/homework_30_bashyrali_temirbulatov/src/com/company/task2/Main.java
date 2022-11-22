package com.company.task2;

import java.util.ArrayList;

import static com.company.task2.ActiveCat.*;

public class Main {

    public static void main(String[] args) {
        // исправьте код так, что бы на экран выводилось что-то вроде.
        // Я Misty. Я прыгаю!
        // Я Tibbles. Я сплю!
        // Я Ginger. Я кушаю!
        // для решения примените лямбда-выражения,

        // каждый кот должен уметь выполнять что-то своё
        var cats = new ArrayList<ActiveCat>();
        Action action;
        cats.add(new ActiveCat(action= ActiveCat::jump));
        cats.add(new ActiveCat(action= ActiveCat::sleep));
        cats.add(new ActiveCat(action= ActiveCat::eat));
        // добавьте ещё два-три кота, с совершенно другими действиями

        cats.forEach(ActiveCat::doAction);
    }


}
