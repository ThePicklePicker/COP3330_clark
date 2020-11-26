import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    public ArrayList<ContactItem> contacts;

    public ContactList(){
        contacts = new ArrayList<>();
    }

    public int getSize(){
        return contacts.size();
    }

    public void printList(){
        System.out.println("Current Contacts\n-------------\n");

        for(int i = 0; i < contacts.size(); i++){
            String s = contacts.get(i).toString(contacts.get(i));
            System.out.println(i + ") " + s);
        }
    }

    public void addContact(String first, String last, String phone, String email){
        if(first == "" && last == "" && phone == "" && email == ""){
            System.out.println("Contact cannot be created with no information");
        }else {
            ContactItem contact = new ContactItem(first, last, phone, email);
            contacts.add(contact);
            System.out.println("Contact successfully added.");
        }
    }

    public void editContact(String first, String last, String phone, String email, int n){
        if(first == "" && last == "" && phone == "" && email == ""){
            System.out.println("Contact cannot be created with no information");
        }else {
            contacts.get(n).firstName = first;
            contacts.get(n).lastName = last;
            contacts.get(n).phoneNumber = phone;
            contacts.get(n).emailAddress = email;
        }

    }

    public void removeContact(int n){
        deleteContact(n);
    }

    public void deleteContact(int n){
        contacts.remove(n);
    }

    public void saveContact() {
        System.out.println("Enter file name to save as: ");
        Scanner string = new Scanner(System.in);
        String filename = string.nextLine();
        File file = new File(filename);
        try {
            if(file.createNewFile()){
                System.out.println("File created");
            } else {
                //file exists
                writeFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File saved");
    }

    public void loadContact(String filename) {

        File file = new File(filename);
        try {
            if(file.exists()) {
                Scanner s = new Scanner(file);
                while(s.hasNextLine()){
                    String str = s.nextLine();
                    contacts.add(new ContactItem(str));
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
            for (ContactItem contact : contacts) {
                print.println(contact.toFileStrings());
            }
            print.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
