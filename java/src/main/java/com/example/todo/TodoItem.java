package com.example.todo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class TodoItem implements Serializable {

    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDateTime createdAt;

    // Intentional: unused private field
    private int internalId = 0;

    // Intentional: unused import (Date) - field uses LocalDateTime instead
    private Date legacyDate;

    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        String status = isCompleted ? "[x]" : "[ ]";
        return status + " " + title;
    }
}
