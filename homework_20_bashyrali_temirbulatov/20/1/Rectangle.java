public class Rectangle extends Figure{
    int firstSide;
    int secondSide;
    public Rectangle(int a, int b){
        firstSide = a;
        secondSide = b;
    }
    @Override
    int CalculateSquare() {
        return firstSide * secondSide;
        
    }

}
