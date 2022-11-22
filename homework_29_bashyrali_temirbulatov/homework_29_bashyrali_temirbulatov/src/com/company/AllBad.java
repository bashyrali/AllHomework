package com.company;

public class AllBad extends Quality{
    public AllBad(){
        this.productEnum = ProductEnum.ALLBAD;
    }

    @Override
    void degradeQality(Product product) {
        System.out.println("Товар протух!");
    }
}
