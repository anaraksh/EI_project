package org.example.schedule.app;

import org.example.schedule.factory.TaskFactory;
import org.example.schedule.model.Task;
import org.example.schedule.observer.ConsoleObserver;
import org.example.schedule.service.ScheduleManager;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConsoleObserver());

        while (true) {
            System.out.println("\n1) Add Task  2) Remove Task  3) View All Tasks  4) Edit Task");
            System.out.println("5) Mark Task as Completed  6) View Tasks by Priority  7) Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Start time (HH:mm): ");
                    String start = sc.nextLine();
                    System.out.print("End time (HH:mm): ");
                    String end = sc.nextLine();
                    System.out.print("Priority (LOW/MEDIUM/HIGH): ");
                    String priority = sc.nextLine();

                    try {
                        Task t = TaskFactory.create(desc, start, end, priority);
                        manager.addTask(t);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter task description to remove: ");
                    String remove = sc.nextLine();
                    manager.removeTask(remove);
                    break;

                case "3":
                    manager.viewTasks();
                    break;

                case "4": 
                    System.out.print("Enter existing task description: ");
                    String oldDesc = sc.nextLine();
                    System.out.print("New description: ");
                    String newDesc = sc.nextLine();
                    System.out.print("New start (HH:mm): ");
                    String newStart = sc.nextLine();
                    System.out.print("New end (HH:mm): ");
                    String newEnd = sc.nextLine();
                    System.out.print("New priority (LOW/MEDIUM/HIGH): ");
                    String newPriority = sc.nextLine();
                    manager.editTask(oldDesc, newDesc, newStart, newEnd, newPriority);
                    break;

                case "5": 
                    System.out.print("Enter task description to mark completed: ");
                    String complete = sc.nextLine();
                    manager.completeTask(complete);
                    break;

                case "6": 
                    System.out.print("Enter priority (LOW/MEDIUM/HIGH): ");
                    String pr = sc.nextLine();
                    manager.viewTasksByPriority(pr);
                    break;

                case "7":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
