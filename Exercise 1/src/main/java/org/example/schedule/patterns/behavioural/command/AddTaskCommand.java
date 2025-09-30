package org.example.ei.patterns.command;

import org.example.ei.model.Task;
import org.example.ei.service.ScheduleManager;

public class AddTaskCommand implements Command {
    private final ScheduleManager manager;
    private final Task task;

    public AddTaskCommand(ScheduleManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

  
    public void execute() {
        manager.addTask(task);
    }
}
