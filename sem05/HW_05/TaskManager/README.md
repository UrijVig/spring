## Урок 5. Spring Data для работы с базами данных

Требуется реализовать следующие функции:

1. Добавление задачи. 
    ~~~java
        @PostMapping
        public Task addTask(@RequestBody Task task){
            return service.createTask(task);
        }
    ~~~
2. Просмотр всех задач. 
    ~~~java
        @GetMapping
        public List<Task> getAllTasks(){
            return service.getAllTasks();
        }
    ~~~
3. Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").
    ~~~java
        @GetMapping("/{status}")
        public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
            return service.getTaskByStatus(status);
        }
    ~~~
4. Изменение статуса задачи.
    ~~~java
        @PutMapping("/{id}")
        public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
            return service.updateTask(id, task);
        }
    ~~~
5. Удаление задачи.
    ~~~java
        @DeleteMapping("/{id}")
        public void deleteTask(@PathVariable Long id){
            service.deleteById(id);
        }
    ~~~

6. Структура задачи(класс [Task](https://github.com/UrijVig/spring/blob/master/sem05/HW_05/TaskManager/src/main/java/com/example/TaskManager/model/Task.java)):
    - ID (автоинкрементное)(тип Long)
    - Описание (не может быть пустым)(тип String)
    - Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип [TaskStatus](https://github.com/UrijVig/spring/blob/master/sem05/HW_05/TaskManager/src/main/java/com/example/TaskManager/model/TaskStatus.java) )
    - Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

> Классы для обработыки информации о задачах:  
    [TasksRepository](https://github.com/UrijVig/spring/blob/master/sem05/HW_05/TaskManager/src/main/java/com/example/TaskManager/reporitory/TasksRepository.java)  
    [TasksService](https://github.com/UrijVig/spring/blob/master/sem05/HW_05/TaskManager/src/main/java/com/example/TaskManager/service/TasksService.java)  
    [TasksController](https://github.com/UrijVig/spring/blob/master/sem05/HW_05/TaskManager/src/main/java/com/example/TaskManager/controller/TasksController.java)
