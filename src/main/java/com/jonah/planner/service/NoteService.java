package com.jonah.planner.service;

import com.jonah.planner.NoteMapper;
import com.jonah.planner.domain.Note;
import com.jonah.planner.exception.NoteNotFoundException;
import com.jonah.planner.repository.NoteRepository;

import java.util.List;

public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;


    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNoteByID(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public List<Note> searchNoteByTitle(String title) {
        String noteSearch;

        if (title == null) {
            noteSearch = "";
        } else {
            noteSearch = title.trim();
        }

        if (noteSearch.isEmpty()) {
            return List.of();
        }

        return noteRepository.findByTitleContainingIgnoreCase(noteSearch);
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note existingNote = getNoteByID(id);
        existingNote.setTitle(updatedNote.getTitle());
        return noteRepository.save(existingNote);
    }

    public void deleteUser(Long id) {
        getNoteByID(id);
        noteRepository.deleteById(id);
    }
}
