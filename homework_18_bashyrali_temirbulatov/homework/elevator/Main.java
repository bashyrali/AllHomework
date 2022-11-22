package homework.elevator;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(1, 20);
        boolean start = true;
        while (start) {
            System.out.println("Enter your floor|Enter 0 for stop| Current Floor is "+ elevator.currentFloor);
            int floor = Integer.parseInt(System.console().readLine());
            System.out.println("Max weight is 200kg. Enter yout weight|");
            int weight = Integer.parseInt(System.console().readLine());
            if (elevator.isAllowableFloor(floor, elevator.maxFloor) &&  elevator.isAllowableWeight(weight, elevator.capacity)) {
                elevator.currentFloor = elevator.moveToFloor(floor, elevator.currentFloor);
            }else if (floor == 0) {
                start = false;
            }
            else{
                System.out.println("Incorect input! Try again!");
            }
        }

    }
}
