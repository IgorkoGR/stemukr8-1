package com.mathpar.web.db.entity;

public class Task {

    public long id;
    public String taskTitle;
    public String task;

    public Task() {

    }

    public Task(long id, String taskTitle, String task) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.task = task;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}
