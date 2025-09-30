EXERCISE 1

BEHAVIOURAL DESIGN PATTERN
1.Task Scheduling System – Observer Pattern
Use Case

This console-based application allows users to add tasks and get notified whenever the schedule is updated. It ensures that multiple observers (like console notifiers) are always in sync with the task list.

Design Pattern

The application uses the Observer Design Pattern. This pattern establishes a one-to-many dependency between a subject and its observers. Whenever the subject’s state changes, all registered observers are updated automatically.

Relation to the Use Case

Subject: ScheduleManager class which maintains tasks and notifies observers.

Observers: Classes implementing the Observer interface, such as ConsoleNotifier, which get notified of task updates.

Classes

ScheduleManager: Manages task list, observers, and notifications.

Task: Represents an individual task with attributes like description, priority, start/end time, and completion status.

Observer: Interface for observer classes.

ConsoleNotifier: Prints updates to the console when tasks are added or modified.

Main: Entry point of the program to run the scheduler.

2.Task Command Execution – Command Pattern
Use Case

The system allows encapsulating operations such as adding tasks into command objects. Commands can be executed, queued, or undone if needed.

Design Pattern

The Command Pattern is used. It encapsulates requests as objects, allowing them to be parameterized and executed flexibly.

Relation to the Use Case

Command Interface → Defines the execute() method.

Concrete Commands → AddTaskCommand encapsulates adding a task.

Invoker → Executes commands on demand.

Classes

Command: Interface for all command objects.

AddTaskCommand: Concrete command for adding a task.

Invoker: Executes commands given by the user.

Task: Domain object for scheduling.

CREATIONAL DESIGN PATTERNS
1.Schedule Manager – Singleton Pattern
Use Case

The system ensures there is only one instance of the task scheduler throughout the program.

Design Pattern

The Singleton Pattern ensures a single global point of access to the ScheduleManager.

Relation to Use Case

Only one ScheduleManager instance is created and reused across the application.

Classes

ScheduleManager: Implements Singleton to prevent multiple instances.

2.Task Creation – Factory Pattern
Use Case

The system allows creating tasks of different priority levels through a centralized factory, abstracting object creation from the client.

Design Pattern

The Factory Pattern creates Task objects without exposing the instantiation logic.

Classes

TaskFactory: Responsible for creating Task objects.

Task: Domain object created by the factory.

Priority: Enum representing task priority.

STRUCTURAL DESIGN PATTERNS
1.Task Storage – Adapter Pattern
Use Case

The system allows tasks to be stored either in memory or in a JSON file by adapting the storage interface.

Design Pattern

The Adapter Pattern is used to bridge between different storage implementations.

Classes

TaskStorage: Interface for storage operations.

InMemoryStorage: Stores tasks in memory.

JsonFileStorageAdapter: Adapts file-based storage to match TaskStorage interface.

2.Storage Logging – Decorator Pattern
Use Case

The system logs all storage operations (saving, updating tasks) without modifying the core storage logic.

Design Pattern

The Decorator Pattern is used to extend functionality of storage classes dynamically.

Classes

LoggingStorageDecorator: Wraps around TaskStorage to add logging.

TaskStorage: Interface implemented by storage classes.

EXERCISE 2

Astronaut Daily Schedule Organizer – Singleton, Factory, Observer Patterns
Use Case Overview

This console-based application helps astronauts organize their daily schedules. Users can add, remove, and view tasks. Each task includes a description, start time, end time, and priority level. The system ensures no overlapping tasks and notifies observers on conflicts.

Functionalities

Task Management: Add, remove, and edit tasks.

Task Scheduling: View tasks sorted by start time.

Notifications: Notify users of conflicts using the Observer pattern.

Task Completion: Mark tasks as completed.

Priority Filtering: View tasks by specific priority levels.

Design Patterns Used
1. Singleton Pattern

Purpose: Ensures only one instance of ScheduleManager exists.

Relation to Use Case: Centralized management of all tasks.

Classes Involved:

ScheduleManager: Singleton class managing all tasks and observers.

2. Factory Pattern

Purpose: Creates Task objects dynamically without exposing instantiation logic.

Relation to Use Case: Allows creating tasks with different priorities efficiently.

Classes Involved:

TaskFactory: Factory class creating Task objects.

Task: Domain object representing a scheduled task.

3. Observer Pattern

Purpose: Notifies users of task conflicts or updates.

Relation to Use Case: Alerts users if a new task overlaps or is modified.

Classes Involved:

Observer: Interface for observers.

ConsoleObserver: Prints notifications about task conflicts and updates.

Classes and Responsibilities

ScheduleManager.java: Singleton managing tasks and notifying observers.

Task.java: Represents a task with description, start/end time, priority, and completion status.

TaskFactory.java: Factory for creating tasks.

Observer.java: Interface for observers.

ConsoleObserver.java: Observer implementation for console notifications.

Main.java / ConsoleApp.java: Entry point for user interaction.
