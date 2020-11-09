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
            //call create TaskList
            System.out.println("List created successfully");
            ListOperation();

        }
        else if (choice == 2){
            System.out.println("Enter filename to open:");
            String fileName = input.nextLine();
            //call open TaskList using file name given
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
            case(1): System.out.println("Enter list name:");
                String name = input.nextLine();
                //call view list using title name

            case(2): //add an item to the list

            case(3): //edit an item in the list

            case(4): //Remove an item from the list

            case(5): //Mark an item complete

            case(6): //unmark an item

            case(7): //save the list

            case(8): mainMenu();

        }
    }
}
