package com.example.REST_API.service;

import com.example.REST_API.model.Note;
import com.example.REST_API.repository.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesService {
    private final NotesRepository repository;

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public List<Note> findAllNotes() {
        return repository.findAll();
    }

    public Note findNotesById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Note updateNote(Note note){
        Note oldNote = findNotesById(note.getId());
        oldNote.setHeading(note.getHeading());
        oldNote.setContent(note.getContent());

        return repository.save(oldNote);
    }

    public void deleteNoteById(Long id){
        repository.deleteById(id);
    }
}
