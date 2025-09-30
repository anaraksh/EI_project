package org.example.ei.app;

import org.example.ei.decorator.LoggingStorageDecorator;
import org.example.ei.factory.TaskFactory;
import org.example.ei.model.Priority;
import org.example.ei.model.Task;
import org.example.ei.patterns.command.AddTaskCommand;
import org.example.ei.patterns.command.Invoker;
import org.example.ei.patterns.observer.ConsoleNotifier;
import org.example.ei.service.ScheduleManager;
import org.example.ei.storage.InMemoryStorage;
import org.example.ei.storage.JsonFileStorageAdapter;
import org.example.ei.storage.TaskStorage;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();

        System.out.print("Use JSON file storage? (y/n): ");
        String useFile = sc.nextLine().trim();
        TaskStorage storage = new InMemoryStorage();
        if (useFile.equalsIgnoreCase("y")) {
            storage = new JsonFileStorageAdapter("tasks.json");
            storage = new LoggingStorageDecorator(storage);
        }
        manager.setStorage(storage);
        manager.registerObserver(new ConsoleNotifier());

        Invoker invoker = new Invoker();

        while (true) {
            System.out.println("\n1) Add Task  2) List Tasks  3) Load from storage  4) Save to storage  5) Exit");
            System.out.print("Choose: ");
            String opt = sc.nextLine().trim();
            if (opt.equals("1")) {
                System.out.print("Description: ");
                String desc = sc.nextLine();
                System.out.print("Start time (HH:mm): ");
                String s = sc.nextLine();
                System.out.print("End time (HH:mm): ");
                String e = sc.nextLine();
                System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                String p = sc.nextLine().trim().toUpperCase();
                try {
                    LocalTime start = LocalTime.parse(s);
                    LocalTime end = LocalTime.parse(e);
                    Priority priority = Priority.valueOf(p);
                    Task t = TaskFactory.create(desc, start, end, priority);
                    AddTaskCommand cmd = new AddTaskCommand(manager, t);
                    invoker.run(cmd); // executes add and triggers storage save
                    System.out.println("Task added.");
                } catch (DateTimeParseException dtpe) {
                    System.out.println("Invalid time format. Use HH:mm (e.g., 07:30).");
                } catch (IllegalArgumentException iae) {
                    System.out.println("Error: " + iae.getMessage());
                }
            } else if (opt.equals("2")) {
                List<Task> tasks = manager.getTasks();
                if (tasks.isEmpty()) System.out.println("No tasks.");
                else tasks.forEach(System.out::println);
            } else if (opt.equals("3")) {
                manager.loadFromStorage();
                System.out.println("Loaded from storage.");
            } else if (opt.equals("4")) {
                try { storage.save(manager.getTasks()); System.out.println("Saved."); } catch (Exception ex) { System.out.println("Save failed: " + ex.getMessage()); }
            } else if (opt.equals("5")) {
                System.out.println("Bye.");
                break;
            } else {
                System.out.println("Unknown option.");
            }
        }
        sc.close();
    }
}
