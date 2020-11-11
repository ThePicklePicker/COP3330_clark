import java.util.Date;

public class TaskItem {

    String title;
    String description;
    Date dueDate;
    boolean complete;

    public TaskItem(String name, String define, Date date){
        title = name;
        description = define;
        dueDate = date;
        complete = false;
    }

    public static String toString(TaskItem taskItem) {
        return ("[" + taskItem.dueDate + "]" + " " + taskItem.title + ": " + taskItem.description + ("\n"));
    }




}
