<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>



<h1 style="font-size:32px; color:#1E90FF;">EXERCISE 1</h1>

<h2 style="font-size:28px; color:#2E8B57;">BEHAVIOURAL DESIGN PATTERN</h2>

<h3 style="font-size:24px;">1. Task Scheduling System – Observer Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> This console-based application allows users to add tasks and get notified whenever the schedule is updated. Multiple observers (like console notifiers) stay in sync with the task list.
</p>

<p style="font-size:16px;">
<b>Design Pattern:</b> Observer Pattern – establishes a one-to-many dependency between a subject and its observers. Whenever the subject’s state changes, all registered observers are updated automatically.
</p>

<p style="font-size:16px;">
<b>Relation to Use Case:</b><br>
- Subject: <b>ScheduleManager</b> (maintains tasks and notifies observers)<br>
- Observers: Classes implementing <b>Observer</b>, such as <b>ConsoleNotifier</b>
</p>

<p style="font-size:16px;">
<b>Classes:</b><br>
- <b>ScheduleManager</b>: Manages task list, observers, and notifications<br>
- <b>Task</b>: Represents an individual task with description, priority, start/end time, completion status<br>
- <b>Observer</b>: Interface for observer classes<br>
- <b>ConsoleNotifier</b>: Prints updates to console<br>
- <b>Main</b>: Entry point for running the scheduler
</p>

<h3 style="font-size:24px;">2. Task Command Execution – Command Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> Encapsulates operations such as adding tasks into command objects. Commands can be executed, queued, or undone.
</p>

<p style="font-size:16px;">
<b>Design Pattern:</b> Command Pattern – allows requests to be treated as objects and executed flexibly.
</p>

<p style="font-size:16px;">
<b>Relation to Use Case:</b><br>
- Command Interface → defines <b>execute()</b><br>
- Concrete Commands → <b>AddTaskCommand</b><br>
- Invoker → executes commands
</p>

<p style="font-size:16px;">
<b>Classes:</b><br>
- <b>Command</b>: Interface for commands<br>
- <b>AddTaskCommand</b>: Concrete command to add a task<br>
- <b>Invoker</b>: Executes commands<br>
- <b>Task</b>: Represents the domain object
</p>

<h2 style="font-size:28px; color:#2E8B57;">CREATIONAL DESIGN PATTERNS</h2>

<h3 style="font-size:24px;">1. Schedule Manager – Singleton Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> Ensures only one instance of the task scheduler exists.<br>
<b>Design Pattern:</b> Singleton Pattern provides a single global point of access to <b>ScheduleManager</b>.<br>
<b>Classes:</b> <b>ScheduleManager</b> – Singleton managing tasks
</p>

<h3 style="font-size:24px;">2. Task Creation – Factory Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> Creates tasks of different priorities via a centralized factory.<br>
<b>Design Pattern:</b> Factory Pattern abstracts object creation from the client.<br>
<b>Classes:</b><br>
- <b>TaskFactory</b>: Creates tasks<br>
- <b>Task</b>: Domain object<br>
- <b>Priority</b>: Enum for task priority
</p>

<h2 style="font-size:28px; color:#2E8B57;">STRUCTURAL DESIGN PATTERNS</h2>

<h3 style="font-size:24px;">1. Task Storage – Adapter Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> Tasks can be stored in memory or JSON files via a common interface.<br>
<b>Design Pattern:</b> Adapter Pattern bridges different storage implementations.<br>
<b>Classes:</b><br>
- <b>TaskStorage</b>: Storage interface<br>
- <b>InMemoryStorage</b>: Stores tasks in memory<br>
- <b>JsonFileStorageAdapter</b>: Adapts file storage to TaskStorage
</p>

<h3 style="font-size:24px;">2. Storage Logging – Decorator Pattern</h3>

<p style="font-size:16px;">
<b>Use Case:</b> Logs storage operations without changing core storage logic.<br>
<b>Design Pattern:</b> Decorator Pattern extends storage functionality dynamically.<br>
<b>Classes:</b><br>
- <b>LoggingStorageDecorator</b>: Adds logging to TaskStorage<br>
- <b>TaskStorage</b>: Interface implemented by storage classes
</p>

<hr style="border:1px solid #ccc;">

<h1 style="font-size:32px; color:#1E90FF;">EXERCISE 2</h1>

<h2 style="font-size:28px; color:#2E8B57;">Astronaut Daily Schedule Organizer – Singleton, Factory, Observer Patterns</h2>

<p style="font-size:16px;">
<b>Use Case Overview:</b> This console application helps astronauts organize their daily schedules. Users can add, remove, and view tasks. Tasks include description, start/end time, and priority. The system ensures no overlapping tasks and notifies observers of conflicts.
</p>

<h3 style="font-size:24px;">Functionalities</h3>
<ul style="font-size:16px;">
<li>Task Management: Add, remove, edit tasks</li>
<li>Task Scheduling: View tasks sorted by start time</li>
<li>Notifications: Alert users of conflicts via Observer pattern</li>
<li>Task Completion: Mark tasks as completed</li>
<li>Priority Filtering: View tasks by priority level</li>
</ul>

<h3 style="font-size:24px;">1. Singleton Pattern</h3>
<p style="font-size:16px;">
<b>Purpose:</b> Ensures only one instance of <b>ScheduleManager</b>.<br>
<b>Classes:</b> <b>ScheduleManager</b> – Singleton managing all tasks
</p>

<h3 style="font-size:24px;">2. Factory Pattern</h3>
<p style="font-size:16px;">
<b>Purpose:</b> Creates <b>Task</b> objects without exposing instantiation logic.<br>
<b>Classes:</b> <b>TaskFactory</b>, <b>Task</b>
</p>

<h3 style="font-size:24px;">3. Observer Pattern</h3>
<p style="font-size:16px;">
<b>Purpose:</b> Notifies users of task conflicts or updates.<br>
<b>Classes:</b> <b>Observer</b>, <b>ConsoleObserver</b>
</p>

<h3 style="font-size:24px;">Classes and Responsibilities</h3>
<ul style="font-size:16px;">
<li>ScheduleManager.java – Singleton managing tasks and observers</li>
<li>Task.java – Represents a task with description, start/end time, priority, completion status</li>
<li>TaskFactory.java – Factory creating tasks</li>
<li>Observer.java – Observer interface</li>
<li>ConsoleObserver.java – Observer implementation for console notifications</li>
<li>Main.java / ConsoleApp.java – Entry point for user interaction</li>
</ul>

</body>
</html>
