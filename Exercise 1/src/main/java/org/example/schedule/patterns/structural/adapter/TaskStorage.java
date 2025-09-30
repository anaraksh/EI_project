package org.example.ei.storage;

import org.example.ei.model.Task;
import java.util.List;

public interface TaskStorage {
    void save(List<Task> tasks) throws Exception;
    List<Task> load() throws Exception;
}
