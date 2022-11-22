package com.company;

import jdk.dynalink.Operation;

import java.util.HashMap;
import java.util.Map;

public class AllEvents implements Event {
    Map<Integer, Runnable> mapEvent = new HashMap<>();
    public AllEvents(Dealer dealer){
        mapEvent.put(0, ()->this.regularDay(dealer));
        mapEvent.put(1, ()->this.rain(dealer));
        mapEvent.put(2, ()->this.flatRoad(dealer));
        mapEvent.put(3, ()->this.brokeTelega(dealer));
        mapEvent.put(4, ()->this.river(dealer));
        mapEvent.put(5, ()->this.meetLocal(dealer));
        mapEvent.put(6, ()->this.robbers(dealer));
        mapEvent.put(7, ()->this.tavern(dealer));
        mapEvent.put(8, ()->this.productGoneBad(dealer));
        mapEvent.get(dealer.randomNum(0, 8)).run();
    }

    public Map<Integer, Runnable> getMapEvent() {
        return mapEvent;
    }

    public void setMapEvent(Map<Integer, Runnable> mapEvent) {
        this.mapEvent = mapEvent;
    }

    @Override
    public void regularDay(Dealer dealer) {
        System.out.println("Обычный день. Ничего не произошло.");

    }

    @Override
    public void rain(Dealer dealer) {

        if (dealer.randomNum(1,5)==1){
            int index = dealer.randomNum(0,dealer.getTelega().size()-1);
            dealer.getTelega().get(index).getQuality().degradeQality(dealer.getTelega().get(index));
            System.out.format("Пошел дождь %s испортилось его качество стало %s",dealer.getTelega().get(index).getTypeProduct(),dealer.getTelega().get(index));
        }else {
            System.out.println("Пошел Дождь!");
        }

    }

    @Override
    public void flatRoad(Dealer dealer) {
        System.out.println("Ровная дорога каееффф)");
        if((dealer.getSpeedTelega()+2) > 5){
            dealer.setSpeedTelega(5);
        }
        else {
            dealer.setSpeedTelega(dealer.getSpeedTelega()+2);
        }
    }

    @Override
    public void brokeTelega(Dealer dealer) {
        System.out.println("Телега сломалась. День впустую, стоим на месте");
        dealer.setSpeedTelega(0);
    }

    @Override
    public void river(Dealer dealer) {
        System.out.println("На речке.Торговец Потратил целый день, пока искал брод");
        dealer.setSpeedTelega(dealer.randomNum(1, 2));
    }

    @Override
    public void meetLocal(Dealer dealer) {
        System.out.println("Торговец Встретил местного. Удалось срезать часть пути");
        dealer.setSpeedTelega(dealer.getSpeedTelega()+dealer.randomNum(3, 6));

    }

    @Override
    public void robbers(Dealer dealer) {

        if (dealer.getStartMoney()>10){
            dealer.setStartMoney(dealer.getStartMoney()-dealer.getStartMoney());
            System.out.println("На торговца напали разбойники, он отплатился деньгами");
        }else {
            int index = dealer.randomNum(0,dealer.getTelega().size()-1);
            dealer.getTelega().remove(index);
            System.out.println("На торговца напали разбойники, он отплатил товаром");
        }
    }

    @Override
    public void tavern(Dealer dealer) {
        if (dealer.randomNum(1, 2)==1){
            System.out.println("Торговец решил остановиться на трактире");
            dealer.setSpeedTelega(0);
            switch (dealer.randomNum(1,3)){
                case 1:
                    System.out.println("Торговец продал");
                    break;
                case 2:
                    System.out.println("Торговец обменял товар");
                    break;
                case 3:
                    System.out.println("Торговец купил товар");
                    break;
            }
        }

    }

    @Override
    public void productGoneBad(Dealer dealer) {
        System.out.println("Случайно испортился один из товаров");
        int index = dealer.randomNum(0,dealer.getTelega().size()-1);
        dealer.getTelega().get(index).getQuality().degradeQality(dealer.getTelega().get(index));
    }
}
