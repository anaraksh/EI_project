package org.example.ei.factory;

import org.example.ei.model.Priority;
import org.example.ei.model.Task;

import java.time.LocalTime;

public class TaskFactory {
    public static Task create(String desc, LocalTime start, LocalTime end, Priority p) {
        if (desc == null || desc.trim().isEmpty()) throw new IllegalArgumentException("Description empty");
        if (end.isBefore(start) || end.equals(start)) throw new IllegalArgumentException("End time must be after start time");
        return new Task(desc.trim(), start, end, p);
    }
}
