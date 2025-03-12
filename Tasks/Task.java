package tasks;
public class Task {

    // Instance variables
    private int  id;
    private String title;
    private String status;

    // Constructors
    public Task(int id, String title, String status) {
        validateId(id);
        validateTitle(title);
        validateStatus(status);
        this.id = id;
        this.title = title;
        this.status = status;
    }

    // Getters
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getStatus() {
        return this.status;
    }

    // Setters
    public void setId(int id) {
        validateId(id);
        this.id = id;
    }
    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }
    public void setStatus(String status) {
        validateStatus(status);
        this.status = status;
    }

    // Validations
    public void validateId(int id) {
        if(id <= 0) throw new IllegalArgumentException("ID must be a positive number");
    }
    public void validateTitle(String title) {
        if(title == null || title.isEmpty()) throw new IllegalArgumentException("Title must not be empty");
    }
    public void validateStatus(String status) {
        if(status == null || status.isEmpty() || 
        (!status.equalsIgnoreCase("Yet to start") &&
        !status.equalsIgnoreCase("In Progress") &&
        !status.equalsIgnoreCase("Completed"))) throw new IllegalArgumentException("Status invalid. Allowed : [Yet to start, In Progress, Completed]");
    }
}