package com.company;

import java.util.Comparator;

public class Director {
    public String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return fullName + '\'' ;
    }
}
