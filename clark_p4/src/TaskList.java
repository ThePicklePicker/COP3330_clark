import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList {
    public static ArrayList<TaskItem> tasks;
    public static int num;

    public TaskList(){
        tasks = new ArrayList<>();
        num = 0;
    }

    public ArrayList<TaskItem> getArrayList(){
        return tasks;
    }

    public static void addTask(){
        Scanner string = new Scanner(System.in);
        System.out.println("Enter task name:");
        String name = string.nextLine();
        System.out.println("Enter description:");
        String description = string.nextLine();
        System.out.println("Enter due date in YYYY/MM/DD format:");
        Scanner dates = new Scanner(System.in);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(dates.nextLine());
            String sdf = new SimpleDateFormat("yyyy/MM/dd").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TaskItem task = new TaskItem(name, description, date);
        tasks.add(task);
        num += num;
        System.out.println("Task successfully added.");
    }

    public static void printList(){
        System.out.println("Current Tasks\n-------------\n\n");

        for(int i = 0; i < tasks.size(); i++){
            String s = TaskItem.toString(tasks.get(i));
            System.out.println(i + ") " + s);
        }
    }

    public static void markComplete(){
        System.out.println("Uncompleted Tasks\n-----------------\n\n");
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).complete == false){
                    String s = TaskItem.toString(tasks.get(i));
                    System.out.println(i + ") " + s);
            }
        }

        System.out.println("Which task is completed?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        tasks.get(n).complete = true;
    }

    public static void unmark(){
        System.out.println("Completed Tasks\n-----------------\n\n");
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).complete == true){
                String s = TaskItem.toString(tasks.get(i));
                System.out.print(i + ") " + s);
            }
        }

        System.out.println("Which task is uncompleted?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        tasks.get(n).complete = false;
    }

    public static void editTask(){
        printList();

        System.out.println("Which task would you like to edit?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();

        Scanner string = new Scanner(System.in);
        System.out.println("Enter new task name:");
        String name = string.nextLine();
        System.out.println("Enter new description:");
        String desc = string.nextLine();
        System.out.println("Enter new due date in YYYY/MM/DD format:");
        Scanner d = new Scanner(System.in);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy/MM/dd").parse(d.nextLine());
            String sdf = new SimpleDateFormat("yyyy/MM/dd").format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tasks.get(n).title = name;
        tasks.get(n).description = desc;
        tasks.get(n).dueDate = date;
    }

    public static void removeTask(){
        printList();

        System.out.println("Which task would you like to remove?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        tasks.remove(n);
    }

    public static void saveList(){
        System.out.println("Enter file name to save as: ");
        Scanner string = new Scanner(System.in);
        String filename = string.nextLine();
        Formatter x = null;
        try {
            x = new Formatter(filename);
        }
        catch(Exception e){
            System.out.println("error");
        }

        for(int i = 0; i < tasks.size(); i++){
            String s = TaskItem.toString(tasks.get(i));
            x.format(s);
        }

        x.close();

        System.out.println("File saved");
    }

}
