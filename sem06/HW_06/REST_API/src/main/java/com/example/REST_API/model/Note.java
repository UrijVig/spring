package com.example.REST_API.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String heading;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false, name = "data_of_creation")
    private LocalDateTime dateOfCreation;

    public Note(String heading, String content){
        this.content = content;
        this.heading = heading;
    }

    @PrePersist
    public void addBeforeCreation(){
        this.dateOfCreation = LocalDateTime.now();
    }
}
