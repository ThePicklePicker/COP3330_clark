import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class TaskList {

    File title;

    public TaskList(String name){
        try {
            title = new File(name);
            if(title.createNewFile()){
                System.out.println("List created successfully");
            }
            else{
                System.out.println("File already exists");
            }
        } catch(Exception e){
            System.out.println("An error has occurred");
        }
    }

    public static void addTask(){
        
    }

    public static void removeTask(){

    }

    public static void printList(String name) {
        File file = new File(name);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }

}
