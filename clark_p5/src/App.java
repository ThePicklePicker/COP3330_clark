import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        System.out.println("Select your application\n-----------------------\n1)Task list\n2)Contact list\n3)Quit");
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();

        if(i == 1){
            TaskApp.mainMenu();
        }
        else if (i == 2){
            ContactApp.mainMenu();
        }
        else if(i == 3){
            System.exit(0);
        }
    }


}
