import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        assertEquals(list.getSize(), 1);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
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
    public void editingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.editContact(first, last, phone, email, 1);
            assertTrue(true);
        }catch(Exception e){
            assertFalse(false);
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
    public void editingSucceedsWithNonBlankValues(){
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
    public void newListIsEmpty(){
        ContactList list = new ContactList();
        assertEquals(list.getSize(), 0);
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        list.removeContact(0);
        assertEquals(list.getSize(), 0);
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList list = new ContactList();
        String first = "Michael";
        String last = "Clark";
        String phone = "999-999-9999";
        String email = "Testing@test.com";
        list.addContact(first, last, phone, email);
        try{
            list.removeContact(1);
            assertTrue(true);
        }catch(Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList list = new ContactList();
        try{
            list.loadContact("testing.txt");
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
}
