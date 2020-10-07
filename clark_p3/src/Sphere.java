public class Sphere extends Shape3D{

    double radius;

    public Sphere(double r){
        radius = r;
    }

    @Override
    public double getVolume() {
        return (4*Math.PI*Math.pow(radius, 3))/3;
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * (radius * radius);
    }
}
