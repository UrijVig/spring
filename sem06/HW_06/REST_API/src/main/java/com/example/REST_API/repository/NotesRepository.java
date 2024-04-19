package com.example.REST_API.repository;

import com.example.REST_API.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
