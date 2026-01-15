package com.jonah.planner.service;

import com.jonah.planner.NoteMapper;
import com.jonah.planner.domain.Note;
import com.jonah.planner.dto.NoteRequestDTO;
import com.jonah.planner.dto.NoteResponseDTO;
import com.jonah.planner.exception.NoteNotFoundException;
import com.jonah.planner.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public List<NoteResponseDTO> getNotes() {
        return noteMapper.toResponseDtoList(noteRepository.findAll());
    }

    public NoteResponseDTO createNote(NoteRequestDTO noteRequestDTO) {
        Note note = noteMapper.toEntity(noteRequestDTO);
        return noteMapper.toResponseDto(noteRepository.save(note));
    }

    public NoteResponseDTO getNoteByID(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return noteMapper.toResponseDto(note);
    }

    public List<NoteResponseDTO> searchNoteByTitle(String title) {
        String noteSearch;

        if (title == null) {
            noteSearch = "";
        } else {
            noteSearch = title.trim();
        }

        if (noteSearch.isEmpty()) {
            return List.of();
        }

        return noteMapper.toResponseDtoList(
                noteRepository.findByTitleContainingIgnoreCase(noteSearch)
        );
    }

    public NoteResponseDTO updateNote(Long id, NoteRequestDTO updatedNote) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        existingNote.setTitle(updatedNote.getTitle());
        return noteMapper.toResponseDto(noteRepository.save(existingNote));
    }

    public void deleteNote(Long id) {
        getNoteByID(id);
        noteRepository.deleteById(id);
    }
}
