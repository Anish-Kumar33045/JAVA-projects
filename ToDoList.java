import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList<String> toDoList = new ArrayList<>();

    
     public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        System.out.println(" Welcome Amruth raj , to the To-Do List Application ");

        while (running) {
            System.out.println("Choose an option : ");
            System.out.println("1. Add a task");
            System.out.println("2. View all tasks");
            System.out.println("3. Delete a task");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            input.nextLine();  

            switch (choice) {
                case 1:
                    addTask(input);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask(input);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the application ");
                    break;
                default:
                    System.out.println("Invalid choice*. Please try again.");
            }
        }
        
        input.close();
    }
        
    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task : ");
        String task = scanner.nextLine();
        toDoList.add(task);
   
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        if (!toDoList.isEmpty()) {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine();  

            if (taskNumber > 0 && taskNumber <= toDoList.size()) {
                toDoList.remove(taskNumber - 1);
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Invalid task number. Please try again.");
            }
        }
    }
}