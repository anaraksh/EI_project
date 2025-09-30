EXERCISE 1
BEHAVIOURAL DESIGN PATTERN
1. Task Scheduling System – Observer Pattern

Use Case
This console-based application allows users to add tasks and get notified whenever the schedule is updated. It ensures that multiple observers (like console notifiers) are always in sync with the task list.

Design Pattern
The application uses the Observer Design Pattern, establishing a one-to-many dependency between a subject and its observers. Whenever the subject’s state changes, all registered observers are updated automatically.

Relation to the Use Case

Subject: ScheduleManager (maintains tasks and notifies observers)

Observers: Classes implementing Observer, such as ConsoleNotifier

Classes

ScheduleManager: Manages task list, observers, and notifications

Task: Represents an individual task with attributes like description, priority, start/end time, and completion status

Observer: Interface for observer classes

ConsoleNotifier: Prints updates to the console

Main: Entry point for running the scheduler

2. Task Command Execution – Command Pattern

Use Case
Encapsulates operations such as adding tasks into command objects. Commands can be executed, queued, or undone.

Design Pattern
The Command Pattern is used, allowing requests to be treated as objects and executed flexibly.

Relation to the Use Case

Command Interface → defines execute()

Concrete Commands → AddTaskCommand

Invoker → executes commands

Classes

Command: Interface for commands

AddTaskCommand: Concrete command to add a task

Invoker: Executes commands

Task: Represents the domain object

CREATIONAL DESIGN PATTERNS
1. Schedule Manager – Singleton Pattern

Use Case
Ensures only one instance of the task scheduler exists.

Design Pattern
Singleton Pattern provides a single global point of access to the ScheduleManager.

Classes

ScheduleManager: Singleton managing tasks

2. Task Creation – Factory Pattern

Use Case
Creates tasks of different priorities via a centralized factory.

Design Pattern
Factory Pattern abstracts object creation from the client.

Classes

TaskFactory: Creates tasks

Task: Domain object

Priority: Enum for task priority

STRUCTURAL DESIGN PATTERNS
1. Task Storage – Adapter Pattern

Use Case
Tasks can be stored in memory or JSON files via a common interface.

Design Pattern
Adapter Pattern bridges different storage implementations.

Classes

TaskStorage: Storage interface

InMemoryStorage: Stores tasks in memory

JsonFileStorageAdapter: Adapts file storage to TaskStorage

2. Storage Logging – Decorator Pattern

Use Case
Logs storage operations without changing core storage logic.

Design Pattern
Decorator Pattern extends storage functionality dynamically.

Classes

LoggingStorageDecorator: Adds logging to TaskStorage

TaskStorage: Interface implemented by storage classes

EXERCISE 2
Astronaut Daily Schedule Organizer – Singleton, Factory, Observer Patterns

Use Case Overview
This console application helps astronauts organize their daily schedules. Users can add, remove, and view tasks. Tasks include description, start/end time, and priority. The system ensures no overlapping tasks and notifies observers of conflicts.

Functionalities

Task Management: Add, remove, edit tasks

Task Scheduling: View tasks sorted by start time

Notifications: Alert users of conflicts via Observer pattern

Task Completion: Mark tasks as completed

Priority Filtering: View tasks by priority level

1. Singleton Pattern

Purpose
Ensures only one instance of ScheduleManager.

Relation to Use Case
Centralized task management.

Classes Involved

ScheduleManager: Singleton managing all tasks and observers

2. Factory Pattern

Purpose
Creates Task objects without exposing instantiation logic.

Relation to Use Case
Efficiently creates tasks of different priorities.

Classes Involved

TaskFactory: Creates Task objects

Task: Represents a scheduled task

3. Observer Pattern

Purpose
Notifies users of task conflicts or updates.

Relation to Use Case
Alerts users if a task overlaps or is modified.

Classes Involved

Observer: Interface for observers

ConsoleObserver: Prints notifications for conflicts/updates

Classes and Responsibilities

ScheduleManager.java: Singleton managing tasks and observers

Task.java: Represents a task with description, start/end time, priority, completion status

TaskFactory.java: Factory creating tasks

Observer.java: Observer interface

ConsoleObserver.java: Observer implementation for console notifications

Main.java / ConsoleApp.java: Entry point for user interaction
