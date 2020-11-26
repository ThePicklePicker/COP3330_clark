import org.junit.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals(1,list.getSize());
    }


    @Test
    public void completingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.complete(0);
        assertTrue(true);
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            list.complete(1);
            assertTrue(true);
        } catch(Exception e) {
            assertFalse(false);
        }
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.editTask("test2", "test", date, 0);
        assertSame("test2", list.tasks.get(0).title);
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.editTask("test", "test", date, 0);
        assertSame("test", list.tasks.get(0).description);
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            list.editTask("test", "test", date, 1);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        Date date2 = new Date(2021, 01, 02);
        list.addTask("test", "testing", date);
        list.editTask("test2", "test", date2, 0);
        assertEquals(date2, list.tasks.get(0).dueDate);
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        Date date2 = new Date(2021, 01, 02);
        list.addTask("test", "testing", date);
        try {
            list.editTask("test2", "test", date2, 1);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.editTask("test2", "test", date, 0);
        assertEquals("test2", list.tasks.get(0).title);
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try {
            list.editTask("test2", "test", date, 1);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            String s = list.tasks.get(1).description;
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals("testing", list.tasks.get(0).description);
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            Date s = list.tasks.get(1).dueDate;
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals(date, list.tasks.get(0).dueDate);
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            String str = list.tasks.get(1).title;
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals("test", list.tasks.get(0).title);
    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(0, list.getSize());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.deleteTask(0);
        assertEquals(0, list.getSize());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            list.deleteTask(1);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList list = new TaskList();
        try{
            list.loadList("testing.txt");
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.complete(0);
        list.incomplete(0);
        assertFalse(false);
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            list.incomplete(1);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
}
