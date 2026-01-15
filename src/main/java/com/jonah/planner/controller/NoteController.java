package com.jonah.planner.controller;

import com.jonah.planner.dto.NoteRequestDTO;
import com.jonah.planner.dto.NoteResponseDTO;
import com.jonah.planner.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteResponseDTO> getAllNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/search")
    public List<NoteResponseDTO> searchNotes(@RequestParam(required = false) String title) {
        return noteService.searchNoteByTitle(title);
    }


    @PostMapping
    public NoteResponseDTO createNote(@RequestBody NoteRequestDTO note) {
        return noteService.createNote(note);
    }

    @GetMapping("/{id}")
    public NoteResponseDTO getNote(@PathVariable Long id) {
        return noteService.getNoteByID(id);
    }

    @PutMapping("/{id}")
    public NoteResponseDTO updateNote(
            @PathVariable Long id,
            @RequestBody NoteRequestDTO note
    ) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
