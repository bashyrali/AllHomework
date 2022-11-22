public class Television implements Switchable{
    private String name = "Television";

    @Override
    public void switchOn() {
        System.out.println(name +" is ON");
        
    }

    @Override
    public void switchOff() {
        System.out.println(name +" is OFF");
    }

    
}
