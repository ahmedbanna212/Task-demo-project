package com.example.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.Entity.Task;
import com.example.demo.Repository.TaskRepo;
import com.example.demo.Repository.TaskStateRepo;
import com.example.demo.Entity.TaskState;

@Service
public class TaskService {

    @Autowired
    private final TaskRepo repo;
    private final TaskStateRepo taskStateRepo;

    public TaskService(TaskRepo repo, TaskStateRepo taskStateRepo) {
        this.repo = repo;
        this.taskStateRepo = taskStateRepo;

    }

    public boolean addTask(Task task) {
        
        if(!(repo.findById(task.getId()).isPresent())) {
            repo.save(task);
            taskStateRepo.save(new TaskState(task));
        }
        return true;
       
    }

    public List<TaskDTO> getAllTasksAndStates() {
        return taskStateRepo.getAllTasksAndStates();
    }

    public boolean deleteTask(Long id) {
        if(repo.findById(id).isPresent()) {
            repo.deleteById(id);
        }
        return true;
        
    }

    public boolean updateTask(Long id,String Subject) {
        if(repo.findById(id).isPresent()) {
            Task task = repo.findById(id).get();
            task.setSubject(Subject);
            repo.save(task);
        }
        return true;
    }
    public boolean DybamicUpdate(Long id,TaskDTO taskDTO) {
        if(repo.findById(id).isPresent()) {
            if(taskDTO.getTask()!=null) {
                if(taskDTO.getTask().getSubject()!=null) {
                    Task task = repo.findById(id).get();
                    task.setSubject(taskDTO.getTask().getSubject());
                    repo.save(task);
                }
                if(taskDTO.getTask().getDescription()!=null) {
                    Task task = repo.findById(id).get();
                    task.setDescription(taskDTO.getTask().getDescription());
                    repo.save(task);
                }
            }
            if(taskDTO.getTaskState()!=null) {
                TaskState taskState = taskStateRepo.getByTask_id(id);
                    if(taskDTO.getTaskState().getState()!=null){
                    taskState.setState(taskDTO.getTaskState().getState());
                    taskStateRepo.save(taskState);
                ;}
                
            }
        }        
            return true;
    }
}
