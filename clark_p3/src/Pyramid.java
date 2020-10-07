public class Pyramid extends Shape3D{

    double length;
    double width;
    double height;

    public Pyramid(double l, double w, double h){
        length = l;
        width = w;
        height = h;
    }

    @Override
    public double getVolume() {
        return (length * width * height) / 3;
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
       return ((length * width) + length * Math.sqrt((width/2 * width/2) + (height * height)) + width * Math.sqrt((length/2 * length/2) + (height * height)));
    }
}
