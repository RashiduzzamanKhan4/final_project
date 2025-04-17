package model;

import java.time.LocalDate;

public class WorkTask extends Task {
    public WorkTask(String title, String description, LocalDate dueDate) {
        super(title, "[Work] " + description, dueDate);
    }
}
