package com.example.demo.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.DTO.TaskDTO;
import com.example.demo.Entity.TaskState;


public interface TaskStateRepo extends JpaRepository<TaskState, Long> {
    
    @Query("SELECT new com.example.demo.DTO.TaskDTO (t, ts) FROM Task t JOIN TaskState ts ON t.id = ts.task_id")
    List<TaskDTO> getAllTasksAndStates();


    TaskState getByTask_id(long Id); 
}
