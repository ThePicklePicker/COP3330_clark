public class Cube extends Shape3D {

    double side;

    public Cube(double s){
        side = s;
    }

    @Override
    public double getVolume() {
        return (side * side * side);
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return 6 * (side * side);
    }
}
