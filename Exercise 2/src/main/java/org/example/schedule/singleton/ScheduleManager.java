package org.example.schedule.singleton;

import org.example.schedule.model.Task;
import org.example.schedule.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        for (Task existing : tasks) {
            if (existing.getStart().isBefore(task.getEnd()) && task.getStart().isBefore(existing.getEnd())) {
                notifyObservers("Task '" + task.getDescription() + "' conflicts with existing task '" + existing.getDescription() + "'");
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully: " + task);
    }

    public void removeTask(String description) {
        Task found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);

        if (found == null) {
            System.out.println("Error: Task not found.");
        } else {
            tasks.remove(found);
            System.out.println("Task removed successfully: " + found.getDescription());
        }
    }

    public void editTask(String description, String newDesc, String newStart, String newEnd, String newPriority) {
        Task found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);

        if (found == null) {
            System.out.println("Error: Task not found.");
            return;
        }

        try {
            found.setDescription(newDesc);
            found.setStart(java.time.LocalTime.parse(newStart));
            found.setEnd(java.time.LocalTime.parse(newEnd));
            found.setPriority(newPriority);
            System.out.println("Task updated successfully: " + found);
        } catch (Exception e) {
            System.out.println("Error editing task: " + e.getMessage());
        }
    }

    public void completeTask(String description) {
        Task found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);

        if (found == null) {
            System.out.println("Error: Task not found.");
        } else {
            found.setCompleted(true);
            System.out.println("Task marked as completed: " + found.getDescription());
        }
    }

    public void viewTasksByPriority(String priority) {
        List<Task> filtered = tasks.stream()
                .filter(t -> t.getPriority().equalsIgnoreCase(priority))
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("No tasks with priority: " + priority);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            tasks.stream()
                    .sorted((a, b) -> a.getStart().compareTo(b.getStart()))
                    .forEach(System.out::println);
        }
    }

    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.notify(message);
        }
    }
}
