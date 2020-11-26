import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 2, 13);
        try{
            list.addTask("test", "testing", date);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        try{
            list.addTask("", "testing", date);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals(date, list.tasks.get(0).dueDate);
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        assertEquals("test", list.tasks.get(0).title);
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        Date date2 = new Date(2021, 1, 02);
        list.addTask("test", "testing", date);
        try{
            list.editTask("test2", "test", date2, 0);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }

    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        Date date2 = new Date(2021, 01, 02);
        list.addTask("test", "testing", date);
        list.editTask("test2", "test", date2, 0);
        assertEquals(date2, list.tasks.get(0).dueDate);
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        try{
            list.editTask("", "test", date, 0);
            assertTrue(true);
        } catch (Exception e){
            assertFalse(false);
        }

    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskList list = new TaskList();
        Date date = new Date(2020, 12, 13);
        list.addTask("test", "testing", date);
        list.editTask("test2", "test", date, 0);
        assertEquals("test2", list.tasks.get(0).title);
    }
}
