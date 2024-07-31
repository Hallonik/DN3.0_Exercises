package Algorithm_DataStructures.Exercise5.Task_Management_System;

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskManager {
    Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task prev = null;
        while (current != null && current.taskId != taskId) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task with ID " + taskId + " not found.");
        } else {
            prev.next = current.next;
            System.out.println("Task deleted successfully.");
        }
    }
}

public class TMS {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask(1, "Task 1", "Pending");
        taskManager.addTask(2, "Task 2", "Completed");
        taskManager.addTask(3, "Task 3", "In Progress");

        System.out.println("\nTraversing all tasks:");
        taskManager.traverseTasks();

        System.out.println("\nSearch for task with ID 2:");
        Task foundTask = taskManager.searchTask(2);
        if (foundTask != null) {
            System.out.println("Task found: Task ID - " + foundTask.taskId + ", Task Name - " + foundTask.taskName + ", Status - " + foundTask.status);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID 2:");
        taskManager.deleteTask(2);

        System.out.println("\nTraversing all tasks after deletion:");
        taskManager.traverseTasks();
    }
}


