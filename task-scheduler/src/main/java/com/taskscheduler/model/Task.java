package com.taskscheduler.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "python_file_path")
    private String pythonFilePath;

    @Column(name = "threads_needed")
    private int threadsNeeded;

    private String arguments;
    
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dependent_task_id")
    private Task dependentTask;

    @Column(name = "scheduled_time")
    private LocalDateTime scheduledTime;

    @Column(name = "completed_time")
    private LocalDateTime completedTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Default constructor
    public Task() {}
    
    public Long getId() {return id;}
    public String getName() {return name;}
    public String getPythonFilePath() {return pythonFilePath;}
    public int getThreadsNeeded() {return threadsNeeded;}
    public String getArguments() {return arguments;}
    public String getDescription() {return description;}
    public TaskPriority getPriority() {return priority;}
    public TaskStatus getStatus() {return status;}
    public User getAssignedUser() {return assignedUser;}
    public Task getDependentTask() {return dependentTask;}
    public LocalDateTime getScheduledTime() {return scheduledTime;}
    public LocalDateTime getCompletedTime() {return completedTime;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}
    
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setPythonFilePath(String pythonFilePath) {this.pythonFilePath = pythonFilePath;}
    public void setThreadsNeeded(int threadsNeeded) {this.threadsNeeded = threadsNeeded;}
    public void setArguments(String arguments) {this.arguments = arguments;}
    public void setDescription(String description) {this.description = description;}
    public void setPriority(TaskPriority priority) {this.priority = priority;}
    public void setStatus(TaskStatus status) {this.status = status;}
    public void setAssignedUser(User assignedUser) {this.assignedUser = assignedUser;}
    public void setDependentTask(Task dependentTask) {this.dependentTask = dependentTask;}
    public void setScheduledTime(LocalDateTime scheduledTime) {this.scheduledTime = scheduledTime;}
    public void setCompletedTime(LocalDateTime completedTime) {this.completedTime = completedTime;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
    
    public enum TaskPriority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
    
    public enum TaskStatus {
        PENDING, RUNNING, COMPLETED, FAILED, CANCELLED, PAUSED, ARCHIVED
    }
}