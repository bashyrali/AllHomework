public class Triangle extends Figure {
    int base;
    int height;
    public Triangle(int a, int b){
        base = a;
        height = b;
    }
    @Override
    int CalculateSquare() {
        return (base * height)/2;
    }
}
