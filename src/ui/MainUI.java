package ui;

import javafx.scene.layout.BorderPane;
import model.TaskManager;

public class MainUI {
    private BorderPane root;
    private TaskView taskView;
    private TaskManager taskManager;

    public MainUI() {
        root = new BorderPane();
        taskManager = new TaskManager();
        taskView = new TaskView();

        taskView.loadTasks(taskManager.getTasks());

        AddTaskForm form = new AddTaskForm(task -> {
            taskManager.addTask(task);
            taskView.addTask(task);
        });

        root.setLeft(form);
        root.setCenter(taskView);
    }

    public BorderPane getRoot() {
        return root;
    }
}