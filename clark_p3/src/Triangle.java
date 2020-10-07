public class Triangle extends Shape2D {
    double base;
    double height;

    public Triangle(double b, double h){
        base = b;
        height = h;
    }

    @Override
    public String getName() {
        return "triangle";
    }

    @Override
    public double getArea() {
        return (height * base)/2;
    }
}
