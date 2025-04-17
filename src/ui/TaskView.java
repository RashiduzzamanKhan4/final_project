package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.Task;
import java.util.List;

public class TaskView extends VBox {
    private ObservableList<Task> taskList;
    private ListView<Task> listView;
// Commented to save the user's input..
//     public TaskView() {
//         taskList = FXCollections.observableArrayList();
//         listView = new ListView<>(taskList);
//         getChildren().add(listView);
//     }

//     public void addTask(Task task) {
//         taskList.add(task);
//     }
// }

public TaskView() {
    taskList = FXCollections.observableArrayList();
    listView = new ListView<>(taskList);
    listView.setOnMouseClicked(event -> {
        Task selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Task Details");
            alert.setHeaderText(selected.getTitle());
            alert.setContentText("Description: " + selected.getDescription() + 
                                 "\nDue Date: " + selected.getDueDate() +
                                 (selected.isCompleted() ? "\nStatus: Completed" : ""));
            alert.showAndWait();
        }
    });
    getChildren().add(listView);
}

public void addTask(Task task) {
    taskList.add(task);
}

public void loadTasks(List<Task> tasks) {
    taskList.setAll(tasks);
}
}
