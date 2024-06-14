package com.example.REST_API.controller;

import com.example.REST_API.model.Note;
import com.example.REST_API.service.NotesService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NotesRestController {

    private final NotesService service;

    private final Counter addNoneCounter = Metrics.counter("add_note_counter");
    /**
     * Создает новую заметку.
     * Принимает параметры из тела запроса и возвращает созданную заметку.
     * URL: /api/notes
     * HTTP метод: POST
     *
     * @param note Заметка для создания
     * @return ResponseEntity с созданной заметкой и статусом CREATED
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        addNoneCounter.increment();
        return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
    }
    /**
     * Получает все заметки.
     * Возвращает список всех существующих заметок.
     * URL: /api/notes
     * HTTP метод: GET
     *
     * @return ResponseEntity со списком всех заметок и статусом OK
     */
    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes(){
        return new ResponseEntity<>(service.findAllNotes(), HttpStatus.OK);
    }
    /**
     * Получает заметку по ID.
     * Возвращает заметку с указанным ID.
     * URL: /api/notes/{id}
     * HTTP метод: GET
     *
     * @param id ID заметки
     * @return ResponseEntity с заметкой и статусом OK, или пустой ResponseEntity и статус BAD_REQUEST, если не найдено
     */
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
    /**
     * Обновляет существующую заметку.
     * Принимает параметры из тела запроса и возвращает обновленную заметку.
     * URL: /api/notes
     * HTTP метод: PUT
     *
     * @param note Обновленная заметка
     * @return ResponseEntity с обновленной заметкой и статусом OK
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(service.updateNote(note), HttpStatus.OK);
    }
    /**
     * Удаляет существующую заметку по ID.
     * Удаляет заметку с указанным ID.
     * URL: /api/notes/{id}
     * HTTP метод: DELETE
     *
     * @param id ID заметки для удаления
     * @return ResponseEntity с пустым телом и статусом OK
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }
}
