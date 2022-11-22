public class Main {
    public static void main(String[] args) {
        MySquare square1 = new MySquare(10);
        MySquare square2 = new MySquare(12);
        MyDoubleSquare doubleSquare = new MyDoubleSquare();
        doubleSquare.buildDoubleSquare(square1, square2);
        System.out.println(String.format("Площадь doubleSquare = %s", doubleSquare.getArea()));

    }
}
