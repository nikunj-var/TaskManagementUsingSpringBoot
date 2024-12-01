package com.todo.todoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.todo.todoApp.models.Task;
import com.todo.todoApp.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
   @Autowired private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        
      return taskRepository.findAll();
        
    }


    public Task save(Task task1) {
        return taskRepository.save(task1);
    }


    public String delete(Long id) {
         taskRepository.deleteById(id);
         return "task deleted";
      
    }


    public Task toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
        return task;
    }
}
