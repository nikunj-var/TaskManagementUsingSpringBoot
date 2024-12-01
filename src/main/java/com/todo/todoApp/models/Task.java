package com.todo.todoApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean completed;
    


    
    public Long getId() {
        return id;
    }

   
    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isCompleted() {
        return completed;
    }


    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}