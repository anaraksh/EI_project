package org.example.ei.storage;

import org.example.ei.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage implements TaskStorage {
    private List<Task> store = new ArrayList<>();

    public void save(List<Task> tasks) {
        store = new ArrayList<>(tasks);
    }

    public List<Task> load() {
        return new ArrayList<>(store);
    }
}
