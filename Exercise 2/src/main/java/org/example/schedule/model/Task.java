package org.example.schedule.model;

import java.time.LocalTime;
import java.util.UUID;

public class Task {
    private final String id;
    private String description;
    private LocalTime start;
    private LocalTime end;
    private String priority;
    private boolean completed = false; 

    public Task(String description, LocalTime start, LocalTime end, String priority) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.start = start;
        this.end = end;
        this.priority = priority;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void setDescription(String description) { this.description = description; }
    public void setStart(LocalTime start) { this.start = start; }
    public void setEnd(LocalTime end) { this.end = end; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setCompleted(boolean completed) { this.completed = completed; }

   
    public String toString() {
        return String.format("%s - %s: %s [%s] %s",
                start, end, description, priority, (completed ? "(Completed)" : ""));
    }
}
