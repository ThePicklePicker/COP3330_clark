import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        mainMenu();

    }

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Main Menu\n---------\n\n1) Create a new list\n2) Load an existing list\n3) Quit\n");
        int choice = input.nextInt();

        if(choice == 1){
            TaskList newList = new TaskList();
            ListOperation();
        }
        else if (choice == 2){
            System.out.println("Enter filename to open:");
            String fileName = input.nextLine();
            ListOperation();
        }
        else if (choice == 3){
            System.exit(0);
        }
    }

    public static void ListOperation(){
        System.out.println("List Operations Menu\n--------------------\n\n1) View the list\n2) Add an item\n" +
                "3) Edit an item\n4) Remove an item\n5) Mark an item as completed\n6) Unmark an item as completed\n" +
                "7) Save the current list\n8) Quit to main menu");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch(choice){
            case(1): TaskList.printList();
                ListOperation();

            case(2): TaskList.addTask();
                ListOperation();

            case(3): TaskList.editTask();
                ListOperation();

            case(4): TaskList.removeTask();
                ListOperation();

            case(5): TaskList.markComplete();
                ListOperation();

            case(6): TaskList.unmark();
                ListOperation();

            case(7): TaskList.saveList();
                ListOperation();

            case(8): mainMenu();

        }
    }
}
