import java.util.Scanner;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("More data inputs? Y or N");
        String input = scanner.nextLine();
        if(input == "Y")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static double getUserHeight()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Height in inches:");
        double height = scanner.nextDouble();
        scanner.nextLine();
        //Check if height is negative
        return height;
    }

    public static double getUserWeight()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Weight in pounds:");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        //Check if weight is negative
        return weight;
    }

    public static void displayBmiInfo(BodyMassIndex bmi)
    {

    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {

    }
}
