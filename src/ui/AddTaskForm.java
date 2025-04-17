package ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import model.*;
import java.time.LocalDate;
import java.util.function.Consumer;

public class AddTaskForm extends VBox {
    public AddTaskForm(Consumer<Task> onAdd) {
        setPadding(new Insets(10));
        setSpacing(10);

        TextField titleField = new TextField();
        titleField.setPromptText("Task Title");

        TextArea descField = new TextArea();
        descField.setPromptText("Task Description");

        DatePicker datePicker = new DatePicker();
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Work", "Study", "Personal");

        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> {
            String title = titleField.getText();
            String desc = descField.getText();
            LocalDate date = datePicker.getValue();
            String cat = categoryBox.getValue();

            if (title.isEmpty() || desc.isEmpty() || date == null || cat == null) {
                util.UIHelper.showAlert("Error", "Please fill all fields.");
                return;
            }

            Task task;
            switch (cat) {
                case "Work": task = new WorkTask(title, desc, date); break;
                case "Study": task = new StudyTask(title, desc, date); break;
                default: task = new PersonalTask(title, desc, date); break;
            }
            onAdd.accept(task);
        });

        getChildren().addAll(titleField, descField, datePicker, categoryBox, addButton);
    }
}
