public class Square extends Shape2D{

    double side;

    public Square(double s){
        side = s;
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getArea() {
        return (side * side);
    }
}
