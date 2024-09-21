package org.example;
import java.io.*;
import java.time.LocalDateTime;
public class Task {
    private int id;
    private String description;
    private String status; // (todo, in-progress, done)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(String description , int cnt){ // constructor
        this.id = cnt;
        this.description = description;
        this.status = "todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }


    // getter , setter

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public String getStatus(){
        return status;
    }

    public void setDescription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public void setStatus(String status){
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
