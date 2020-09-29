import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest
{
    public void TestComputeBmi()
    {
        double height = 0;
        double weight = 0;
        BodyMassIndex bmi = new BodyMassIndex(height, weight);
        double sum = bmi.computeBmi(75, 150);
        double round = Math.round(sum * 10) / 10.0;

        assertEquals(18.7, round);
    }

    public void TestCategoryBmi()
    {
        double bmi = 18.7;
        double height = 0;
        double weight = 0;
        BodyMassIndex b = new BodyMassIndex(height, weight);
        String category = b.categoryBmi(bmi);

        assertEquals("Normal Weight", category.toString());
    }

    public void TestUnder()
    {
        double height = 72;
        double weight = 120;
        BodyMassIndex bmi = new BodyMassIndex(height,weight);
        double sum = bmi.computeBmi(height, weight);
        String category = bmi.categoryBmi(sum);

        assertEquals("Underweight", category.toString());
    }

    public void TestNormal()
    {
        double height = 75;
        double weight = 150;
        BodyMassIndex bmi = new BodyMassIndex(height,weight);
        double sum = bmi.computeBmi(height, weight);
        String category = bmi.categoryBmi(sum);

        assertEquals("Normal Weight", category.toString());
    }

    public void TestOver()
    {
        double height = 75;
        double weight = 215;
        BodyMassIndex bmi = new BodyMassIndex(height,weight);
        double sum = bmi.computeBmi(height, weight);
        String category = bmi.categoryBmi(sum);

        assertEquals("Overweight", category.toString());
    }

    public void TestObesity()
    {
        double height = 75;
        double weight = 250;
        BodyMassIndex bmi = new BodyMassIndex(height,weight);
        double sum = bmi.computeBmi(height, weight);
        String category = bmi.categoryBmi(sum);

        assertEquals("Obesity", category.toString());
    }
}
