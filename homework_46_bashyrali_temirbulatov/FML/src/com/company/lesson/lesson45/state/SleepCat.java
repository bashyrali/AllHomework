package com.company.lesson.lesson45.state;

import com.company.lesson.lesson45.Cat;

import java.util.Random;

public class SleepCat implements CatState{
    @Override
    public void play(Cat cat) {
        cat.setMessage("Вы разбудили кота -5 единиц счастья");
        cat.setHappy(cat.getHappy()-5);
        cat.setState(new ActiveCat());
    }

    @Override
    public void feed(Cat cat) {
        cat.setMessage("Спящего кота нельзя кормить");
    }

    @Override
    public void sleep(Cat cat) {
        cat.setMessage("Кот уже спит!");
    }
}
