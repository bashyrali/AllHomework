package homework.elevator;

import java.util.Random;

public class Elevator {
    int currentFloor;
    int capacity = 200;
    int maxFloor;
    public Elevator(int currentFloor, int maxFloor){
        this.currentFloor = currentFloor;
        this.maxFloor = maxFloor;
    }
    public int moveToFloor(int floor, int currentFloor){
        int step;
        if(currentFloor < floor){
            step = floor - currentFloor;
            for (int i = 0; i < step; i++) {
                currentFloor += 1;
                System.out.println("Floor: "+ currentFloor);
            }
        }
        else{
            step = currentFloor - floor;
            for (int i = 0; i < step; i++) {
            currentFloor -= 1;
            System.out.println("Floor: "+ currentFloor);
        }
        }
        
        return floor;
    }
    
    
    public boolean isAllowableWeight(int floor, int capacity) {
        if (capacity >= floor) {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isAllowableFloor(int floor, int maxFloor) {
        if (maxFloor >= floor) {
            return true;
        }
        else{
            return false;
        }
    }
    public int value() {
        Random random =new Random();
        return random.nextInt(3)+1;
    }
}
