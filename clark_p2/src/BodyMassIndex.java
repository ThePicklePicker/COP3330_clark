public class BodyMassIndex
{
    public double height;
    public double weight;

    public BodyMassIndex (double height, double weight)
    {
        this.height = height;
        this.weight = weight;
    }

    public static double computeBmi(double height, double weight)
    {
        double sum = (703 * weight) / (height*height);
        return sum;
    }

    public static String categoryBmi(double bmiData)
    {
        if(bmiData < 18.5)
        {
            String category = "Underweight";
            return category;
        }
        else if(bmiData >= 18.5 && bmiData < 25)
        {
            String category = "Normal Weight";
            return category;
        }
        else if(bmiData >= 25 && bmiData < 30)
        {
            String category = "Overweight";
            return category;
        }
        else
        {
            String category = "Obesity";
            return category;
        }
    }
}
