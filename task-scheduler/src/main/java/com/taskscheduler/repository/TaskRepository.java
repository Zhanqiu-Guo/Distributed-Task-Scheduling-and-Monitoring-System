package com.taskscheduler.repository;

import com.taskscheduler.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedUser_Id(Long userId);
    List<Task> findByStatus(Task.TaskStatus status);
    
    @Query("SELECT t FROM Task t WHERE t.status = 'PENDING' AND " +
           "(t.dependentTask IS NULL OR t.dependentTask.status = 'COMPLETED')")
    List<Task> findExecutableTasks();
    
    List<Task> findByStatusAndScheduledTimeBefore(Task.TaskStatus status, LocalDateTime threshold);
    List<Task> findByStatusAndCompletedTimeBefore(Task.TaskStatus status, LocalDateTime threshold);
}
