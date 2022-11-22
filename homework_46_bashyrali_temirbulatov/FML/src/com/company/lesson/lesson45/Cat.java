package com.company.lesson.lesson45;

import com.company.lesson.lesson45.state.ActiveCat;
import com.company.lesson.lesson45.state.CatState;

import java.util.Random;

public class Cat {
    private String name;
    private int age;
    private int happy;
    private int satiety;
    private String avatar;
    private String message = "Создание кота выполнено успешно";
    private String action;
    private CatState state;

    public Cat(String name) {
        this.name = name;
        Random random = new Random();
        this.state = new ActiveCat();
        this.age =random.nextInt(10) + 1;
        this.happy = random.nextInt(100) ;
        this.satiety = random.nextInt(100);
        setAvatar();
    }

    public void actionCat(){
        switch (action){
            case "play":
                state.play(this);
                break;
            case "feed":
                state.feed(this);
                break;
            case "sleep":
                state.sleep(this);
                break;

        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar() {
        if (happy < 20) {
            this.avatar = "https://memepedia.ru/wp-content/uploads/2019/12/kot-gruzitsja-9.jpg";
        } else if (happy > 20 && happy < 50) {
            this.avatar = "https://www.meme-arsenal.com/memes/a88cc31487c2533a7d2c8d3f35805a76.jpg";
        } else if (happy >= 51 && happy < 75) {
            this.avatar = "https://krasivosti.pro/uploads/posts/2021-04/1617935219_49-p-smeshnie-rozhi-kotov-58.png";
        }
        else if (happy>75){
            this.avatar = "https://icdn.lenta.ru/images/2019/12/29/16/20191229162041144/pwa_list_rect_1280_35b06e2bd3403fb2d4748e36b1e25189.png";
        }
    }

    public CatState getState() {
        return state;
    }

    public void setState(CatState state) {
        this.state = state;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }
}
