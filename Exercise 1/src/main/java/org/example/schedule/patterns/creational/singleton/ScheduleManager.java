package org.example.ei.service;

import org.example.ei.model.Task;
import org.example.ei.patterns.observer.Observer;
import org.example.ei.storage.InMemoryStorage;
import org.example.ei.storage.TaskStorage;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private static volatile ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();
    private TaskStorage storage = new InMemoryStorage();

    private ScheduleManager() { }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) instance = new ScheduleManager();
            }
        }
        return instance;
    }

    public synchronized void setStorage(TaskStorage storage) { this.storage = storage; }

    public synchronized void addTask(Task t) {
      
        for (Task existing : tasks) {
            if (existing.getStart().isBefore(t.getEnd()) && t.getStart().isBefore(existing.getEnd())) {
                notifyAllObservers("Task \"" + t.getDescription() + "\" overlaps with \"" + existing.getDescription() + "\"");
            }
        }
        tasks.add(t);
        try { storage.save(tasks); } catch (Exception e) { System.err.println("Save failed: " + e.getMessage()); }
    }

    public synchronized List<Task> getTasks() { return new ArrayList<>(tasks); }

    public synchronized void loadFromStorage() {
        try {
            List<Task> loaded = storage.load();
            tasks.clear();
            tasks.addAll(loaded);
        } catch (Exception e) { System.err.println("Load failed: " + e.getMessage()); }
    }

    public void registerObserver(Observer o) { observers.add(o); }
    private void notifyAllObservers(String message) { observers.forEach(o -> o.update(message)); }
}
