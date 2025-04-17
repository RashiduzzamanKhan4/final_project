package model;

import java.time.LocalDate;

public class PersonalTask extends Task {
    public PersonalTask(String title, String description, LocalDate dueDate) {
        super(title, "[Personal] " + description, dueDate);
    }
}
