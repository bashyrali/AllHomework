package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Product {
    Quality quality;
    double price;
    int weight;
    String[] typeProductGen={"Мясо","Сухофрукты","Зерно","Мука","Ткань","Краска"};
    String typeProduct;
    HashMap<Integer,Quality> mapQuality = new HashMap<>();



    public Product() {
        this.typeProduct = this.typeProductGen[randomNum(0,5)];
        this.quality= new Normal();
        this.price = randomNum(5, 15) ;
        this.weight = randomNum(2, 10);



    }
    public HashMap<Integer, Quality> getMapQuality() {
        return mapQuality;
    }


    public Quality getQuality() {
        return quality;
    }


    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    int randomNum(int a, int b){
        Random random = new Random();
        return  a + random.nextInt(b - a + 1);
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "quality=" + quality +
                ", price=" + price +
                ", weight=" + weight +
                ", typeProductGen=" + Arrays.toString(typeProductGen) +
                ", typeProduct='" + typeProduct + '\'' +
                ", mapQuality=" + mapQuality +
                '}';
    }
}
