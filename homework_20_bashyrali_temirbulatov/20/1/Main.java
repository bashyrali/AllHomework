
public class Main {
    public static void main(String[] args) {
        
        Rectangle rectangle = new Rectangle(5,10);
        Triangle triangle = new Triangle(4, 6);
        Circle circle = new Circle(3);
        System.out.print(rectangle.CalculateSquare() + "\n" + triangle.CalculateSquare()+ "\n" + circle.CalculateSquare());
    }
    
}