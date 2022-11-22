public abstract class AbstractDoubleSquare implements DoubleSquare {
    protected double area;

    public abstract void buildDoubleSquare(Square square1, Square square2);
    protected abstract double calculateArea();

    public double getArea()
    {
        if(this.area == 0)
        {
            area = calculateArea();
        }
        return calculateArea();
    }

}
