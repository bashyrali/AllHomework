package com.company.lesson.lesson45.state;

import com.company.lesson.lesson45.Cat;

public interface CatState {
    void play(Cat cat);
    void feed(Cat cat);
    void sleep(Cat cat);
}
