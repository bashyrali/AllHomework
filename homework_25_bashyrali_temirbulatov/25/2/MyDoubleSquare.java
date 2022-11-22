public class MyDoubleSquare extends AbstractDoubleSquare {
    private double first_square;
    private double double_square;
    @Override
    public void buildDoubleSquare(Square square1, Square square2) {
        first_square = square1.getSide() * square1.getSide();
        double_square = square2.getSide() * square2.getSide();
    }

    @Override
    protected double calculateArea() {
        return first_square + double_square;
    }
    
}
