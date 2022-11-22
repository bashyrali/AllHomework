public class Main {
    public static void main(String[] args) {
        Television tv = new Television();
        Computer computer = new Computer();
        Refregerator refregerator = new Refregerator();
        tv.switchOn();
        tv.switchOff();
        computer.switchOn();
        computer.switchOff();
        refregerator.switchOn();
        refregerator.openRefregerator();
        refregerator.closeRefregerator();
        refregerator.defrost();
        refregerator.switchOff();
    }
}
