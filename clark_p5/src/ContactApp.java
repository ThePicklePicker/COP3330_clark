import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ContactApp {

    private static ContactList newList;

    public static void mainMenu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Main Menu\n---------\n\n1) Create a new list\n2) Load an existing list\n3) Quit\n");
        int choice = input.nextInt();

        if(choice == 1){
            newList = new ContactList();
            ListOperation();
        }
        else if (choice == 2){
            newList = new ContactList();
            System.out.println("Enter file name to save as: ");
            Scanner string = new Scanner(System.in);
            String filename = string.nextLine();
            newList.loadContact(filename);
            ListOperation();
        }
        else if (choice == 3){
            App.menu();
        }
    }

    public static void ListOperation(){
        System.out.println("List Operations Menu\n--------------------\n\n1) View the list\n2) Add an item\n" +
                "3) Edit an item\n4) Remove an item\n" +
                "5) Save the current list\n6) Quit to main menu");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch(choice){
            case(1): newList.printList();
                ListOperation();

            case(2): Scanner string = new Scanner(System.in);
                System.out.println("First name: ");
                String first = string.nextLine();

                System.out.println("Last name: ");
                String last = string.nextLine();

                System.out.println("Phone number (xxx-xxx-xxxx): ");
                String phone = string.nextLine();

                System.out.println("Email address (x@y.z): ");
                String email = string.nextLine();

                newList.addContact(first, last, phone, email);
                ListOperation();

            case(3):
                newList.printList();

                System.out.println("Which contact would you like to edit?");
                Scanner num = new Scanner(System.in);
                int nu = num.nextInt();
                Scanner strings = new Scanner(System.in);
                System.out.println("Enter a new first name for contact " + nu + ": ");
                String firsts = strings.nextLine();

                System.out.println("Enter a new last name for contact " + nu + ": ");
                String lasts = strings.nextLine();

                System.out.println("Enter a new phone number (xxx-xxx-xxxx) for contact " + nu + ": ");
                String phones = strings.nextLine();

                System.out.println("Enter a new email address (x@y.z) for contact " + nu + ": ");
                String emails = strings.nextLine();

                newList.editContact(firsts, lasts, phones, emails, nu);
                ListOperation();

            case(4):
                newList.printList();

                System.out.println("Which contact would you like to remove?");
                Scanner nums = new Scanner(System.in);
                int n = nums.nextInt();
                newList.removeContact(n);
                ListOperation();

            case(5): newList.saveContact();
                ListOperation();

            case(6): mainMenu();

        }
    }
}
