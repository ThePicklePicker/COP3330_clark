import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TaskList {
    public ArrayList<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public int getSize(){
        return tasks.size();
    }

    public void addTask(String name,String description, Date date){
        TaskItem task = new TaskItem(name, description, date);
        tasks.add(task);
        System.out.println("Task successfully added.");
    }

    public void printList(){
        System.out.println("Current Tasks\n-------------\n");

        for(int i = 0; i < tasks.size(); i++){
            String s = tasks.get(i).toString(tasks.get(i));
            System.out.println(i + ") " + s);
        }
    }

    public void markComplete(){
        System.out.println("Uncompleted Tasks\n-----------------\n");
        for(int i = 0; i < tasks.size(); i++){
            if(!tasks.get(i).complete){
                    String s = tasks.get(i).toString(tasks.get(i));
                    System.out.println(i + ") " + s);
            }
        }

        System.out.println("Which task is completed?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        complete(n);
    }

    public void complete(int n){
        tasks.get(n).complete = true;
    }

    public void unmark(){
        System.out.println("Completed Tasks\n-----------------\n");
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).complete){
                String s = tasks.get(i).toString(tasks.get(i));
                System.out.print(i + ") " + s);
            }
        }

        System.out.println("Which task is uncompleted?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        incomplete(n);
    }

    public void incomplete(int n){
        tasks.get(n).complete = false;
    }

    public void editTask(String name, String desc, Date date, int n){

        tasks.get(n).title = name;
        tasks.get(n).description = desc;
        tasks.get(n).dueDate = date;
    }

    public void removeTask(){
        printList();

        System.out.println("Which task would you like to remove?");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        deleteTask(n);
    }

    public void deleteTask(int n){
        tasks.remove(n);
    }

    public void saveList() {
        System.out.println("Enter file name to save as: ");
        Scanner string = new Scanner(System.in);
        String filename = string.nextLine();
        File file = new File(filename);
        try {
            if(file.createNewFile()){
                System.out.println("File created");
                writeFile(file);
            } else {
               //file exists
                writeFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File saved");
    }

    public void loadList(String filename) {

        File file = new File(filename);
        try {
            if(file.exists()) {
                Scanner s = new Scanner(file);
                while(s.hasNextLine()){
                    String str = s.nextLine();
                    tasks.add(new TaskItem(str));
                }
                System.out.println("File loaded");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(File file){
        try {
            PrintWriter print = new PrintWriter(file);
            for (TaskItem task : tasks) {
                print.println(task.toFileString());
            }
            print.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
