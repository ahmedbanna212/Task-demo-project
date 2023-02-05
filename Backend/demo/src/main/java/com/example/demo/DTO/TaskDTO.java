package com.example.demo.DTO;
import  com.example.demo.Entity.Task;
import  com.example.demo.Entity.TaskState;
public class TaskDTO {
    private Task task;
    private TaskState taskState;
    public TaskDTO() {
    }
    public TaskDTO(Task task, TaskState taskState) {
        this.task = task;
        this.taskState = taskState;
    }
    public Task getTask() {
        return this.task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    public TaskState getTaskState() {
        return this.taskState;
    }
    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }
    
}
