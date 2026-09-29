package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/** Interactive examples of ArrayList, HashMap, and FIFO Queue operations. */
public final class CollectionsChallenge {
    private final Scanner scanner;
    private final List<String> tasks = new ArrayList<>();
    private final Map<Integer, String> students = new HashMap<>();
    private final Queue<String> serviceQueue = new LinkedList<>();

    public CollectionsChallenge(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Java Collections Challenge ===");
            System.out.println("1. Manage task list (ArrayList)\n2. Manage student names (HashMap)\n3. Manage service line (Queue)\n4. Exit");
            switch (readInt("Enter your choice: ")) {
                case 1 -> manageTasks();
                case 2 -> manageStudents();
                case 3 -> manageQueue();
                case 4 -> running = false;
                default -> System.out.println("Choose an option from 1 to 4.");
            }
        }
        System.out.println("Collections challenge complete.");
    }

    private void manageTasks() {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- ArrayList: ordered task list --");
            System.out.println("1. Add\n2. Remove by position\n3. Update by position\n4. Search\n5. Display\n6. Back");
            switch (readInt("Enter your choice: ")) {
                case 1 -> {
                    String item = readText("Task to add: ");
                    tasks.add(item);
                    System.out.println("Added: " + item);
                }
                case 2 -> removeTask();
                case 3 -> updateTask();
                case 4 -> searchTask();
                case 5 -> displayTasks();
                case 6 -> back = true;
                default -> System.out.println("Choose an option from 1 to 6.");
            }
        }
    }

    private void removeTask() {
        int index = readInt("Position to remove (starting at 1): ") - 1;
        if (isValidTaskIndex(index)) {
            System.out.println("Removed: " + tasks.remove(index));
        } else {
            System.out.println("No task exists at that position.");
        }
    }

    private void updateTask() {
        int index = readInt("Position to update (starting at 1): ") - 1;
        if (isValidTaskIndex(index)) {
            tasks.set(index, readText("Replacement task: "));
            System.out.println("Task updated.");
        } else {
            System.out.println("No task exists at that position.");
        }
    }

    private void searchTask() {
        String query = readText("Task to search for: ");
        int index = tasks.indexOf(query);
        System.out.println(index >= 0 ? "Found at position " + (index + 1) + "." : "Task not found.");
    }

    private void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("The task list is empty.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        }
    }

    private boolean isValidTaskIndex(int index) {
        return index >= 0 && index < tasks.size();
    }

    private void manageStudents() {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- HashMap: student ID to name --");
            System.out.println("1. Insert or update\n2. Retrieve by ID\n3. Check ID\n4. Display all\n5. Back");
            switch (readInt("Enter your choice: ")) {
                case 1 -> {
                    int id = readInt("Student ID: ");
                    String oldName = students.put(id, readText("Student name: "));
                    System.out.println(oldName == null ? "Student added." : "Student record updated.");
                }
                case 2 -> {
                    int id = readInt("Student ID to retrieve: ");
                    String name = students.get(id);
                    System.out.println(name == null ? "No student found for that ID." : "Student: " + name);
                }
                case 3 -> {
                    int id = readInt("Student ID to check: ");
                    System.out.println(students.containsKey(id) ? "ID exists." : "ID does not exist.");
                }
                case 4 -> displayStudents();
                case 5 -> back = true;
                default -> System.out.println("Choose an option from 1 to 5.");
            }
        }
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records have been added.");
            return;
        }
        System.out.println("Student records:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.printf("%d -> %s%n", entry.getKey(), entry.getValue());
        }
    }

    private void manageQueue() {
        boolean back = false;
        while (!back) {
            System.out.println("\n-- Queue: first in, first out --");
            System.out.println("1. Add customer\n2. Serve next\n3. Peek at next\n4. Display line\n5. Back");
            switch (readInt("Enter your choice: ")) {
                case 1 -> {
                    String customer = readText("Customer name: ");
                    serviceQueue.add(customer);
                    System.out.println(customer + " joined the line.");
                }
                case 2 -> {
                    String served = serviceQueue.poll();
                    System.out.println(served == null ? "The line is empty." : "Now serving: " + served);
                }
                case 3 -> {
                    String next = serviceQueue.peek();
                    System.out.println(next == null ? "The line is empty." : "Next customer: " + next);
                }
                case 4 -> System.out.println(serviceQueue.isEmpty() ? "The line is empty." : "Line: " + serviceQueue);
                case 5 -> back = true;
                default -> System.out.println("Choose an option from 1 to 5.");
            }
        }
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter a whole number.");
            return -1;
        }
    }

    private String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be blank.");
        }
    }
}
