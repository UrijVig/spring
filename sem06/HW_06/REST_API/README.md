## Урок 6. Проектирование и реализация API для серверного приложения.

Разработайте небольшое веб-приложение на Spring Boot, которое будет представлять из себя сервис для учета личных заметок. Приложение должно поддерживать следующие функции:

Все методы контроллера возвращают ResponseEntity(как на семинаре)


1. Добавление заметки.
~~~java
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }
~~~
2. Просмотр всех заметок.
~~~java
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes(){
        return new ResponseEntity<>(service.findAllNotes(), HttpStatus.OK);
    }
~~~
3. Получение заметки по id.
~~~java
    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Note noteById;
        try {
            noteById = service.findNotesById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }
~~~
4. Редактирование заметки.
~~~java
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(service.updateNote(note), HttpStatus.OK);
    }
~~~
5. Удаление заметки.
~~~java
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }
~~~


Структура заметки ([Note](https://github.com/UrijVig/spring/blob/master/sem06/HW_06/REST_API/src/main/java/com/example/REST_API/model/Note.java))  
* ID (автоинкрементное)(тип - Long)  
* Заголовок (не может быть пустым)(тип - String)  
* Содержимое (не может быть пустым)(тип - String)  
* Дата создания (автоматически устанавливается при создании заметки)(тип - LocalDateTime)
    ~~~java
        @PrePersist
        public void addBeforeCreation(){
            this.dateOfCreation = LocalDateTime.now();
        }
    ~~~
