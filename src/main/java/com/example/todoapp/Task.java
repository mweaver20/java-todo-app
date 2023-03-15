package com.example.todoapp;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks", schema = "NewTodoList", catalog = "")
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "taskID")
    private int taskId;
    @Basic
    @Column(name = "taskDescription")
    private String taskDescription;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != task.taskId) return false;
        if (taskDescription != null ? !taskDescription.equals(task.taskDescription) : task.taskDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (taskDescription != null ? taskDescription.hashCode() : 0);
        return result;
    }
}
