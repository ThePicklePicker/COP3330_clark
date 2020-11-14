import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {

    Date dueDate;
    String title;
    String description;
    boolean complete;

    public TaskItem(String name, String define, Date date){
        title = name;
        description = define;
        dueDate = date;
        complete = false;
    }

    public TaskItem(String file){
        String[] arrOfStr = file.split("\\|\\|\\|\\|\\|\\|");
        title = arrOfStr[1];
        description = arrOfStr[2];
        try {
            dueDate = new SimpleDateFormat("yyyy/MM/dd").parse(arrOfStr[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        complete = Boolean.getBoolean(arrOfStr[3]);
    }

    public String toString(TaskItem taskItem) {
        return ("[" + dueDate(taskItem.dueDate) + "]" + " " + taskItem.title + ": " + taskItem.description);
    }

    public String dueDate(Date date){
        String sdf;
        return sdf = new SimpleDateFormat("yyyy/MM/dd").format(date);
    }

    public String toFileString(){
        return (dueDate(dueDate) + "||||||" + title + "||||||" + description + "||||||" + complete);
    }




}
