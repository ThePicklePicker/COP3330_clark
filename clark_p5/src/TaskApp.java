import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class TaskApp {

    private static TaskList newList;

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Main Menu\n---------\n\n1) Create a new list\n2) Load an existing list\n3) Quit\n");
        int choice = input.nextInt();

        if(choice == 1){
            newList = new TaskList();
            ListOperation();
        }
        else if (choice == 2){
            newList = new TaskList();
            System.out.println("Enter file name to save as: ");
            Scanner string = new Scanner(System.in);
            String filename = string.nextLine();
            newList.loadList(filename);
            ListOperation();
        }
        else if (choice == 3){
            App.menu();
        }
    }

    public static void ListOperation(){
        System.out.println("List Operations Menu\n--------------------\n\n1) View the list\n2) Add an item\n" +
                "3) Edit an item\n4) Remove an item\n5) Mark an item as completed\n6) Unmark an item as completed\n" +
                "7) Save the current list\n8) Quit to main menu");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch(choice){
            case(1): newList.printList();
                ListOperation();

            case(2): Scanner string = new Scanner(System.in);
                String name = null;
                boolean n = false;
                while (n == false){
                    System.out.println("Enter task name:");
                    name = string.nextLine();
                    if(name.length() == 0){
                        System.out.println("Invalid title.");
                    }
                    else{
                        n = true;
                    }
                }
                System.out.println("Enter description:");
                String description = string.nextLine();
                System.out.println("Enter due date in YYYY/MM/DD format:");
                Scanner dates = new Scanner(System.in);
                Date date = null;
                while(date == null) {
                    try {
                        date = new SimpleDateFormat("yyyy/MM/dd").parse(dates.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Date is incorrect. Please try again.");
                    }
                }
                newList.addTask(name, description, date);
                ListOperation();

            case(3):
                newList.printList();

                System.out.println("Which task would you like to edit?");
                Scanner num = new Scanner(System.in);
                int nu = num.nextInt();
                Scanner strings = new Scanner(System.in);
                String names = null;
                boolean na = false;
                while (na == false){
                    System.out.println("Enter task name:");
                    names = strings.nextLine();
                    if(names.length() == 0){
                        System.out.println("Invalid title.");
                    }
                    else{
                        na = true;
                    }
                }

                System.out.println("Enter new description:");
                String descr = strings.nextLine();
                System.out.println("Enter new due date in YYYY/MM/DD format:");
                Scanner d = new Scanner(System.in);
                date = null;
                while(date == null) {
                    try {
                        date = new SimpleDateFormat("yyyy/MM/dd").parse(d.nextLine());
                        String sdf = new SimpleDateFormat("yyyy/MM/dd").format(date);
                    } catch (ParseException e) {
                        System.out.println("Date is incorrect. Please try again.");
                    }
                }
                newList.editTask(names, descr, date, nu);
                ListOperation();

            case(4): newList.removeTask();
                ListOperation();

            case(5): newList.markComplete();
                ListOperation();

            case(6): newList.unmark();
                ListOperation();

            case(7): newList.saveList();
                ListOperation();

            case(8): mainMenu();

        }
    }
}
