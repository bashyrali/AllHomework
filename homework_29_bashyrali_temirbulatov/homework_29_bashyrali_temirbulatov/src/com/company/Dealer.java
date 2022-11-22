package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dealer {
    private City city;
    private int distance;
    private int maxWeight;
    List<Product> telega;
    private int speedTelega;
    private int startMoney;
    private int beginMoney;
    private AllEvents allEvents;


    public Dealer(){
        city = City.values()[randomNum(0, 5)];
        city.setCityRoad(randomNum(50, 100));
        this.distance = city.getCityRoad();

        this.startMoney = randomNum(50, 100);
        this.beginMoney = this.startMoney;
        this.maxWeight = randomNum(50, 100);

        this.telega= new ArrayList<>();

    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Product> getTelega() {
        return telega;
    }

    public void setTelega(List<Product> telega) {
        this.telega = telega;
    }





    public int getDistance() {
        return distance;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {this.maxWeight = maxWeight;
    }

    public int getSpeedTelega() {
        return speedTelega;
    }

    public void setSpeedTelega(int speedTelega) {
        this.speedTelega = speedTelega;
    }

    public int getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }


    public void fillTelega(){
        int count = 0;
        this.telega.add(new Product());
        while (this.maxWeight>telega.get(count).weight && this.startMoney>telega.get(count).price){
            this.maxWeight -= telega.get(count).getWeight();
            this.startMoney -= telega.get(count).getPrice();
            count++;
            telega.add(new Product());
        }


    }
    public void goToCity(){
        int day=1;
        while (this.distance >0){
            System.out.format("День %2s\n",day);
            this.speedTelega = randomNum(1, 5);
            this.allEvents = new AllEvents(this);


            distance-=speedTelega;
            if (distance<0){
                distance= 0;
            }

            System.out.format("Осталось проехать %s лиг\n\n",distance);
            day++;

        }
    }
    public void endTravel(){
        int income = 0;
        for (int i = 0; i < telega.size(); i++) {
            income += getTelega().get(i).price*getTelega().get(i).getQuality().getProductEnum().getQuality();
            System.out.format("Привез %s единиц %s  (Состояние %s.Купил за %s. Продал за %s)\n",getTelega().get(i).getWeight(), getTelega().get(i).getTypeProduct(), getTelega().get(i).getQuality().getProductEnum(),getTelega().get(i).getPrice(),getTelega().get(i).getPrice()*getTelega().get(i).getQuality().getProductEnum().getQuality());
        }
        System.out.format("Начинал с %2s монет, сейчас у меня %s монет. Заработал %s\n",beginMoney,income, income-beginMoney);
    }

    public void showTelega(){
        int weightProducts = 0;
        for (int i = 0; i < telega.size(); i++) {
            weightProducts+= getTelega().get(i).getWeight();
            System.out.format("Купил %s %s единиц (Состояние идеальное %s за %s)\n",getTelega().get(i).getTypeProduct(),getTelega().get(i).getWeight(), getTelega().get(i).getQuality().getProductEnum(),getTelega().get(i).getPrice());
        }
        System.out.format("Остались %2s монет, загрузил %s единиц товара\n\n",this.startMoney,weightProducts);
    }
    int randomNum(int a, int b){
        Random random = new Random();
        return  a + random.nextInt(b - a + 1);
    }
}
