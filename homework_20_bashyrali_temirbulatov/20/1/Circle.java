public class Circle extends Figure {
    int radius;
    double pi = Math.PI;
    public Circle(int a){
        radius = a;
    }
    @Override
    int CalculateSquare() {
        return (int) pi*radius*radius;
        
        
    }

}
