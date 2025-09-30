package org.example.schedule.factory;

import org.example.schedule.model.Task;
import java.time.LocalTime;

public class TaskFactory {
    public static Task create(String description, String start, String end, String priority) {
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);

        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }
        return new Task(description, startTime, endTime, priority);
    }
}
