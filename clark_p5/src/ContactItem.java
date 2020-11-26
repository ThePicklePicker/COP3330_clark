import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ContactItem {

    String firstName;
    String lastName;
    String phoneNumber;
    String emailAddress;

    public ContactItem(String first, String last, String phone, String email){
        firstName = first;
        lastName = last;
        phoneNumber = phone;
        emailAddress = email;
    }

    public ContactItem(String file){
        String[] arrOfStr = file.split("\\|\\|\\|\\|\\|\\|");
        firstName = arrOfStr[0];
        lastName = arrOfStr[1];
        phoneNumber = arrOfStr[2];
        emailAddress = arrOfStr[3];
    }

    public String toString(ContactItem contact) {
        return ("Name = " + contact.firstName + " " + contact.lastName + "\n"
        + "Phone = " + contact.phoneNumber + "\n" + "Email = " + contact.emailAddress);
    }

    public String toFileStrings(){
        return (firstName + "||||||" + lastName + "||||||" + phoneNumber + "||||||" + emailAddress);
    }


}
