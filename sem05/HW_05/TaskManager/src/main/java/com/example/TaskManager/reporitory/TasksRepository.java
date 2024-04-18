package com.example.TaskManager.reporitory;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

    /**
     * метод поиска задачь по статусу
     * @param status статус
     * @return список задачь согласно фильтру
     */
    List<Task> findByStatus(TaskStatus status);

}
