package taskmanager;
import tasks.Task;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class TaskManager {
    // Instance Variables
    private List<Task> taskList = new ArrayList<>();

    // Add task
    public String addTask(Task task) {
        taskList.add(task);
        return "Task added successfully";
    }

    
    // Remove task
    public String removeTask(int id) {
        Optional<Task> taskOpt = findTaskById(id);
        if(!taskOpt.isPresent()) {
            System.out.println("Inside if");
            return taskNotFoundMessage(id);
        }
        taskList.remove(taskOpt.get());
        return "Task is removed successfully";
    }

    // Mark task as Completed
    public String markAsDone(int id) {
        Optional<Task> taskOpt = findTaskById(id);

        if(!taskOpt.isPresent()) return taskNotFoundMessage(id);

        if(taskOpt.get().getStatus().equalsIgnoreCase("Completed")) return "The task is already completed";

        taskOpt.get().setStatus("Completed");
        return "The task is marked as done";
    }

    // List all tasks
    public void listTasks() {
        if(taskList.isEmpty()) 
        {
            System.out.println("Task List is Empty");
            return;
        }
        for(Task task : taskList) {
            System.out.printf("ID: %d | Title: %s | Status: %s%n", task.getId(), task.getTitle(), task.getStatus());
        }
    }

    // Helper Methods

    private Optional<Task> findTaskById(int id) {
        return taskList.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    public String taskNotFoundMessage(int id) {
        return "The Given task id \"" + id + "\" is not found";
    }

}