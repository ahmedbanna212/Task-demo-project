package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TaskDTO;
import com.example.demo.Entity.Task;

import com.example.demo.Service.TaskService;


@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @RequestMapping("/getTask")
    public ResponseEntity<List<TaskDTO>> task() {
        return new ResponseEntity<>(taskService.getAllTasksAndStates(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value="/addTask")
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.OK);
        
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable  Long id) {
        return new ResponseEntity<>(taskService.deleteTask(id ), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/updateTask/{id}")
    public ResponseEntity<?> updateTask(@PathVariable  Long id,@RequestBody TaskDTO task) {
        return new ResponseEntity<>(taskService.DybamicUpdate(id,task), HttpStatus.OK);
    }
  
    
}
