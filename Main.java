import tasks.Task;
import taskmanager.TaskManager;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager t = new TaskManager();
        int option = 0;
        do {
            System.out.println("""
            Welcome to Team Tracker
            Available Operations
            1.Add Task
            2.Remove Task
            3.Mark task as done
            4.List all tasks
            5.Exit
            Choosing your option by entering its corresponding serial number""");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between [1-5].");
                sc.next(); 
                continue;
            }
            option = sc.nextInt();
            sc.nextLine();

            switch(option) {
                case 1:
                    System.out.println("You have chosen to add task");

                    int id;
                    String title;
                    String status;
                    System.out.println("Enter your task id");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your task title");
                    title = sc.nextLine();
                    System.out.println("Enter your task status");
                    status = sc.nextLine();

                    Task task = new Task(id, title, status);
                    System.out.println(t.addTask(task));
                    break;
                
                case 2:

                    System.out.println("You have chosen to remove task");
                    System.out.println("Enter the task id of the task to be removed");
                    id = sc.nextInt();
                    System.out.println(t.removeTask(id));
                    break;
                
                case 3:

                    System.out.println("You have chosen to mark a task as done");
                    System.out.println("Enter the task id of the task to be marked as done");
                    id = sc.nextInt();
                    System.out.println(t.markAsDone(id));
                    break;

                case 4:
                    System.out.println("You have chosen to list all tasks");
                    t.listTasks();
                    break;
                
                case 5:
                    System.out.println("Exiting console. Bye :)");
                    break;

                default:
                    System.out.println("Invalid option. Enter a number between [1-5]");
                    break;

            }


        }while(option != 5);

        sc.close();
    }
}