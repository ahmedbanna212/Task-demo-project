package com.example.demo.Entity;

import com.example.demo.Entity.Enum.TaskStateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class TaskState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TaskStateEnum state ;
    private long task_id;

    @OneToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Task task;
    

    public TaskState(Task task) {
        this.task_id = task.getId();
        this.state = TaskStateEnum.IN_PROGRESS;
    }


    

    public TaskState() {
    }

    public long getTask_id() {
        return this.task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskStateEnum getState() {
        return this.state;
    }

    public void setState(TaskStateEnum state) {
        this.state = state;
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    
}
