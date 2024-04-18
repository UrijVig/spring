package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.model.TaskStatus;
import com.example.TaskManager.reporitory.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {
    private final TasksRepository repository;
    /**
     * Получение списка всех задачь
     *
     * @return список задачь
     */
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    /**
     * Поиск задачи по идентификатору
     * @param id идентификатор
     * @return задача
     */
    public Task getTaskById(Long id){
        return repository.findById(id).orElse(null);
    }
    /**
     * Добавление задачи
     *
     * @param task новая задача
     * @return задача
     */
    public Task createTask(Task task){
        return repository.save(task);
    }
    /**
     * Поиск задачь по статусу
     *
     * @param status статус задачи NOT_STARTED, IN_PROGRESS, COMPLETED
     * @return список задачь согласно фильтру
     */
    public List<Task> getTaskByStatus(TaskStatus status){
        return repository.findByStatus(status);
    }
    /**
     * Редактирование статуса задачи
     * @param id идентификатор задачи
     * @param task обновлённая задача
     * @return задача
     */
    public Task updateTask(Long id, Task task){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task modifiedTask = optionalTask.get();
            modifiedTask.setStatus(task.getStatus());
            return repository.save(modifiedTask);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }
    /**
     * Удаление задачи по идентификатору
     * @param id идентификатор задачи
     */
    public void deleteById(Long id){
         repository.deleteById(id);
    }
}

