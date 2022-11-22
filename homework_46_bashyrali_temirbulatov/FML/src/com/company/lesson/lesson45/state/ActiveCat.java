package com.company.lesson.lesson45.state;

import com.company.lesson.lesson45.Cat;

import java.util.Random;

public class ActiveCat implements CatState{
    @Override
    public void play(Cat cat) {
        int random = new Random().nextInt(2);
        if (random == 0){
            cat.setHappy(0);
            cat.setMessage("Кот пришел в ярость и его уровень счастья упал до 0 а сытость понижена на 10");

        }else {
            cat.setMessage("Вы поиграли с котом уровень счастья повышен на 15 а сытость понижена на 10");
            cat.setSatiety(cat.getSatiety()-10);
            cat.setHappy(cat.getHappy()+15);
        }


    }

    @Override
    public void feed(Cat cat) {
        cat.setSatiety(cat.getSatiety()+15);
        if (cat.getSatiety()>100){
            cat.setHappy(cat.getHappy()-30);
            cat.setMessage("ВЫ перекормили кота он опечален на 30 единиц");
        }else {
            cat.setMessage("Вы накормили кота  уровень сытости повышен на 15 единиц и счастье на 5");

            cat.setHappy(cat.getHappy()+5);
        }
    }

    @Override
    public void sleep(Cat cat) {
        cat.setMessage("Кот ушел спать!БИАТЧ");
        cat.setState(new SleepCat());
    }
}
