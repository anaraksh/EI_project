package org.example.ei.decorator;

import org.example.ei.model.Task;
import org.example.ei.storage.TaskStorage;

import java.util.List;

public class LoggingStorageDecorator implements TaskStorage {
    private final TaskStorage inner;

    public LoggingStorageDecorator(TaskStorage inner) {
        this.inner = inner;
    }

   
    public void save(List<Task> tasks) throws Exception {
        System.out.println("[LOG] Saving " + tasks.size() + " tasks");
        inner.save(tasks);
    }


    public List<Task> load() throws Exception {
        System.out.println("[LOG] Loading tasks");
        return inner.load();
    }
}
