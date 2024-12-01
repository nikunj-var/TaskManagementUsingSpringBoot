package com.todo.todoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.todo.todoApp.models.Task;
import com.todo.todoApp.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/all")
    public List<Task> getTasks(@RequestParam(required = false) String param) {
        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    public Task addTasks(@RequestBody Task task) {
        System.out.println("\ntask"+task);
        // Task task1 = new Task();
        // task1.setId(task.getId());
        // task1.setCompleted(task.isCompleted());
        // task1.setTitle(task.getTitle());
        return taskService.save(task);
    }
    
    @DeleteMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id) {
        String ans = taskService.delete(id);
        return ans;
    }
    
    @GetMapping("/{id}/toggle")
    public Task getMethodName(@PathVariable Long id) {
        Task task = taskService.toggleTask(id); 
        return task;
    }
    
    

}
