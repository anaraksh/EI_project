package org.example.ei.model;

import java.time.LocalTime;
import java.util.UUID;

public class Task {
    private String id;
    private String description;
    private LocalTime start;
    private LocalTime end;
    private Priority priority;
    private boolean completed = false;

    public Task() { }

    public Task(String description, LocalTime start, LocalTime end, Priority priority) {
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
    public Priority getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String toString() {
        String shortId = id == null ? "null" : id.substring(0, Math.min(6, id.length()));
        return String.format("[%s] %s (%s - %s) priority=%s completed=%s",
                shortId, description, start, end, priority, completed);
    }
}
