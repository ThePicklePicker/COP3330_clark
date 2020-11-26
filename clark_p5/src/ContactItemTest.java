import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        try {
            list.addContact("", "", "", "");
            assertTrue(true);
        }catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "";
        try{
            list.addContact(first, last, phone, email);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }

    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        String first = "";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        try{
            list.addContact(first, last, phone, email);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        try{
            list.addContact(first, last, phone, email);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "";
        String email = "Testing@test.com";
        try{
            list.addContact(first, last, phone, email);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        try{
            list.addContact(first, last, phone, email);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void editingFailsWithAllBlankValues(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact("", "", "", "", 0);
            assertTrue(true);
        }catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact(first, last, phone, "", 0);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact("", last, phone, email, 0);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact(first, "", phone, email, 0);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact(first, last, "", email, 0);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void editingSucceedsWithWithNonBlankValues(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact("Mike", last, phone, email, 0);
            assertFalse(false);
        }catch (Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void testToString(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        String s = list.contacts.get(0).toString(list.contacts.get(0));
        assertEquals(s,"Name = Michael Clark\nPhone = 999-999-9999\nEmail = Testing@test.com");
    }
}
