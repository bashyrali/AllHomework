public class Computer implements Switchable {
    
    private String name = "Computer";
    

    @Override
    public void switchOn() {
        
        System.out.println(name +" is ON");
        
    }

    @Override
    public void switchOff() {
        
        System.out.println(name +" is OFF");
        
    }
    
}
