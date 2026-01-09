package com.jonah.planner.controller;

import com.jonah.planner.domain.Note;

import com.jonah.planner.exception.UserNotFoundException;
import com.jonah.planner.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    private final NoteRepository noterepository;

    NoteController(NoteRepository noteRepository) {
        this.noterepository = noteRepository;
    }

    @GetMapping("/notes")
    List<Note> all() {
        return noterepository.findAll();
    }

    @PostMapping("/notes")
    Note newNote(@RequestBody Note newNote) {
        return noterepository.save(newNote);
    }

    @GetMapping("/notes/{id}")
    Note one(@PathVariable Long id) {
        return noterepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/notes/{id}")
    Note updateNote(@RequestBody Note newNote, @PathVariable Long id) {
        return noterepository.findById(id)
                .map(note -> {
                    note.setTitle(newNote.getTitle());
                    return noterepository.save(note);
                })
                .orElseGet(() -> {
                    return noterepository.save(newNote);
                });
    }

    @DeleteMapping("/notes/{id}")
    void deleteUser(@PathVariable Long id) {
        noterepository.deleteById(id);
    }

}

