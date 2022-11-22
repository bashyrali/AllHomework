public class Refregerator implements Open,Defrost {
    
    private String name ="Refregerator";
   
    @Override
    public void switchOn() {
        System.out.println(name +" is ON");
        
    }
    @Override
    public void switchOff() {
        System.out.println(name +" is OFF");
        
    }
    @Override
    public void openRefregerator() {
        System.out.println("The refregerator is opened!");
        
    }
    @Override
    public void closeRefregerator() {
        System.out.println("The refregerator is closed!");
        
    }
    @Override
    public void defrost() {
        System.out.println("Refregeraotr start to defrost!");
        
    }
    
}
