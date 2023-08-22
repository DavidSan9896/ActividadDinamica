package ExercisesOf05.LinKedList;

import java.util.Date;
import java.util.LinkedList;

public class TaskManager {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void addTask(String description, Date dueDate, String assignedTo) {
        tasks.add(new Task(description, dueDate, assignedTo));
    }

    public LinkedList<Task> getTasksForUser(String username) {
        LinkedList<Task> userTasks = new LinkedList<>();
        for (Task task : tasks) {
            if (task.assignedTo.equals(username)) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }
}

