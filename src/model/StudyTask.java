package model;

import java.time.LocalDate;

public class StudyTask extends Task {
    public StudyTask(String title, String description, LocalDate dueDate) {
        super(title, "[Study] " + description, dueDate);
    }
}
