// package model;

// import java.util.ArrayList;
// import java.util.List;

// public class TaskManager {
//     private List<Task> tasks = new ArrayList<>();

//     public void addTask(Task task) {
//         tasks.add(task);
//     }

//     public void removeTask(Task task) {
//         tasks.remove(task);
//     }

//     public List<Task> getTasks() {
//         return tasks;
//     }
// }


package model;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks;
    private final String FILE_PATH = "tasks.txt";

    public TaskManager() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasks();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    private void saveTasks() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.getClass().getSimpleName() + "|" +
                             task.getTitle() + "|" +
                             task.getDescription() + "|" +
                             task.getDueDate().toString() + "|" +
                             task.isCompleted());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasks() {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) return;
    
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
    
                String[] parts = line.split("\\|");
                if (parts.length < 5) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }
    
                try {
                    String type = parts[0];
                    String title = parts[1];
                    String description = parts[2];
                    LocalDate date = LocalDate.parse(parts[3]);
                    boolean completed = Boolean.parseBoolean(parts[4]);
    
                    Task task;
                    switch (type) {
                        case "WorkTask": task = new WorkTask(title, description, date); break;
                        case "StudyTask": task = new StudyTask(title, description, date); break;
                        case "PersonalTask": task = new PersonalTask(title, description, date); break;
                        default:
                            System.out.println("Unknown task type: " + type);
                            continue;
                    }
    
                    if (completed) task.markCompleted();
                    tasks.add(task);
    
                } catch (Exception e) {
                    System.out.println("Skipping error in line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    