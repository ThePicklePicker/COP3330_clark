public class Circle extends Shape2D {

    double radius;

    public Circle(double r){
        radius = r;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }
}
