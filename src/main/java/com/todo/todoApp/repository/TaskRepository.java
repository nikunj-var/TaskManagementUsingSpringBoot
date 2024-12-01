package com.todo.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.todoApp.models.Task;;


public interface TaskRepository extends JpaRepository<Task,Long>{

    
    
} 


