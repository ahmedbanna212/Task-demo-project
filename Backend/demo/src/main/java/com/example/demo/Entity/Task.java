package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity

public class Task {
    @Id
    private Long id;
    private String Subject;
    private String Description;
    @OneToOne(mappedBy="task" ,cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, optional = false)
    private TaskState taskState;
    
    public Task() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 

    public String getSubject() {
        return this.Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
   

}
