import java.lang.String;
import java.lang.Integer;

public class Decoder
{
    public static String decode(String num) {
        int [] array = new int [4];
        int number = Integer.parseInt(num);

        for(int i = 1; i <= 4; i++)
        {
            array[4 - i] = number % 10;
            number = number / 10;
        }

        int temp = array[0];
        array[0] = array[2];
        array[2] = temp;

        temp = array[1];
        array[1] = array[3];
        array[3] = temp;

        for(int i = 0; i < 4; i++)
        {
            array[i] = (array[i]- 7);
            if(array[i] < 0)
            {
                array[i] = array[i] + 10;
            }
        }

        int newnumber = 0;

        for (int i = 0; i < 4; i++)
        {
            newnumber = (newnumber * 10) + array[i];
        }

        String tem = Integer.toString(newnumber);

        if(newnumber / 1000 == 0)
        {
            String en = "0";
            tem = en+tem;
        }
        return tem;
    }
}
