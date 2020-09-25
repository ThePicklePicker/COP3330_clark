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

        assertEquals(18.7, sum);
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
}
