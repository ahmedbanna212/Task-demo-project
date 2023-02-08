package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.Entity.Task;

import com.example.demo.Service.TaskService;


@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getTask")
    public ResponseEntity<List<TaskDTO>> task() {
        return new ResponseEntity<>(taskService.getAllTasksAndStates(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
        
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable  Long id) {
        return new ResponseEntity<>(taskService.deleteTask(id ), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<?> updateTask(@PathVariable  Long id,@RequestBody TaskDTO task) {
        return new ResponseEntity<>(taskService.updateTask(id,task), HttpStatus.OK);
    }
  
    
}
