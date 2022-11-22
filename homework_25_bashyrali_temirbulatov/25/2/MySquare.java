public class MySquare implements Square {
    private double side;
    public MySquare(double side) {
        super();
        this.side= side;
    }
    @Override
    public double getSide() {
        
        return this.side;
    }

    
}