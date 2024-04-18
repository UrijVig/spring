package com.example.TaskManager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Объект/сущность задачи
 * @id мдентификатор
 * @description описание задачи
 * @status статус выполнения задачи
 * @dateOfCreate дата создания задачи
 */
@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column
    private TaskStatus status;
    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;

    /**
     * Автоматическое заполнение полей status и dateOfCreate перед добавлением объекта в базу данных
     * Таким образом через POST запросы можно передавать только описание задачи
     * {"description":"описание задачи"}
     */
    @PrePersist
    private void onCreate(){
        status = TaskStatus.NOT_STARTED;
        dateOfCreate = LocalDateTime.now();
    }
}
