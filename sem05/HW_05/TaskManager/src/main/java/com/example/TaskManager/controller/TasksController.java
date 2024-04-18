package com.example.TaskManager.controller;


import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.TaskStatus;
import com.example.TaskManager.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * РестКонтроллер вебприложения по упровлению задачами
 */
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TasksController {
    private TasksService service;

    /**
     * Добавление задачи
     *
     * @param task новая задача
     * @return задача
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.createTask(task);
    }

    /**
     * Получение списка всех задачь
     *
     * @return список задачь
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    /**
     * Поиск задачь по статусу
     *
     * @param status статус задачи NOT_STARTED, IN_PROGRESS, COMPLETED
     * @return список задачь согласно фильтру
     */
    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTaskByStatus(status);
    }

    /**
     * Редактирование статуса задачи
     * @param id идентификатор задачи
     * @param task обновлённая задача
     * @return задача
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }

    /**
     * Удаление задачи по идентификатору
     * @param id идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteById(id);
    }

}
